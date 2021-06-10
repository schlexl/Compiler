package at.tugraz.ist.cc;

import at.tugraz.ist.cc.error.ErrorHandler;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;
import java.util.Map;
import java.util.*;

public class TypeCheckerVisitor extends  JovaBaseVisitor<Integer> {
    private static final int TYPE_INT  = 1;
    private static final int TYPE_BOOL = 2;
    private static final int TYPE_STR  = 3;
    private static final int TYPE_NIX  = 4;
    private static final int TYPE_ERR  = -1;
    private static final int ERROR     = -2;

    // symbol table
    public static class MethodDefinition {
        public String              amod;
        public String              method_type;
        public String              method_name;
        public Map<String, String> params          = new LinkedHashMap<>(); // key: param_identifier value: param type
        public Map<String, String> local_variables = new LinkedHashMap<>(); // key: variable identifier value: variable type
    }

    public static class MemberDefinition {
        public String amod;
        public String type;
    }

    public static class ClassMembers {
        public String                        class_name;
        public Map<String, MemberDefinition> member_definitions = new LinkedHashMap<>(); // key: member identifier; value: member type
        public List<MethodDefinition>        method_definitions = new ArrayList<>();
    }

    public  Map<String, ClassMembers> symbol_table  = new LinkedHashMap<>(); // key: class name
    private ClassMembers              current_class = null;

    private MethodDefinition          current_class_method = null;
    private ClassMembers              current_chain_method_class = null;

    private String current_assignment_identifier;
    private String current_assignment_type;

    private String current_method_access_identifier;

    public Integer current_access_type = null;

    private Map<String, Integer> type_mapping = new LinkedHashMap<>();

    //------------------------------------------------------------------------------
    //------------------------------------------------------------------------------

    public TypeCheckerVisitor() {
        type_mapping.put("int", TYPE_INT);
        type_mapping.put("bool", TYPE_BOOL);
        type_mapping.put("String", TYPE_STR);
        type_mapping.put("nix", TYPE_NIX);
    }

    //------------------------------------------------------------------------------

    public String exp_getType(int type) {

        for (Map.Entry<String, Integer> entry : type_mapping.entrySet()) {
            if (entry.getValue() == type)
                return entry.getKey();
        }

        return "";
    }

    //------------------------------------------------------------------------------

    public Integer return_getType(String type) {
        Integer mapped_type = type_mapping.get(type);

        if (mapped_type != null)
            return mapped_type;

        return TYPE_ERR;
    }

    //------------------------------------------------------------------------------

    private Integer getIdentifierType(String identifier) {
        String type = null;
        if (current_class.member_definitions.get(identifier) != null)
            type = current_class.member_definitions.get(identifier).type;

        if (type == null)
            type = current_class_method.local_variables.get(identifier);

        if (type == null)
            type = current_class_method.params.get(identifier);

        return return_getType(type);
    }

    //------------------------------------------------------------------------------

