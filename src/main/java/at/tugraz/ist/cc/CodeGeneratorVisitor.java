package at.tugraz.ist.cc;
import org.antlr.v4.runtime.tree.ParseTree;

import java.awt.*;
import java.util.*;
import java.util.List;

public class CodeGeneratorVisitor extends  JovaBaseVisitor<Integer> {
    private static final int TYPE_INT  = 1;
    private static final int TYPE_BOOL = 2;
    private static final int TYPE_STR  = 3;
    private static final int TYPE_NIX  = 4;

    private static final int MEMBER_ASSIGNMENT = -2;
    private static final int ERROR             = -1;

    private final Map<String, TypeCheckerVisitor.ClassMembers> m_symbol_table;

    private TypeCheckerVisitor.ClassMembers     m_current_class;
    private TypeCheckerVisitor.ClassMembers     m_current_method_invocation_class;
    private TypeCheckerVisitor.MethodDefinition m_current_class_method;

    private final Map<String, List<JasminBaseInstruction>> m_jasmin_instructions = new LinkedHashMap<>();
    private final Map<String, String>                      m_jasmin_type_mapping = new HashMap<>();
    private JasminMethodInstruction                        m_current_method_instruction;

    private final TypeCheckerVisitor m_type_checker;
    private String                   m_current_member_access_class;

    int labelCnt = 0;

    private static class ClassMemberMetaData {
        public ClassMemberMetaData(String class_name, TypeCheckerVisitor.MemberDefinition member_definition) {
            m_class_name        = class_name;
            m_member_definition = member_definition;
        }

        public String                              m_class_name;
        public TypeCheckerVisitor.MemberDefinition m_member_definition;
    }

    //------------------------------------------------------------------------------

    public Map<String, List<JasminBaseInstruction>> getJasminInstructions() {
        return m_jasmin_instructions;
    }

    //------------------------------------------------------------------------------

    private String getJasminType(String type) {
        String member_type = m_jasmin_type_mapping.get(type);
        if (member_type == null)
            member_type = "L" + type + ";";

        return member_type;
    }

    //------------------------------------------------------------------------------

    private Integer getIdentifierType(String identifier) {
        String type = null;
        if (m_current_class.member_definitions.get(identifier) != null)
            type = m_current_class.member_definitions.get(identifier).type;

        if (type == null)
            type = m_current_class_method.local_variables.get(identifier);

        if (type == null)
            type = m_current_class_method.params.get(identifier);

        return m_type_checker.return_getType(type);
    }

    //------------------------------------------------------------------------------

    private Integer getIdentifierIndex(String identifier) {
        if (m_current_class_method == null)
            return MEMBER_ASSIGNMENT;

        int assignment_identifier_index;
        List<String> param_keys     = new ArrayList<>(m_current_class_method.params.keySet());
        List<String> local_keys     = new ArrayList<>(m_current_class_method.local_variables.keySet());
        assignment_identifier_index = param_keys.indexOf(identifier);
        if (assignment_identifier_index == ERROR) {
            assignment_identifier_index = local_keys.indexOf(identifier);

            // TODO: if this is false, we have a member assignment.
            if (assignment_identifier_index != ERROR)
                assignment_identifier_index += param_keys.size();
        }

        // TODO: if this happens, we have a member assignment.
        if (assignment_identifier_index == ERROR)
            return MEMBER_ASSIGNMENT;

        assignment_identifier_index++;

        return assignment_identifier_index;
    }

    //------------------------------------------------------------------------------

    private ClassMemberMetaData searchMember(String class_name, String member_identifier) {
        TypeCheckerVisitor.ClassMembers class_ = m_symbol_table.get(class_name);

        TypeCheckerVisitor.MemberDefinition class_member = class_.member_definitions.get(member_identifier);
        if (class_member != null)
            return new ClassMemberMetaData(class_name, class_member);

        return null;
    }

    //------------------------------------------------------------------------------

    private String searchClassOfMethod(String method_name, List<String> param_types) {
        for (Map.Entry<String, TypeCheckerVisitor.ClassMembers> class_ : m_symbol_table.entrySet()) {
            for (TypeCheckerVisitor.MethodDefinition element : class_.getValue().method_definitions) {
                if (element.method_name.equals(method_name) && Arrays.equals(element.params.values().toArray(), param_types.toArray()))
                    return class_.getKey();
            }
        }

        return null;
    }