    private ClassMembers getIdentifierClass(String identifier) {
        String type = null;
        if (current_class.member_definitions.get(identifier) != null)
            type = current_class.member_definitions.get(identifier).type;

        if (type == null)
            type = current_class_method.local_variables.get(identifier);

        if (type == null)
            type = current_class_method.params.get(identifier);

        if (type == null)
            return null;

        return symbol_table.get(type);
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitProgram(JovaParser.ProgramContext ctx) {
        visitChildren(ctx);

        return ErrorHandler.INSTANCE.getNumTypeErrors();
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitClass_decl(JovaParser.Class_declContext ctx) {
        String class_name = ctx.class_head().CLASS_TYPE().getText();
        int line          = ctx.class_head().KEY_CLASS().getSymbol().getLine();
        int char_pos      = ctx.class_head().KEY_CLASS().getSymbol().getCharPositionInLine();

        if (symbol_table.containsKey(class_name)) {
            ErrorHandler.INSTANCE.addClassDoubleDefError(line, char_pos, class_name);
            return ERROR;
        } else {
            ClassMembers new_class = new ClassMembers();
            new_class.class_name   = class_name;

            current_class = new_class;
            type_mapping.put(class_name, type_mapping.size() + 1);
        }

        symbol_table.put(class_name, current_class);
        visitChildren(ctx);

        current_method_access_identifier = "";
        current_assignment_identifier    = "";
        current_assignment_type          = "";

        return ErrorHandler.INSTANCE.getNumTypeErrors();
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitClass_body(JovaParser.Class_bodyContext ctx) {
        visitChildren(ctx); // visits member and ctor and method_decl
        return ErrorHandler.INSTANCE.getNumTypeErrors();
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitMember_decl(JovaParser.Member_declContext ctx) {
        int return_type  = 0;
        for (TerminalNode variable_decl : ctx.id_list().ID()) {
            String member_name = variable_decl.getText();
            int line           = variable_decl.getSymbol().getLine();
            int char_pos       = variable_decl.getSymbol().getCharPositionInLine();
            String type        = ctx.type().getText();

            String class_name = current_class.class_name;

            if (class_name.equals("Main")) {
                ErrorHandler.INSTANCE.addMainMemberError(line, char_pos);
                return_type = ERROR;
            }

            if (current_class.member_definitions.containsKey(member_name)) {
                ErrorHandler.INSTANCE.addMemberDoubleDefError(line, char_pos, member_name, type, class_name);
                return ERROR;
            } else {
                if (type.equals("Main")) {
                    ErrorHandler.INSTANCE.addMainInstatiationError(line, char_pos);
                    return_type = ERROR;
                }
            }

            MemberDefinition member_definition = new MemberDefinition();
            member_definition.amod = ctx.AMOD().getText();
            member_definition.type = type;

            current_class.member_definitions.put(member_name, member_definition);
        }

        return return_type;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitMethod_decl(JovaParser.Method_declContext ctx) {
        visitChildren(ctx);
        return ErrorHandler.INSTANCE.getNumTypeErrors();
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitMethod_head(JovaParser.Method_headContext ctx) {
        String method_return_type = ctx.type().getText();
        String method_name        = ctx.ID().getText();

        int return_type = 0;

        if (method_return_type.equals("Main")) {
            ErrorHandler.INSTANCE.addMainInstatiationError(ctx.AMOD().getSymbol().getLine(), ctx.AMOD().getSymbol().getCharPositionInLine());
            return_type = ERROR;
        }

        if (return_getType(method_return_type) == TYPE_ERR) {
            ErrorHandler.INSTANCE.addUndefIdError(ctx.AMOD().getSymbol().getLine(), ctx.AMOD().getSymbol().getCharPositionInLine(), method_return_type);
            return_type = ERROR;
        }

        if (current_class.member_definitions.containsKey(method_name)) {
            ErrorHandler.INSTANCE.addMemberDoubleDefError(ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine(), method_name, method_return_type, current_class.class_name);
            return_type = ERROR;
        }

        if (current_class.class_name.equals("Main")) {
            if (method_name.equals("main")) {
                if (!method_return_type.equals("int") || !ctx.AMOD().getText().equals("public") || ctx.params().param_list() != null) {
                    ErrorHandler.INSTANCE.addMainMemberError(ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine());
                    return_type = ERROR;
                }
            } else {
                ErrorHandler.INSTANCE.addMainMemberError(ctx.ID().getSymbol().getLine(), ctx.ID().getSymbol().getCharPositionInLine());
                return_type = ERROR;
            }
        }

        if (ctx.params().param_list() == null) {
            for (MethodDefinition current_class_method_def : current_class.method_definitions) {
                if (current_class_method_def.params.isEmpty() && current_class_method_def.method_name.equals(method_name)) {
                    int line     = ctx.ID().getSymbol().getLine();
                    int char_pos = ctx.ID().getSymbol().getCharPositionInLine();

                    ErrorHandler.INSTANCE.addMethodDoubleDefError(line, char_pos, method_name, current_class.class_name);
                    return ERROR;
                }
            }
        }

        MethodDefinition method_definition = new MethodDefinition();
        method_definition.method_type = method_return_type;
        method_definition.method_name = method_name;
        method_definition.amod        = ctx.AMOD().getText();

        current_class_method = method_definition;

        visitChildren(ctx);

        if (ctx.params().param_list() == null)
            current_class.method_definitions.add(current_class_method);

        return return_type;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitMethod_body(JovaParser.Method_bodyContext ctx) {
        visitChildren(ctx);
        return ErrorHandler.INSTANCE.getNumTypeErrors();
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitCtor(JovaParser.CtorContext ctx) {
        int line     = ctx.CLASS_TYPE().getSymbol().getLine();
        int char_pos = ctx.CLASS_TYPE().getSymbol().getCharPositionInLine();

        if (current_class.class_name.equals("Main")) {
            ErrorHandler.INSTANCE.addMainMemberError(line, char_pos);
            return ERROR;
        }

        if (ctx.params().param_list() == null) {
            for (MethodDefinition class_method : current_class.method_definitions) {
                if (ctx.CLASS_TYPE().getText().equals(class_method.method_name) && class_method.params.isEmpty()) {
                    ErrorHandler.INSTANCE.addMethodDoubleDefError(line, char_pos, ctx.CLASS_TYPE().getText(), current_class.class_name);
                    return ERROR;
                }
            }
        }

        MethodDefinition ctor = new MethodDefinition();
        ctor.method_name = ctx.CLASS_TYPE().getText();
        ctor.method_type = ctx.CLASS_TYPE().getText();

        current_class_method = ctor;
        visitChildren(ctx);

        if (ctx.params().param_list() == null)
            current_class.method_definitions.add(current_class_method);

        return ErrorHandler.INSTANCE.getNumTypeErrors();
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitParams(JovaParser.ParamsContext ctx) {
        visitChildren(ctx);
        return ErrorHandler.INSTANCE.getNumTypeErrors();
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitParam_list(JovaParser.Param_listContext ctx) {
        int type_index = 0;
        int line       = 0;
        Map<String, String> current_params = new LinkedHashMap<>(); // key: param name
        int double_decl_index = 0;
        for (TerminalNode param : ctx.ID()) {
            line = param.getSymbol().getLine();

            int char_pos      = param.getSymbol().getCharPositionInLine();
            String param_name = param.getText();
            String param_type = ctx.type(type_index++).getText();

            if (param_type.equals("Main")) {
                ErrorHandler.INSTANCE.addMainInstatiationError(line, char_pos);
            }

            if (current_params.containsKey(param_name) || current_class.member_definitions.containsKey(param_name))
            {
                String param_string = "";
                int index = 0;
                for (TerminalNode ignored : ctx.ID()) {
                    param_string = param_string.concat(ctx.type(index++).getText());
                    param_string = param_string.concat(" ");
                }

                if (!param_string.isEmpty())
                    param_string = param_string.substring(0, param_string.length() - 1);

                ErrorHandler.INSTANCE.addVarDoubleDefError(line, char_pos, param_name, param_type, current_class_method.method_name, param_string);
                param_name = "double_decl_" + double_decl_index++;
            }

            current_params.put(param_name, param_type);
        }

        if (current_class_method.method_name.equals("print") && current_params.size() == 1)
        {
            if (current_params.containsValue("int") || current_params.containsValue("String") || current_params.containsValue("bool"))
            {
                String param_string = "";
                for (NavigableMap.Entry<String, String> element : current_class_method.params.entrySet())
                {
                    param_string = param_string.concat(element.getValue());

                    if (!element.getKey().equals(current_class_method.params.keySet().iterator().next()))
                        param_string = param_string.concat(" ");
                }

                //ErrorHandler.INSTANCE.addMethodDoubleDefError(line, 1, current_class_method.method_name, current_class.class_name, param_string);
                ErrorHandler.INSTANCE.addMethodDoubleDefError(line, 1, current_class_method.method_name, current_class.class_name, ctx.type(0).getText());
                current_class_method.params = current_params;
                return ERROR;
            }
        }

        current_class_method.params = current_params;

        for (MethodDefinition element : current_class.method_definitions)
        {
            if (Arrays.equals(element.params.values().toArray(), current_params.values().toArray()) && current_class_method.method_name.equals(element.method_name))
            {
                String param_string = "";
                for (NavigableMap.Entry<String, String> element_params : element.params.entrySet())
                {
                    param_string = param_string.concat(element_params.getValue());
                    param_string = param_string.concat(" ");
                }

                if (!param_string.isEmpty())
                    param_string = param_string.substring(0, param_string.length() - 1);

                ErrorHandler.INSTANCE.addMethodDoubleDefError(line, 1, current_class_method.method_name, current_class.class_name, param_string);
                current_class_method.params = current_params;
                return ERROR;
            }
        }

        current_class.method_definitions.add(current_class_method);
        return 0;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitDeclaration(JovaParser.DeclarationContext ctx) {
        for (TerminalNode variable_declaration : ctx.id_list().ID()) {
            int line     = variable_declaration.getSymbol().getLine();
            int char_pos = variable_declaration.getSymbol().getCharPositionInLine();

            String variable_name = variable_declaration.getText();
            String variable_type = ctx.type().getText();

            if (!variable_type.equals("int") && !variable_type.equals("String") && !variable_type.equals("bool") && !symbol_table.containsKey(variable_type))
            {
                ErrorHandler.INSTANCE.addUnknownTypeError(line, char_pos, variable_type);
                return ERROR;
            }

            if (variable_type.equals("Main")) {
                ErrorHandler.INSTANCE.addMainInstatiationError(line, char_pos);
                return ERROR;
            }

            String param_string = "";
            for (NavigableMap.Entry<String, String> element : current_class_method.params.entrySet())
            {
                param_string = param_string.concat(element.getValue());
                param_string = param_string.concat(" ");
            }

            if (!param_string.isEmpty())
                param_string = param_string.substring(0, param_string.length() - 1);

            if (current_class_method.local_variables.containsKey(variable_name)) {
                ErrorHandler.INSTANCE.addVarDoubleDefError(line, char_pos, variable_name, variable_type, current_class_method.method_name, param_string);
                return ERROR;
            }

            for (MethodDefinition method_definition : current_class.method_definitions) {
                if (method_definition.params.containsKey(variable_name)) {
                    ErrorHandler.INSTANCE.addVarDoubleDefError(line, char_pos, variable_name, variable_type, current_class_method.method_name, param_string);
                    return ERROR;
                }
            }

            if (current_class.member_definitions.get(variable_name) != null) {
                ErrorHandler.INSTANCE.addVarDoubleDefError(line, char_pos, variable_name, variable_type, current_class_method.method_name, param_string);
                return ERROR;
            }

            current_class_method.local_variables.put(variable_name, variable_type);
        }

        return ERROR;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitCtor_body(JovaParser.Ctor_bodyContext ctx) {
        visitChildren(ctx);
        return ErrorHandler.INSTANCE.getNumTypeErrors();
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitStmt(JovaParser.StmtContext ctx) {
        visitChildren(ctx);
        return ErrorHandler.INSTANCE.getNumTypeErrors();
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitAssign_stmt(JovaParser.Assign_stmtContext ctx) {
        int line     = ctx.ASSIGN().getSymbol().getLine();
        int char_pos = ctx.ASSIGN().getSymbol().getCharPositionInLine();

        Map<String, MemberDefinition> current_member_definitions = current_class.member_definitions;

        if(!current_member_definitions.containsKey(ctx.ID().getText()) && !current_class_method.local_variables.containsKey(ctx.ID().getText()) && !current_class_method.params.containsKey(ctx.ID().getText())){
            ErrorHandler.INSTANCE.addUndefIdError(line,char_pos,ctx.ID().getText());
            return ERROR;
        }
        current_access_type = getIdentifierType(ctx.ID().getText());

        List<Integer> assignment_types = new ArrayList<>();
        for (ParseTree child : ctx.children) {
            if (child == ctx.ASSIGN())
                continue;

            Integer assignment_type = visit(child);
            String  assignment_identifier;
            if (assignment_type == null) {
                assignment_identifier = child.getText();
                assignment_type = getIdentifierType(assignment_identifier);
                assignment_types.add(assignment_type);
            }
            else
                assignment_types.add(assignment_type);

            if (assignment_type == ERROR)
                return ERROR;

            current_access_type = assignment_type;
        }

        Integer lhs_type = assignment_types.get(assignment_types.size() - 2);
        Integer rhs_type = assignment_types.get(assignment_types.size() - 1);

        // If lhs_type >= 5 it means, that it is a class type
        if (lhs_type == ERROR || rhs_type == ERROR ) {
            return ERROR;
        }

        if (!(ctx.expr() == null)){
            if (lhs_type == TYPE_ERR ) {
                ErrorHandler.INSTANCE.addUndefIdError(ctx.ID().getSymbol().getLine(),ctx.ID().getSymbol().getCharPositionInLine(),ctx.ID().getText());
                return ERROR;
            }
            if (rhs_type == TYPE_ERR ) {
                ErrorHandler.INSTANCE.addUndefIdError(ctx.expr().getStart().getLine(),ctx.expr().getStart().getCharPositionInLine(),ctx.expr().getText());
                return ERROR;
            }
        } else {
            if (lhs_type == TYPE_ERR ) {
                ErrorHandler.INSTANCE.addUndefIdError(ctx.ID().getSymbol().getLine(),ctx.ID().getSymbol().getCharPositionInLine(),ctx.ID().getText());
                return ERROR;
            }
            if (rhs_type == TYPE_ERR ) {
                ErrorHandler.INSTANCE.addUndefIdError(ctx.object_alloc().getStart().getLine(), ctx.object_alloc().getStart().getCharPositionInLine(), ctx.object_alloc().getText());
                return ERROR;
            }
        }


        if (lhs_type.equals(rhs_type)) {
            return lhs_type;
        }

        if((lhs_type >= 5 && rhs_type == TYPE_NIX) )
            return lhs_type;

        if ((lhs_type == TYPE_INT && rhs_type == TYPE_BOOL) ||
                (lhs_type == TYPE_BOOL && rhs_type == TYPE_INT)){
            ErrorHandler.INSTANCE.addBinaryTypeCoercionWarning(line, char_pos, ctx.ASSIGN().getSymbol().getText(), exp_getType(lhs_type), exp_getType(rhs_type), exp_getType(lhs_type), exp_getType(lhs_type));
            return lhs_type;
        } else {
            ErrorHandler.INSTANCE.addBinaryTypeError(line, char_pos, exp_getType(lhs_type), exp_getType(rhs_type), "=");
            return ERROR;
        }

    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitMember_access(JovaParser.Member_accessContext ctx) {
        ClassMembers assignment_type_class = symbol_table.get(exp_getType(current_access_type));

        int line     = ctx.ID().getSymbol().getLine();
        int char_pos = ctx.ID().getSymbol().getCharPositionInLine();

        if (assignment_type_class == null)
        {
            ErrorHandler.INSTANCE.addDoesNotHaveFieldError(line, char_pos, exp_getType(current_access_type), ctx.ID().getText());
            return ERROR;
        }

        MemberDefinition member_def = assignment_type_class.member_definitions.get(ctx.ID().getText());
        if (member_def == null) {
            ErrorHandler.INSTANCE.addUndefIdError(line, char_pos, ctx.ID().getText());
            return ERROR;
        }
        else if (member_def.amod.equals("private")) {
            ErrorHandler.INSTANCE.addMemberAccessError(line, char_pos, ctx.ID().getText(), exp_getType(current_access_type));
            return ERROR;
        }

        return return_getType(member_def.type);
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitChain_method_invocation(JovaParser.Chain_method_invocationContext ctx) {
        ClassMembers chain_method_type_class = symbol_table.get(exp_getType(current_access_type));
        if (chain_method_type_class == null)
            return ERROR;

        int line     = ctx.DOTOP().getSymbol().getLine();
        int char_pos = ctx.DOTOP().getSymbol().getCharPositionInLine();

        String method_name = ctx.method_invocation().ID().getText();
        if (ctx.method_invocation().arg_list() != null) {
            List<String> params = new ArrayList<>();
            String param_string = "";
            for (ParseTree param : ctx.method_invocation().arg_list().expr()) {
                Integer type = visit(param);
                if (type == null)
                    type = getIdentifierType(param.getText());

                if (type == ERROR)
                    return ERROR;

                params.add(exp_getType(type));
                param_string = param_string.concat(exp_getType(type) + " ");
            }

            param_string = param_string.substring(0, param_string.length() - 1);

            for (MethodDefinition element : chain_method_type_class.method_definitions) {
                if (element.method_name.equals(method_name) && Arrays.equals(element.params.values().toArray(), params.toArray())) {
                    if (element.amod.equals("private")) {
                        ErrorHandler.INSTANCE.addMethodAccessError(line, char_pos, method_name, chain_method_type_class.class_name, param_string);
                        return ERROR;
                    }

                    return return_getType(element.method_type);
                }
            }

            ErrorHandler.INSTANCE.addCannotInvokeError(line, char_pos, chain_method_type_class.class_name, method_name, param_string);

        } else {

            for (MethodDefinition element : chain_method_type_class.method_definitions) {
                if (element.method_name.equals(method_name) && element.params.isEmpty()) {
                    if (element.amod.equals("private")) {
                        ErrorHandler.INSTANCE.addMethodAccessError(line, char_pos, method_name, chain_method_type_class.class_name);
                        return ERROR;
                    }

                    return return_getType(element.method_type);
                }
            }

            ErrorHandler.INSTANCE.addCannotInvokeError(line, char_pos, chain_method_type_class.class_name, method_name);
        }

        return ERROR;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitExpPrim(JovaParser.ExpPrimContext ctx) {
        return visitChildren(ctx);
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitExpAdd(JovaParser.ExpAddContext ctx) {
        Integer lhs = visit(ctx.lhs);
        if (lhs == null)
            lhs = getIdentifierType(ctx.lhs.getText());

        Integer rhs = visit(ctx.rhs);
        if (rhs == null)
            rhs = getIdentifierType(ctx.rhs.getText());

        int line        = ctx.op.getLine();
        int char_pos    = ctx.op.getCharPositionInLine();
        String operator = ctx.op.getText();

        if (lhs == ERROR ) {
            return ERROR;
        }
        if (rhs == ERROR ) {
            return ERROR;
        }

        if (lhs == TYPE_ERR ) {
            ErrorHandler.INSTANCE.addUndefIdError(ctx.lhs.getStart().getLine(), ctx.lhs.getStart().getCharPositionInLine(), ctx.lhs.getText());
            return ERROR;
        }
        if (rhs == TYPE_ERR ) {
            ErrorHandler.INSTANCE.addUndefIdError(ctx.rhs.getStart().getLine(), ctx.rhs.getStart().getCharPositionInLine(), ctx.rhs.getText());
            return ERROR;
        }

        if ((lhs == TYPE_INT && rhs == TYPE_BOOL) || (lhs == TYPE_BOOL && rhs == TYPE_INT) || (lhs == TYPE_BOOL && rhs == TYPE_BOOL)) {
            ErrorHandler.INSTANCE.addBinaryTypeCoercionWarning(line, char_pos, operator, exp_getType(lhs), exp_getType(rhs), "int", "int");
            return TYPE_INT;
        }

        if (lhs != TYPE_INT || rhs != TYPE_INT) {
            ErrorHandler.INSTANCE.addBinaryTypeError(line, char_pos, exp_getType(lhs), exp_getType(rhs), operator);
            return ERROR;
        }

        return TYPE_INT;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitLiteral(JovaParser.LiteralContext ctx) {
        int return_type = TYPE_ERR;

        if (ctx.INT_LIT()!= null)
            return_type = TYPE_INT;
        else if (ctx.BOOL_LIT() != null)
            return_type = TYPE_BOOL;
        else if (ctx.STRING_LIT() != null)
            return_type = TYPE_STR;
        else if (ctx.KEY_NIX() != null)
            return_type = TYPE_NIX;

        return return_type;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitId_expr(JovaParser.Id_exprContext ctx) {
        current_assignment_identifier = ctx.ID().getText();

        if (ctx.member_access().size() != 0)
            current_method_access_identifier = current_assignment_identifier;

        Integer id_expr_type = getIdentifierType(ctx.ID().getText());
        current_access_type  = id_expr_type;

        Integer member_type = null;
        for (ParseTree member_access : ctx.member_access()) {
            member_type = visit(member_access);
            current_access_type = member_type;
        }

        Integer chain_method_invocation_type = null;
        if (ctx.chain_method_invocation() != null)
            chain_method_invocation_type = visit(ctx.chain_method_invocation());

        if (chain_method_invocation_type != null)
            return chain_method_invocation_type;

        if (member_type != null)
            return member_type;

        return id_expr_type;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitMethod_invocation(JovaParser.Method_invocationContext ctx) {
        int line     = ctx.ID().getSymbol().getLine();
        int char_pos = ctx.ID().getSymbol().getCharPositionInLine();

        String method_name = ctx.ID().getText();

        String invocation_type = "";
        if (current_class.member_definitions.get(current_method_access_identifier) != null)
            invocation_type = current_class.member_definitions.get(current_method_access_identifier).type;
        else
        {
            invocation_type = current_class_method.local_variables.get(current_method_access_identifier);

            if (invocation_type != null && (invocation_type.equals("int") || invocation_type.equals("String") || invocation_type.equals("bool")))
            {
                ErrorHandler.INSTANCE.addCannotInvokeError(line, char_pos, invocation_type, method_name);
                return ERROR;
            } else if (invocation_type != null){
                ClassMembers invocation_type_class = symbol_table.get(invocation_type);

                for (MethodDefinition method_def : invocation_type_class.method_definitions)
                    if (method_def.method_name.equals(method_name)) {
                        if (method_def.amod.equals("private")) {
                            ErrorHandler.INSTANCE.addMethodAccessError(line, char_pos, method_name, invocation_type);
                            return ERROR;
                        } else {
                            return return_getType(method_def.method_type);
                        }
                    }
            }
        }

        List<MethodDefinition> current_class_methods = current_class.method_definitions;

        if (ctx.ID().getText().equals("print") && ctx.arg_list().expr().size() == 1) {
            Integer param_type = visit(ctx.arg_list().expr(0));
            if (param_type != TYPE_INT && param_type != TYPE_BOOL && param_type != TYPE_STR){
                ErrorHandler.INSTANCE.addUndefMethodError(line, char_pos, "print", exp_getType(param_type));
                return ERROR;
            }
            return TYPE_INT;
        }

        for (MethodDefinition current_class_method_def : current_class_methods) {
            if (current_class_method_def.method_name.equals(method_name))
                return return_getType(current_class_method_def.method_type);
        }

        if (symbol_table.get(invocation_type) != null) {
            for (MethodDefinition class_methods_of_invocation_type : symbol_table.get(invocation_type).method_definitions) {
                if (class_methods_of_invocation_type.method_name.equals(method_name))
                    return return_getType(class_methods_of_invocation_type.method_type);
            }
        } else {
            ErrorHandler.INSTANCE.addUndefMethodError(line, char_pos, invocation_type);
            return ERROR;
        }

        ErrorHandler.INSTANCE.addUndefMethodError(line, char_pos, method_name);
        return ERROR;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitObject_alloc(JovaParser.Object_allocContext ctx) {
        String ctor_name        = ctx.CLASS_TYPE().getText();
        ClassMembers ctor_class = symbol_table.get(ctor_name);

        int line     = ctx.CLASS_TYPE().getSymbol().getLine();
        int char_pos = ctx.CLASS_TYPE().getSymbol().getCharPositionInLine();

        if (ctor_class == null) {
            ErrorHandler.INSTANCE.addUnknownTypeError(line ,char_pos, ctor_name);
            return ERROR;
        }

        if (ctor_name.equals("Main")) {
            ErrorHandler.INSTANCE.addMainInstatiationError(line, char_pos);
            return ERROR;
        }

        if (ctx.ctor_args() == null)
            return return_getType(ctor_name);

        String  arg_types_string = "";

        if (ctx.ctor_args().arg_list() != null) {
            List<String> arg_types = new ArrayList<>();
            for (JovaParser.ExprContext exp_ctx : ctx.ctor_args().arg_list().expr()) {
                Integer arg_type = visit(exp_ctx);
                if (arg_type == ERROR)
                    return ERROR;

                arg_types_string = arg_types_string.concat(exp_getType(arg_type) + " ");
                arg_types.add(exp_getType(arg_type));
            }

            arg_types_string = arg_types_string.substring(0, arg_types_string.length() - 1);

            for (MethodDefinition method_def : ctor_class.method_definitions) {

                if (method_def.method_name.equals(ctor_name) && method_def.params.size() == arg_types.size()) {
                    int     index = 0;
                    boolean found_valid_method = true;
                    for (String param_type : method_def.params.values()) {
                        if (!return_getType(param_type).equals(return_getType(arg_types.get(index))) &&
                            (return_getType(param_type) < TYPE_NIX || return_getType(arg_types.get(index)) < TYPE_NIX)) {
                            found_valid_method = false;
                        }

                        index++;
                    }

                    if (found_valid_method)
                        return return_getType(ctor_name);
                }
            }
        } else {
            for (MethodDefinition method_def : ctor_class.method_definitions) {
                if (method_def.method_name.equals(ctor_name) && method_def.params.isEmpty())
                    return return_getType(ctor_name);
            }
        }

        ErrorHandler.INSTANCE.addUndefMethodError(line, char_pos, ctor_name, arg_types_string);
        return ERROR;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitParan_expr(JovaParser.Paran_exprContext ctx) {
        return visit(ctx.expr());
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitUnary_expr(JovaParser.Unary_exprContext ctx) {
        int line;
        int char_pos;
        String operator;

        Integer type = visit(ctx.primary_expr());
        if (type == null)
            type = getIdentifierType(ctx.primary_expr().getText());

        if(ctx.ADDOP() != null) {
            line     = ctx.ADDOP().getSymbol().getLine();
            char_pos = ctx.ADDOP().getSymbol().getCharPositionInLine();
            operator = ctx.ADDOP().getText();
            if (type != TYPE_INT && type != TYPE_BOOL) {
                ErrorHandler.INSTANCE.addUnaryTypeError(line, char_pos, exp_getType(type), operator);
                return ERROR;
            } else if (type == TYPE_BOOL) {
                ErrorHandler.INSTANCE.addUnaryTypeCoercionWarning(line, char_pos, operator, "bool", "int");
                return TYPE_INT;
            }
        }

        if(ctx.NOT() != null) {
            operator = ctx.NOT().getText();
            line     = ctx.NOT().getSymbol().getLine();
            char_pos = ctx.NOT().getSymbol().getCharPositionInLine();
            if (type != TYPE_INT && type != TYPE_BOOL) {
                ErrorHandler.INSTANCE.addUnaryTypeError(line, char_pos, exp_getType(type), operator);
                return ERROR;
            } else if (type == TYPE_INT) {
                ErrorHandler.INSTANCE.addUnaryTypeCoercionWarning(line, char_pos, operator, "int", "bool");
                return TYPE_BOOL;
            }
        }

        return type;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitExpMulOp(JovaParser.ExpMulOpContext ctx) {
        int line        = ctx.op.getLine();
        int char_pos    = ctx.op.getCharPositionInLine();
        String operator = ctx.op.getText();

        Integer lhs = visit(ctx.lhs);
        if (lhs == null)
            lhs = getIdentifierType(ctx.lhs.getText());

        Integer rhs = visit(ctx.rhs);
        if (rhs == null)
            rhs = getIdentifierType(ctx.rhs.getText());

        if (lhs == ERROR ) {
            return ERROR;
        }
        if (rhs == ERROR ) {
            return ERROR;
        }

        if (lhs == TYPE_ERR ) {
            ErrorHandler.INSTANCE.addUndefIdError(ctx.lhs.getStart().getLine(), ctx.lhs.getStart().getCharPositionInLine(), ctx.lhs.getText());
            return ERROR;
        }
        if (rhs == TYPE_ERR ) {
            ErrorHandler.INSTANCE.addUndefIdError(ctx.rhs.getStart().getLine(), ctx.rhs.getStart().getCharPositionInLine(), ctx.rhs.getText());
            return ERROR;
        }

        if (lhs == TYPE_STR || lhs == TYPE_NIX || lhs >= 5 || rhs == TYPE_STR || rhs == TYPE_NIX || rhs >= 5) {
            ErrorHandler.INSTANCE.addBinaryTypeError(line, char_pos, exp_getType(lhs), exp_getType(rhs), operator);
            return ERROR;
        }

        if (lhs == TYPE_BOOL || rhs == TYPE_BOOL) { // coerced
            ErrorHandler.INSTANCE.addBinaryTypeCoercionWarning(line, char_pos, operator, exp_getType(lhs), exp_getType(rhs), "int", "int");
            return TYPE_INT;
        }

        if (!lhs.equals(rhs)) {  //rejected
            ErrorHandler.INSTANCE.addBinaryTypeError(line, char_pos, exp_getType(lhs), exp_getType(rhs), operator);
            return ERROR;
        }

        return TYPE_INT;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitExpRelop(JovaParser.ExpRelopContext ctx) {
        int line     = ctx.op.getLine();
        int char_pos = ctx.op.getCharPositionInLine();

        Integer lhs = visit(ctx.lhs);
        if (lhs == null)
            lhs = getIdentifierType(ctx.lhs.getText());

        Integer rhs = visit(ctx.rhs);
        if (rhs == null)
            rhs = getIdentifierType(ctx.rhs.getText());


        if (lhs == ERROR ) {
            return ERROR;
        }
        if (rhs == ERROR ) {
            return ERROR;
        }

        if (lhs == TYPE_ERR ) {
            ErrorHandler.INSTANCE.addUndefIdError(ctx.lhs.getStart().getLine(), ctx.lhs.getStart().getCharPositionInLine(), ctx.lhs.getText());
            return ERROR;
        }
        if (rhs == TYPE_ERR ) {
            ErrorHandler.INSTANCE.addUndefIdError(ctx.rhs.getStart().getLine(), ctx.rhs.getStart().getCharPositionInLine(), ctx.rhs.getText());
            return ERROR;
        }

        String operator = ctx.op.getText();

        if (lhs == TYPE_STR || rhs == TYPE_STR) {
            ErrorHandler.INSTANCE.addBinaryTypeError(line, char_pos, exp_getType(lhs), exp_getType(rhs), operator);
            return ERROR;
        }

        if ((lhs == TYPE_INT && rhs == TYPE_BOOL) || (lhs == TYPE_BOOL && rhs == TYPE_INT) || (lhs == TYPE_BOOL && rhs == TYPE_BOOL)) {
            ErrorHandler.INSTANCE.addBinaryTypeCoercionWarning(line, char_pos, operator, exp_getType(lhs), exp_getType(rhs), "int", "int");
            return TYPE_BOOL;
        }

        if (operator.equals("==") || operator.equals("!=")) {
            if ((lhs >= 5 && rhs == TYPE_NIX) || (lhs == TYPE_NIX && rhs >= 5))
                return TYPE_BOOL;
        } else {
            if (lhs == TYPE_NIX || lhs >= 5 || rhs == TYPE_NIX || rhs >= 5) {
                ErrorHandler.INSTANCE.addBinaryTypeError(line, char_pos, exp_getType(lhs), exp_getType(rhs), operator);
                return ERROR;
            }
        }

        if (!lhs.equals(rhs)) {
            ErrorHandler.INSTANCE.addBinaryTypeError(line, char_pos, exp_getType(lhs), exp_getType(rhs), operator);
            return ERROR;
        }

        return TYPE_BOOL;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitExpAnd(JovaParser.ExpAndContext ctx) {
        Integer lhs = visit(ctx.lhs);
        if (lhs == null)
            lhs = getIdentifierType(ctx.lhs.getText());

        Integer rhs = visit(ctx.rhs);
        if (rhs == null)
            rhs = getIdentifierType(ctx.rhs.getText());

        int line        = ctx.op.getLine();
        int char_pos    = ctx.op.getCharPositionInLine();
        String operator = ctx.op.getText();

        if (lhs == ERROR ) {
            return ERROR;
        }
        if (rhs == ERROR ) {
            return ERROR;
        }

        if (lhs == TYPE_ERR ) {
            ErrorHandler.INSTANCE.addUndefIdError(ctx.lhs.getStart().getLine(), ctx.lhs.getStart().getCharPositionInLine(), ctx.lhs.getText());
            return ERROR;
        }
        if (rhs == TYPE_ERR ) {
            ErrorHandler.INSTANCE.addUndefIdError(ctx.rhs.getStart().getLine(), ctx.rhs.getStart().getCharPositionInLine(), ctx.rhs.getText());
            return ERROR;
        }



        int returnType  = TYPE_BOOL;

        if (lhs == TYPE_INT || rhs == TYPE_INT)
            ErrorHandler.INSTANCE.addBinaryTypeCoercionWarning(line, char_pos, operator, exp_getType(lhs), exp_getType(rhs), "bool", "bool");

        if ((lhs != TYPE_INT && lhs != TYPE_BOOL) || (rhs != TYPE_INT && rhs != TYPE_BOOL)) {  //rejects String Ctype nix
            ErrorHandler.INSTANCE.addBinaryTypeError(line, char_pos, exp_getType(lhs), exp_getType(rhs) , operator);
            returnType = ERROR;
        }

        return returnType;
    }

    //------------------------------------------------------------------------------


    @Override
    public Integer visitExpOr(JovaParser.ExpOrContext ctx) {
        String operator = ctx.op.getText();
        int returnType  = TYPE_BOOL;

        String lhs_identifier = ctx.lhs.getText();
        String rhs_identifier = ctx.rhs.getText();

        int line     = ctx.op.getLine();
        int char_pos = ctx.op.getCharPositionInLine();

        Integer lhs = visit(ctx.lhs);
        if (lhs == null)
            lhs = getIdentifierType(lhs_identifier);

        Integer rhs = visit(ctx.rhs);
        if (rhs == null)
            rhs = getIdentifierType(rhs_identifier);

        if (lhs == ERROR ) {
            return ERROR;
        }
        if (rhs == ERROR ) {
            return ERROR;
        }

        if (lhs == TYPE_ERR ) {
            ErrorHandler.INSTANCE.addUndefIdError(ctx.lhs.getStart().getLine(), ctx.lhs.getStart().getCharPositionInLine(), ctx.lhs.getText());
            return ERROR;
        }
        if (rhs == TYPE_ERR ) {
            ErrorHandler.INSTANCE.addUndefIdError(ctx.rhs.getStart().getLine(), ctx.rhs.getStart().getCharPositionInLine(), ctx.rhs.getText());
            return ERROR;
        }


        if (rhs == TYPE_INT || lhs == TYPE_INT)
            ErrorHandler.INSTANCE.addBinaryTypeCoercionWarning(line, char_pos, operator, exp_getType(lhs), exp_getType(rhs), "bool", "bool");

        if ((lhs != TYPE_BOOL && lhs != TYPE_INT) || (rhs != TYPE_BOOL && rhs != TYPE_INT)) {
            ErrorHandler.INSTANCE.addBinaryTypeError(line, char_pos, exp_getType(lhs), exp_getType(rhs), operator);
            returnType = ERROR;
        }

        return returnType;
    }



    //------------------------------------------------------------------------------

    @Override
    public Integer visitType(JovaParser.TypeContext ctx) {

        /*NavigableMap.Entry<String, ClassMembers> current_class_symbol_table = symbol_table.firstEntry();
        NavigableMap<String, MemberDefinition>   current_class_members      = current_class_symbol_table.getValue().member_definitions;
        String                                   class_name                 = current_class_symbol_table.getKey();*/

        return 0;
    }

    //------------------------------------------------------------------------------


    @Override
    public Integer visitControl_stmt(JovaParser.Control_stmtContext ctx) {
        visitChildren(ctx);
        return 0;
    }

    //------------------------------------------------------------------------------


    @Override
    public Integer visitIf_stmt(JovaParser.If_stmtContext ctx) {
        int line     = ctx.KEY_IF().getSymbol().getLine();
        int char_pos = ctx.KEY_IF().getSymbol().getCharPositionInLine();
        Integer type = visit(ctx.expr());
        if (type == null)
            type = getIdentifierType(ctx.expr().getText());

        if(type != TYPE_BOOL && type != TYPE_INT) {
            ErrorHandler.INSTANCE.addIncompatibleCondTypeError(line, char_pos, exp_getType(type));
            return ERROR;
        }
        else if (type == TYPE_INT)
            ErrorHandler.INSTANCE.addConditionTypeCoercionWarning(line, char_pos, exp_getType(TYPE_INT), exp_getType(TYPE_BOOL));

        return TYPE_BOOL;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitRet_stmt(JovaParser.Ret_stmtContext ctx) {
        if (current_class_method == null || ctx.KEY_RETURN() == null)
            return ErrorHandler.INSTANCE.getNumTypeErrors();

        int line     = ctx.KEY_RETURN().getSymbol().getLine();
        int char_pos = ctx.KEY_RETURN().getSymbol().getCharPositionInLine();

        if (ctx.expr() == null)
        {
            ErrorHandler.INSTANCE.addIncompatibleReturnTypeError(line, char_pos, "nix");
            return ERROR;
        }

        Integer return_type = visit(ctx.expr());
        if (return_type == null)
            return_type = getIdentifierType(ctx.expr().getText());

        int methode_type = return_getType(current_class_method.method_type);

        // If lhs_type >= 5 it means, that it is a class type

        if (return_type == ERROR ) {
            return ERROR;
        }


        if (return_type == TYPE_ERR ) {
            ErrorHandler.INSTANCE.addUndefIdError(ctx.expr().getStart().getLine(),ctx.expr().getStart().getCharPositionInLine(), ctx.expr().getText()); // or addIncompatibleReturnTypeError
            return ERROR;
        }

        if (return_type.equals(methode_type) || return_type == ERROR || methode_type == ERROR || (methode_type >= 5 && return_type == TYPE_NIX))
            return return_type;

        if ((return_type == TYPE_INT && methode_type == TYPE_BOOL) || (return_type == TYPE_BOOL && methode_type == TYPE_INT)) {
            ErrorHandler.INSTANCE.addReturnTypeCoercionWarning(line, char_pos, exp_getType(return_type), exp_getType(methode_type));
            return return_type;
        } else
            ErrorHandler.INSTANCE.addIncompatibleReturnTypeError(line, char_pos, exp_getType(return_type));

        return return_type;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitWhile_stmt(JovaParser.While_stmtContext ctx) {

        int line     = ctx.KEY_WHILE().getSymbol().getLine();
        int char_pos = ctx.KEY_WHILE().getSymbol().getCharPositionInLine();
        Integer type = visit(ctx.expr());
        if (type == null)
            type = getIdentifierType(ctx.expr().getText());

        if (type == TYPE_ERR) {
            ErrorHandler.INSTANCE.addUndefIdError(line, char_pos, ctx.expr().getText());
            return ERROR;
        }

        if (type == ERROR)
            return ERROR;

        if(type != TYPE_BOOL && type != TYPE_INT) {
            ErrorHandler.INSTANCE.addIncompatibleCondTypeError( line,  char_pos, exp_getType(type));
            return ERROR;
        }
        else if (type == TYPE_INT)
            ErrorHandler.INSTANCE.addConditionTypeCoercionWarning(line, char_pos, exp_getType(TYPE_INT), exp_getType(TYPE_BOOL));

        return TYPE_BOOL;
    }

    //------------------------------------------------------------------------------

    @Override
    public Integer visitExpTernop(JovaParser.ExpTernopContext ctx) {
        int line_quest          = ctx.TERNOP().getSymbol().getLine();
        int char_pos_quest      = ctx.TERNOP().getSymbol().getCharPositionInLine();
        String opquest         = ctx.TERNOP().getSymbol().getText();
        String opdp         = ctx.TERNOP2().getSymbol().getText();
        int line_dp         = ctx.TERNOP2().getSymbol().getLine();
        int char_dp      = ctx.TERNOP2().getSymbol().getCharPositionInLine();



        int booleanExp_typ   = visit(ctx.expr(0));
        int exp1_typ         = visit(ctx.expr(1));
        int exp2_typ         = visit(ctx.expr(2));

        if (exp1_typ == ERROR ) {
            return ERROR;
        }
        if (exp2_typ == ERROR ) {
            return ERROR;
        }
        if (booleanExp_typ == ERROR ) {
            return ERROR;
        }

        if (exp1_typ == TYPE_ERR ) {
            ErrorHandler.INSTANCE.addUndefIdError(ctx.expr(1).getStart().getLine(),ctx.expr(1).getStart().getCharPositionInLine(), ctx.expr(1).getStart().getText());
            return ERROR;
        }
        if (exp2_typ == TYPE_ERR ) {
            ErrorHandler.INSTANCE.addUndefIdError(ctx.expr(2).getStart().getLine(),ctx.expr(2).getStart().getCharPositionInLine(), ctx.expr(2).getStart().getText());
            return ERROR;
        }
        if (booleanExp_typ == TYPE_ERR ) {
            ErrorHandler.INSTANCE.addUndefIdError(ctx.expr(0).getStart().getLine(),ctx.expr(0).getStart().getCharPositionInLine(), ctx.expr(0).getStart().getText());
            return ERROR;
        }




        if(booleanExp_typ != TYPE_BOOL){
            if (booleanExp_typ == TYPE_INT)
                ErrorHandler.INSTANCE.addConditionTypeCoercionWarning(line_quest,char_pos_quest,opquest,"bool");
            if(booleanExp_typ != TYPE_INT){
                ErrorHandler.INSTANCE.addIncompatibleCondTypeError(line_quest,char_pos_quest,exp_getType(booleanExp_typ));
                return ERROR;
            }
        }


        if (exp1_typ == exp2_typ ){
            return exp1_typ;
        }


        if((exp1_typ >= 5 && exp2_typ == TYPE_NIX) )
            return exp1_typ;

        if (exp1_typ == TYPE_NIX && exp2_typ >= 5)
            return exp2_typ;

        if ((exp1_typ == TYPE_INT && exp2_typ == TYPE_BOOL) ||
                (exp1_typ == TYPE_BOOL && exp2_typ == TYPE_INT)){
            ErrorHandler.INSTANCE.addBinaryTypeCoercionWarning(line_dp,char_dp,opdp,exp_getType(exp1_typ), exp_getType(exp2_typ),exp_getType(exp1_typ),exp_getType(exp1_typ));
            return exp1_typ;
        }else {
            ErrorHandler.INSTANCE.addBinaryTypeError(line_dp, char_dp, exp_getType(exp1_typ), exp_getType(exp2_typ),opdp);
            return ERROR;
        }

    }

    @Override
    public Integer visitPrimary_expr(JovaParser.Primary_exprContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitCtor_args(JovaParser.Ctor_argsContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitClass_head(JovaParser.Class_headContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitId_list(JovaParser.Id_listContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitCompound_stmt(JovaParser.Compound_stmtContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Integer visitArg_list(JovaParser.Arg_listContext ctx) {
        return visitChildren(ctx);
    }
}