    //------------------------------------------------------------------------------

    CodeGeneratorVisitor(TypeCheckerVisitor type_checker) {
        m_type_checker = type_checker;

        m_symbol_table = type_checker.symbol_table;

        m_jasmin_type_mapping.put("int",    "I");
        m_jasmin_type_mapping.put("void",   "V");
        m_jasmin_type_mapping.put("bool",   "Z");
        m_jasmin_type_mapping.put("String", "Ljava/lang/String;");
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitProgram(JovaParser.ProgramContext ctx) {
        for (ParseTree child : ctx.children) {
            visit(child);
            List<JasminBaseInstruction> current_class_jasmin_instructions = m_jasmin_instructions.get(m_current_class.class_name);

            int default_ctor_index = 0;
            for (JasminBaseInstruction element : current_class_jasmin_instructions) {
                if (element.getType() == JasminBaseInstruction.InstructionType.DEFAULT_CTOR) {
                    default_ctor_index = -1;
                    break;
                }
                else if (element.getType() != JasminBaseInstruction.InstructionType.METHOD)
                    default_ctor_index++;
            }

            if (default_ctor_index != -1 && !m_current_class.class_name.equals("Main"))
                current_class_jasmin_instructions.add(default_ctor_index, new JasminDefaultConstructorInstruction());
        }

        return 0;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitClass_decl(JovaParser.Class_declContext ctx) {
        visitChildren(ctx);
        return 0;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitClass_head(JovaParser.Class_headContext ctx) {
        m_current_class                   = m_symbol_table.get(ctx.CLASS_TYPE().getText());
        m_current_method_invocation_class = m_current_class;

        String class_name = ctx.CLASS_TYPE().getText();

        m_jasmin_instructions.put(class_name, new ArrayList<>());

        m_jasmin_instructions.get(class_name).add(new JasminSourceInstruction("noSource"));
        m_jasmin_instructions.get(class_name).add(new JasminClassInstruction(ctx.CLASS_TYPE().getText()));
        m_jasmin_instructions.get(class_name).add(new JasminSuperInstruction());

        return 0;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitClass_body(JovaParser.Class_bodyContext ctx) {
        return visitChildren(ctx);
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitMember_decl(JovaParser.Member_declContext ctx) {
        String member_amod = ctx.AMOD().getText();
        String member_type = getJasminType(ctx.type().getText());

        for (ParseTree children : ctx.id_list().children) {
            if (children.getText().equals(","))
                continue;

            String member_name = children.getText();
            m_jasmin_instructions.get(m_current_class.class_name).add(new JasminFieldInstruction(member_amod,
                                                                                                 member_type,
                                                                                                 member_name));
        }

        return 0;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitMethod_decl(JovaParser.Method_declContext ctx) {
        return visitChildren(ctx);
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitMethod_head(JovaParser.Method_headContext ctx) {
        List<String> param_types = new ArrayList<>();
        if (ctx.params().param_list() != null) {
            for (JovaParser.TypeContext child : ctx.params().param_list().type()) {
                param_types.add(child.getText());
            }
        }


        if (ctx.ID().getText().equals("main") && m_current_class.class_name.equals("Main")) {
            m_current_method_instruction = new JasminMethodInstruction("public static",
                                                                       "main",
                                                                       "[Ljava/lang/String;",
                                                                       "V");
            for (TypeCheckerVisitor.MethodDefinition method : m_current_class.method_definitions) {
                if (method.method_name.equals(ctx.ID().getText()) && Arrays.equals(method.params.values().toArray(), param_types.toArray())) {
                    m_current_class_method = method;
                    break;
                }
            }

        }
        else {
            for (TypeCheckerVisitor.MethodDefinition method : m_current_class.method_definitions) {
                if (method.method_name.equals(ctx.ID().getText()) && Arrays.equals(method.params.values().toArray(), param_types.toArray())) {
                    m_current_class_method = method;
                    break;
                }
            }

            String method_type = getJasminType(m_current_class_method.method_type);
            List<String> jasmin_param_types = new ArrayList<>();
            for (String element : param_types) {
                String jasmin_type = getJasminType(element);
                jasmin_param_types.add(jasmin_type);
            }

            m_current_method_instruction = new JasminMethodInstruction(m_current_class_method.amod,
                                                                       m_current_class_method.method_name,
                                                                       String.join("", jasmin_param_types),
                                                                       method_type);
        }
        m_jasmin_instructions.get(m_current_class.class_name).add(m_current_method_instruction);

        int limit_locals_amount = m_current_class_method.params.size() + m_current_class_method.local_variables.size() + 1;
        limit_locals_amount     *= 2;

        m_current_method_instruction.addMethodInstruction(new JasminLimitInstruction("stack",  limit_locals_amount * 2));
        m_current_method_instruction.addMethodInstruction(new JasminLimitInstruction("locals", limit_locals_amount));
        return 0;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitCtor(JovaParser.CtorContext ctx) {
        String       class_name  = ctx.CLASS_TYPE().getText();
        List<String> param_types = new ArrayList<>();

        if (ctx.params().param_list() != null) {
            for (ParseTree children : ctx.params().param_list().type()) {
                if (children.getText().equals(","))
                    continue;

                param_types.add(children.getText());
            }
        }

        List<String> jasmin_param_types = new ArrayList<>();
        for (String element : param_types) {
            String jasmin_type = getJasminType(element);
            jasmin_param_types.add(jasmin_type);
        }

        for (TypeCheckerVisitor.MethodDefinition method : m_current_class.method_definitions) {
            if (method.method_name.equals(class_name) && Arrays.equals(method.params.values().toArray(), param_types.toArray())) {
                m_current_class_method = method;
                break;
            }
        }

        m_current_method_instruction = new JasminMethodInstruction("public",
                                                                   "<init>",
                                                                   String.join("", jasmin_param_types),
                                                                   "V");

        m_jasmin_instructions.get(class_name).add(m_current_method_instruction);

        int limit_locals_amount = m_current_class_method.params.size() + m_current_class_method.local_variables.size() + 1;
        limit_locals_amount     *= 2;

        m_current_method_instruction.addMethodInstruction(new JasminLimitInstruction("stack",  limit_locals_amount * 2));
        m_current_method_instruction.addMethodInstruction(new JasminLimitInstruction("locals", limit_locals_amount));

        m_current_method_instruction.addMethodInstruction(new JasminALoadZeroInstruction());
        m_current_method_instruction.addMethodInstruction(new JasminInvokeSpecialInstruction("java/lang/Object/<init>()", "V"));

        if (jasmin_param_types.size() == 0) {
            m_current_method_instruction.Type = JasminBaseInstruction.InstructionType.DEFAULT_CTOR;
        }

        visit(ctx.ctor_body());

        m_current_method_instruction.addMethodInstruction(new JasminReturnInstruction());

        return 0;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitMethod_body(JovaParser.Method_bodyContext ctx) {
        return visitChildren(ctx);
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitMethod_invocation(JovaParser.Method_invocationContext ctx) {
        String method_name       = ctx.ID().getText();
        List<String> param_types = new ArrayList<>();

        if (ctx.arg_list() != null) {
            for (ParseTree children : ctx.arg_list().children) {
                if (children.getText().equals(","))
                    continue;

                Integer type = visit(children);
                param_types.add(m_type_checker.exp_getType(type));
            }
        }

        String class_name = searchClassOfMethod(method_name, param_types);

        if (method_name.equals("print") && param_types.size() == 1 &&
            (param_types.contains("String") || param_types.contains("int") || param_types.contains("bool"))) {
            m_current_method_instruction.addMethodInstruction(new JasminGetStaticInstruction("java/lang/System/out", "Ljava/io/PrintStream;"));
            m_current_method_instruction.addMethodInstruction(new JasminSwapInstruction());
            m_current_method_instruction.addMethodInstruction(new JasminInvokeVirtualInstruction("java/io/PrintStream/print",
                                                                                                 m_jasmin_type_mapping.get(param_types.get(0)),
                                                                                                 "V"));
            m_current_method_instruction.addMethodInstruction(new JasminLdcInstruction("0"));
            return TYPE_INT;
        }

        String return_type = "";
        for (TypeCheckerVisitor.MethodDefinition element : m_current_method_invocation_class.method_definitions) {
            if (element.method_name.equals(method_name) && Arrays.equals(element.params.values().toArray(), param_types.toArray())) {
                return_type = element.method_type;
                break;
            }
        }

        String       method_invoke_type = getJasminType(return_type);
        List<String> jasmin_param_types = new ArrayList<>();
        for (String element : param_types) {
            String jasmin_type = getJasminType(element);
            jasmin_param_types.add(jasmin_type);
        }

        if (class_name != null)
            method_name = class_name + "/" + method_name;

        List<JasminBaseInstruction> method_instructions     = m_current_method_instruction.getMethodInstructions();
        JasminBaseInstruction       last_method_instruction = method_instructions.get(method_instructions.size() - 2);
        if (last_method_instruction.getType() != JasminBaseInstruction.InstructionType.ALOAD_0 &&
            m_current_method_invocation_class.class_name.equals(m_current_class.class_name))
            m_current_method_instruction.addMethodInstruction(new JasminALoadZeroInstruction());

        m_current_method_instruction.addMethodInstruction(new JasminInvokeVirtualInstruction(method_name,
                                                                                             String.join("", jasmin_param_types),
                                                                                             method_invoke_type));
        return m_type_checker.return_getType(return_type);
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitLiteral(JovaParser.LiteralContext ctx) {

        if (ctx.STRING_LIT() != null) {
            m_current_method_instruction.addMethodInstruction(new JasminLdcInstruction("" + ctx.getText() + ""));
            return TYPE_STR;
        }
        else if (ctx.INT_LIT() != null) {
            m_current_method_instruction.addMethodInstruction(new JasminLdcInstruction(ctx.getText()));
            return TYPE_INT;
        }
        else if (ctx.BOOL_LIT() != null) {
            String value = ctx.getText().equals("true") ? "1" : "0";
            m_current_method_instruction.addMethodInstruction(new JasminLdcInstruction(value));
            return TYPE_BOOL;
        }

        m_current_method_instruction.addMethodInstruction(new JasminAconstNullInstruction());
        return TYPE_NIX;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitId_expr(JovaParser.Id_exprContext ctx) {
        String                              expr_id   = ctx.ID().getText();
        TypeCheckerVisitor.MemberDefinition id_member = m_current_class.member_definitions.get(expr_id);
        Integer                             id_expr_type;
        String                              local_variable_type = null;

        if (id_member != null)
            id_expr_type = m_type_checker.return_getType(id_member.type);
        else {
            local_variable_type = m_current_class_method.local_variables.get(expr_id);
            if (local_variable_type != null)
                id_expr_type = m_type_checker.return_getType(local_variable_type);
            else
                id_expr_type = m_type_checker.return_getType(m_current_class_method.params.get(expr_id));

            m_current_member_access_class = local_variable_type;
        }

        int id_expr_index = getIdentifierIndex(expr_id);
        if (id_expr_index != ERROR && id_expr_index != MEMBER_ASSIGNMENT) {
            JasminBaseInstruction load_instruction = null;
            if (id_expr_type == TYPE_INT || id_expr_type == TYPE_BOOL)
                load_instruction = new JasminILoadInstruction(id_expr_index);
            else if (id_expr_type > 2)
                load_instruction = new JasminALoadInstruction(id_expr_index);

            if (load_instruction != null)
                m_current_method_instruction.addMethodInstruction(load_instruction);
        }
        else if (id_member != null)
        {
            String member_type = getJasminType(id_member.type);

            m_current_method_instruction.addMethodInstruction(new JasminALoadZeroInstruction());
            m_current_method_instruction.addMethodInstruction(new JasminGetFieldInstruction(m_current_class.class_name,
                                                                                            ctx.ID().getText(),
                                                                                            member_type));

            m_current_member_access_class = id_member.type;
        }

        Integer member_type = null;
        for (ParseTree member_access : ctx.member_access()) {
            member_type = visit(member_access);
        }

        Integer chain_method_invocation_type = null;
        if (ctx.chain_method_invocation() != null) {
            if (local_variable_type != null)
                m_current_method_invocation_class = m_symbol_table.get(local_variable_type);

            chain_method_invocation_type = visit(ctx.chain_method_invocation());
        }

        if (chain_method_invocation_type != null)
            return chain_method_invocation_type;

        if (member_type != null)
            return member_type;

        return id_expr_type;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitMember_access(JovaParser.Member_accessContext ctx) {
        String              member_name  = ctx.ID().getText();
        ClassMemberMetaData class_member = searchMember(m_current_member_access_class, member_name);

        if (class_member != null) {
            if (m_type_checker.return_getType(class_member.m_member_definition.type) >= 4)
                m_current_member_access_class = class_member.m_member_definition.type;

            String field_type = getJasminType(class_member.m_member_definition.type);
            m_current_method_instruction.addMethodInstruction(new JasminGetFieldInstruction(class_member.m_class_name,
                                                                                            member_name,
                                                                                            field_type));

            return m_type_checker.return_getType(class_member.m_member_definition.type);
        }

        m_current_member_access_class = null;
        return null;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitChain_method_invocation(JovaParser.Chain_method_invocationContext ctx) {
        return visitChildren(ctx);
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitObject_alloc(JovaParser.Object_allocContext ctx) {
        String class_name = ctx.CLASS_TYPE().getText();

        m_current_method_instruction.addMethodInstruction(new JasminNewInstruction(class_name));
        m_current_method_instruction.addMethodInstruction(new JasminDupInstruction());

        if (ctx.ctor_args() == null) {
            m_current_method_instruction.addMethodInstruction(new JasminInvokeSpecialInstruction(class_name + "/<init>()", "V"));
            return m_type_checker.return_getType(class_name);
        }

        List<String> param_types = new ArrayList<>();
        if (ctx.ctor_args().arg_list() != null) {
            for (ParseTree children : ctx.ctor_args().arg_list().children) {
                if (children.getText().equals(","))
                    continue;

                Integer type = visit(children);
                param_types.add(m_type_checker.exp_getType(type));
            }
        }

        TypeCheckerVisitor.ClassMembers     ctor_class  = m_symbol_table.get(class_name);
        TypeCheckerVisitor.MethodDefinition target_ctor = null;
        for (TypeCheckerVisitor.MethodDefinition method : ctor_class.method_definitions) {
            if (method.method_name.equals(class_name) && method.params.size() == param_types.size()) {
                int     param_index = 0;
                boolean found_ctor = true;
                for (String param_type : method.params.values()) {
                    if (!m_type_checker.return_getType(param_type).equals(m_type_checker.return_getType(param_types.get(param_index))) &&
                         (m_type_checker.return_getType(param_type) < TYPE_NIX || m_type_checker.return_getType(param_types.get(param_index)) < TYPE_NIX)) {
                        found_ctor = false;
                    }

                    param_index++;
                }

                if (found_ctor) {
                    target_ctor = method;
                    break;
                }
            }
        }

        List<String> jasmin_param_types = new ArrayList<>();
        List<String> param_values       = new ArrayList<>(target_ctor.params.values());
        int          param_index        = 0;

        for (String element : param_types) {
            if (element.equals("nix") && m_type_checker.return_getType(param_values.get(param_index)) >= TYPE_NIX)
                element = param_values.get(param_index);

            String jasmin_type = getJasminType(element);
            jasmin_param_types.add(jasmin_type);
            param_index++;
        }

        m_current_method_instruction.addMethodInstruction(new JasminInvokeSpecialInstruction(class_name + "/<init>(" + String.join("", jasmin_param_types) + ")", "V"));
        return m_type_checker.return_getType(class_name);
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitAssign_stmt(JovaParser.Assign_stmtContext ctx) {
        String assignment_identifier       = ctx.ID().getText();
        int    assignment_identifier_index = getIdentifierIndex(assignment_identifier);
        int    assignment_identifier_type  = getIdentifierType(assignment_identifier);

        if (assignment_identifier_type >= 4)
            m_current_member_access_class = m_type_checker.exp_getType(assignment_identifier_type);

        String jasmin_type = getJasminType(m_type_checker.exp_getType(assignment_identifier_type));

        if (assignment_identifier_index == MEMBER_ASSIGNMENT) {
            if (ctx.object_alloc() == null && ctx.member_access().size() != 0) {
                m_current_method_instruction.addMethodInstruction(new JasminALoadZeroInstruction());
                m_current_method_instruction.addMethodInstruction(new JasminGetFieldInstruction(m_current_class.class_name,
                                                                                                assignment_identifier,
                                                                                                jasmin_type));
            }

            if (ctx.member_access() != null) {
                for (int index = 0; index < ctx.member_access().size(); ++index) {
                    visit(ctx.member_access(index));
                    assignment_identifier = ctx.member_access(index).ID().getText();;
                }
            }

            m_current_method_instruction.addMethodInstruction(new JasminALoadZeroInstruction());
            if (ctx.object_alloc() != null) {
                visit(ctx.object_alloc());
            }
            else {
                visit(ctx.expr());
            }

            jasmin_type = getJasminType(m_type_checker.exp_getType(getIdentifierType(assignment_identifier)));

            if (ctx.member_access().size() != 0)
                m_current_method_instruction.addMethodInstruction(new JasminPutFieldInstruction(m_current_member_access_class,
                                                                                                assignment_identifier,
                                                                                                jasmin_type));
            else
                m_current_method_instruction.addMethodInstruction(new JasminPutFieldInstruction(m_current_class.class_name,
                                                                                                assignment_identifier,
                                                                                                jasmin_type));
        } else {
            if (ctx.object_alloc() == null && ctx.member_access().size() != 0) {
                if (assignment_identifier_type == TYPE_INT || assignment_identifier_type == TYPE_BOOL)
                    m_current_method_instruction.addMethodInstruction(new JasminILoadInstruction(assignment_identifier_index));
                else
                    m_current_method_instruction.addMethodInstruction(new JasminALoadInstruction(assignment_identifier_index));
            }

            String putfield_type = m_current_member_access_class;

            if (ctx.object_alloc() != null)
                visit(ctx.object_alloc());
            else
                visit(ctx.expr());

            if (ctx.member_access() != null) {
                for (int index = 1; index < ctx.member_access().size(); ++index) {
                    visit(ctx.member_access(index));
                    assignment_identifier = ctx.member_access(index).ID().getText();
                }
            }

            if (ctx.member_access().size() != 0) {
                ClassMemberMetaData class_ = searchMember(m_current_member_access_class, assignment_identifier);
                if (class_ == null) {
                    assignment_identifier = ctx.member_access(0).ID().getText();
                    class_                = searchMember(m_current_member_access_class, assignment_identifier);
                }

                jasmin_type = getJasminType(class_.m_member_definition.type);

                m_current_method_instruction.addMethodInstruction(new JasminPutFieldInstruction(putfield_type,
                                                                                                assignment_identifier,
                                                                                                jasmin_type));
            } else {
                if (assignment_identifier_type == TYPE_INT || assignment_identifier_type == TYPE_BOOL)
                    m_current_method_instruction.addMethodInstruction(new JasminIStoreInstruction(assignment_identifier_index));
                else
                    m_current_method_instruction.addMethodInstruction(new JasminAStoreInstruction(assignment_identifier_index));
            }

        }

        return 0;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitRet_stmt(JovaParser.Ret_stmtContext ctx) {
        Integer return_type = visit(ctx.expr());
        if (return_type == null)
            return_type = getIdentifierType(ctx.expr().getText());

        if (m_current_class.class_name.equals("Main")) {
            m_current_method_instruction.addMethodInstruction(new JasminReturnInstruction());
            return 0;
        }

        if (return_type == TYPE_INT || return_type == TYPE_BOOL)
            m_current_method_instruction.addMethodInstruction(new JasminIReturnInstruction());
        else if (return_type > 2)
            m_current_method_instruction.addMethodInstruction(new JasminAReturnInstruction());

        return return_type;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitIf_stmt(JovaParser.If_stmtContext ctx) {
        visit(ctx.expr());
        labelCnt++;
        labelCnt++;
        int labelNr = labelCnt++;

        List<JasminBaseInstruction> method_instructions     = m_current_method_instruction.getMethodInstructions();
        JasminBaseInstruction       last_method_instruction = method_instructions.get(method_instructions.size() - 2);
        if (last_method_instruction.getType() != JasminBaseInstruction.InstructionType.IF_ICMPGT     &&
                last_method_instruction.getType() != JasminBaseInstruction.InstructionType.IF_ICMPEQ &&
                last_method_instruction.getType() != JasminBaseInstruction.InstructionType.IF_ICMPLT &&
                last_method_instruction.getType() != JasminBaseInstruction.InstructionType.IF_ICMPNE &&
                last_method_instruction.getType() != JasminBaseInstruction.InstructionType.IF_ACMPNE &&
                last_method_instruction.getType() != JasminBaseInstruction.InstructionType.IOR       &&
                last_method_instruction.getType() != JasminBaseInstruction.InstructionType.IAND) {

            m_current_method_instruction.addMethodInstruction(new JasminIfeqInstruction("label_IF_" + (labelNr + 1)));
        }

        visit(ctx.compound_stmt(0));

        if (ctx.KEY_ELSE() != null) {
            m_current_method_instruction.addMethodInstruction(new JasminGotoInstruction("label_IF_" + (labelNr + 2)));
            m_current_method_instruction.addMethodInstruction(new JasminLabelInstruction("label_IF_" + (labelNr + 1)));
            visit(ctx.compound_stmt(1));
            m_current_method_instruction.addMethodInstruction(new JasminLabelInstruction("label_IF_" + (labelNr + 2)));
        }
        else
            m_current_method_instruction.addMethodInstruction(new JasminLabelInstruction("label_IF_" + (labelNr + 1)));


        return 0;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitWhile_stmt(JovaParser.While_stmtContext ctx) {
        labelCnt++;
        labelCnt++;
        int labelNr = labelCnt++;
        m_current_method_instruction.addMethodInstruction(new JasminLabelInstruction("label_While_" + labelNr));

        visit(ctx.expr());

        List<JasminBaseInstruction> method_instructions     = m_current_method_instruction.getMethodInstructions();
        JasminBaseInstruction       last_method_instruction = method_instructions.get(method_instructions.size() - 2);
        if (last_method_instruction.getType() != JasminBaseInstruction.InstructionType.IF_ICMPGT &&
            last_method_instruction.getType() != JasminBaseInstruction.InstructionType.IF_ICMPEQ &&
            last_method_instruction.getType() != JasminBaseInstruction.InstructionType.IF_ICMPLT &&
            last_method_instruction.getType() != JasminBaseInstruction.InstructionType.IF_ICMPNE &&
            last_method_instruction.getType() != JasminBaseInstruction.InstructionType.IF_ACMPNE &&
            last_method_instruction.getType() != JasminBaseInstruction.InstructionType.IOR       &&
            last_method_instruction.getType() != JasminBaseInstruction.InstructionType.IAND) {

            m_current_method_instruction.addMethodInstruction(new JasminIfeqInstruction("label_While_" + (labelNr + 1)));
        }

        visit(ctx.compound_stmt());

        m_current_method_instruction.addMethodInstruction(new JasminGotoInstruction("label_While_" + labelNr));
        m_current_method_instruction.addMethodInstruction(new JasminLabelInstruction("label_While_" + (labelNr + 1)));

        return 0;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitExpRelop(JovaParser.ExpRelopContext ctx) {
        int lhs_type = visit(ctx.lhs);
        int rhs_type = visit(ctx.rhs);
        labelCnt++;
        labelCnt++;
        int labelNr = labelCnt++;
        String labelName = "label_Relop_";

        switch(ctx.RELOP().getSymbol().getText()){
            case "<=":
                m_current_method_instruction.addMethodInstruction(new JasminIF_ICMPGTInstruction(labelName + labelNr));
                break;
            case "<":
                m_current_method_instruction.addMethodInstruction(new JasminIF_ICMPGEInstruction(labelName + labelNr));
                break;
            case ">":
                m_current_method_instruction.addMethodInstruction(new JasminIF_ICMPLEInstruction(labelName + labelNr));
                break;
            case "!=":
                m_current_method_instruction.addMethodInstruction(new JasminIF_ICMPEQInstruction(labelName + labelNr));
                break;
            case ">=":
                m_current_method_instruction.addMethodInstruction(new JasminIF_ICMPLTInstruction(labelName + labelNr));
                break;
            case "==":
                if (rhs_type < 4 || lhs_type < 4)
                    m_current_method_instruction.addMethodInstruction(new JasminIF_ICMPNEInstruction(labelName + labelNr));
                else
                    m_current_method_instruction.addMethodInstruction(new JasminIF_ACMPNEInstruction(labelName + labelNr));
                break;
        }

        m_current_method_instruction.addMethodInstruction(new JasminLdcInstruction("1"));
        m_current_method_instruction.addMethodInstruction(new JasminGotoInstruction(labelName + (labelNr + 1)));
        m_current_method_instruction.addMethodInstruction(new JasminLabelInstruction(labelName + labelNr));
        m_current_method_instruction.addMethodInstruction(new JasminLdcInstruction("0"));
        m_current_method_instruction.addMethodInstruction(new JasminGotoInstruction(labelName + (labelNr + 1)));
        m_current_method_instruction.addMethodInstruction(new JasminLabelInstruction(labelName + (labelNr + 1)));

        return TYPE_BOOL;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitExpAdd(JovaParser.ExpAddContext ctx) {
        visit(ctx.lhs);
        visit(ctx.rhs);
        switch(ctx.ADDOP().getSymbol().getText()) {
            case "+":
                m_current_method_instruction.addMethodInstruction(new JasminIADDInstruction());
                break;
            case "-":
                m_current_method_instruction.addMethodInstruction(new JasminISUBInstruction());
                break;
        }

        return TYPE_INT;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitExpMulOp(JovaParser.ExpMulOpContext ctx) {
        visit(ctx.lhs);
        visit(ctx.rhs);
        switch(ctx.MULOP().getSymbol().getText()) {
            case "*":
                m_current_method_instruction.addMethodInstruction(new JasminIMULInstruction());
                break;
            case "/":
                m_current_method_instruction.addMethodInstruction(new JasminIDIVInstruction());
                break;
            case "%":
                m_current_method_instruction.addMethodInstruction(new JasminIREMInstruction());
                break;
        }
        return TYPE_INT;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitExpTernop(JovaParser.ExpTernopContext ctx) {
        visit(ctx.expr(0));
        labelCnt++;
        labelCnt++;
        int labelNr = labelCnt++;

        m_current_method_instruction.addMethodInstruction(new JasminIfneInstruction("label_Ter" + labelNr));
        m_current_method_instruction.addMethodInstruction(new JasminGotoInstruction("label_Ter" + (labelNr + 1)));
        m_current_method_instruction.addMethodInstruction(new JasminLabelInstruction("label_Ter" + labelNr));

        Integer type = visit(ctx.expr(1));

        m_current_method_instruction.addMethodInstruction(new JasminGotoInstruction("label_Ter" + (labelNr + 2)));

        m_current_method_instruction.addMethodInstruction(new JasminLabelInstruction("label_Ter" + (labelNr + 1)));
        visit(ctx.expr(2));
        m_current_method_instruction.addMethodInstruction(new JasminGotoInstruction("label_Ter" + (labelNr + 2)));
        m_current_method_instruction.addMethodInstruction(new JasminLabelInstruction("label_Ter"+ (labelNr + 2)));


        return type;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitExpPrim(JovaParser.ExpPrimContext ctx) {
        return visitChildren(ctx);
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitParan_expr(JovaParser.Paran_exprContext ctx) {
        return visit(ctx.expr());
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitExpOr(JovaParser.ExpOrContext ctx) {
        visit(ctx.lhs);
        visit(ctx.rhs);

        m_current_method_instruction.addMethodInstruction(new JasminIOrInstruction());

        return TYPE_BOOL;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitExpAnd(JovaParser.ExpAndContext ctx) {
        visit(ctx.lhs);
        visit(ctx.rhs);

        m_current_method_instruction.addMethodInstruction(new JasminIAndInstruction());

        return TYPE_BOOL;
    }

    //------------------------------------------------------------------------------


    @Override
    public Integer visitUnary_expr(JovaParser.Unary_exprContext ctx) {
        if(ctx.NOT() != null) {
            int return_type =  visit(ctx.primary_expr());

            String labelName = "label_Unary_";
            labelCnt++;
            labelCnt++;
            int labelNr      = labelCnt++;

            m_current_method_instruction.addMethodInstruction(new JasminIfeqInstruction(labelName + (labelNr + 1)));
            m_current_method_instruction.addMethodInstruction(new JasminLdcInstruction("0"));

            m_current_method_instruction.addMethodInstruction(new JasminGotoInstruction(labelName + (labelNr + 2)));
            m_current_method_instruction.addMethodInstruction(new JasminLabelInstruction(labelName + (labelNr + 1)));
            m_current_method_instruction.addMethodInstruction(new JasminLdcInstruction("1"));
            m_current_method_instruction.addMethodInstruction(new JasminLabelInstruction(labelName + (labelNr + 2)));

            return TYPE_BOOL;
        } else if (ctx.ADDOP() != null) {
            if (ctx.ADDOP().getText().equals("-")) {
                visit(ctx.primary_expr());
                m_current_method_instruction.addMethodInstruction(new JasminINEGInstruction());
            }
        }

        return TYPE_INT;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitPrimary_expr(JovaParser.Primary_exprContext ctx) {
        return visitChildren(ctx);
    }

}
