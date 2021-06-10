package at.tugraz.ist.cc;

import at.tugraz.ist.cc.error.ErrorHandler;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.Collections;

/**
 * @author wehopeu
 *
 */
public class CodeOpt {

    //------------------------------------------------------------------------------

    private class SymbolMetaData {
        private Integer m_variable_name;
        private boolean m_is_live;
        private Integer m_next_use;
        private Integer m_value;

        //------------------------------------------------------------------------------

        public SymbolMetaData() {
            m_is_live  = false;
            m_next_use = null;
            m_value    = null;
        }

        //------------------------------------------------------------------------------

        public SymbolMetaData(Integer variable_name) {
            m_variable_name = variable_name;
            m_is_live       = false;
            m_next_use      = null;
            m_value         = null;
        }

        //------------------------------------------------------------------------------

        public SymbolMetaData(Integer variable_name, boolean is_live, Integer next_use, Integer value) {
            m_variable_name = variable_name;
            m_is_live       = is_live;
            m_next_use      = next_use;
            m_value         = value;
        }

        //------------------------------------------------------------------------------

        public void setValue(Integer value) {
            m_value = value;
        }

        //------------------------------------------------------------------------------

        public Integer getValue() {
            return m_value;
        }
    }

    private Map<Integer, SymbolMetaData> m_symbol_table = new LinkedHashMap<>();

    //------------------------------------------------------------------------------

    public int optimizeCode(String file_path, boolean debug, String out_path) {
        TypeChecker type_checker = new TypeChecker();

        type_checker.checkTypes(file_path, debug);

        if (ErrorHandler.INSTANCE.getNumLexErrors() > 0)
            return ErrorHandler.INSTANCE.getNumLexErrors();
        else if (ErrorHandler.INSTANCE.getNumParseErrors() > 0)
            return ErrorHandler.INSTANCE.getNumParseErrors();
        else if (ErrorHandler.INSTANCE.getNumTypeErrors() > 0)
            return ErrorHandler.INSTANCE.getNumTypeErrors();

        File output_dir = new File(out_path);
        if (!output_dir.exists() && !output_dir.mkdirs()) {
            return 1;
        }

        ParseTree parse_tree         = type_checker.getParseTree();
        CodeGeneratorVisitor visitor = new CodeGeneratorVisitor(type_checker.visitor);

        visitor.visit(parse_tree);

        Map<String, List<JasminBaseInstruction>> jasmin_instructions = visitor.getJasminInstructions();
        if (jasmin_instructions.size() == 0)
            return -1;

        calculateLivenessAndNextNextUse(jasmin_instructions);
        applyConstantPropagation(jasmin_instructions);
        applyConstantFolding(jasmin_instructions);
        applyConstantPropagation(jasmin_instructions);
        applySwapRemoval(jasmin_instructions);
        //applyPeepholeOptimization(jasmin_instructions);
        applyDeadCodeRemoval(jasmin_instructions);
        removeReturn(jasmin_instructions);

        return writeInstructionsToDisk(jasmin_instructions, out_path);
    }

    //------------------------------------------------------------------------------

    private void calculateLivenessAndNextNextUse(Map<String, List<JasminBaseInstruction>> jasmin_instructions) {
        for (Map.Entry<String, List<JasminBaseInstruction>> entry : jasmin_instructions.entrySet()) {
            int instruction_index = 0;
            for (JasminBaseInstruction class_instructions : entry.getValue()) {
                if (class_instructions.getType() != JasminBaseInstruction.InstructionType.METHOD)
                    continue;

                JasminMethodInstruction method_instruction = (JasminMethodInstruction)class_instructions;

                Collections.reverse(method_instruction.getMethodInstructions());

                for (JasminBaseInstruction jasmin_instruction : method_instruction.getMethodInstructions()) {
                    if (jasmin_instruction.getType() == JasminBaseInstruction.InstructionType.ISTORE) {
                        JasminIStoreInstruction istore_instruction = (JasminIStoreInstruction)jasmin_instruction;
                        SymbolMetaData          symbol_meta_data   = new SymbolMetaData(istore_instruction.m_index);

                        m_symbol_table.put(istore_instruction.m_index, symbol_meta_data);
                    } else if (jasmin_instruction.getType() == JasminBaseInstruction.InstructionType.ILOAD) {
                        JasminILoadInstruction iload_instruction = (JasminILoadInstruction)jasmin_instruction;
                        SymbolMetaData         symbol_meta_data  = new SymbolMetaData(iload_instruction.getIndex(), true, instruction_index, null);

                        m_symbol_table.put(iload_instruction.getIndex(), symbol_meta_data);
                    }

                    instruction_index++;
                }

                Collections.reverse(method_instruction.getMethodInstructions());
            }
        }
    }

    //------------------------------------------------------------------------------

    private void applyConstantPropagation(Map<String, List<JasminBaseInstruction>> jasmin_instructions) {
        for (Map.Entry<String, List<JasminBaseInstruction>> entry : jasmin_instructions.entrySet()) {
            int instruction_index = 0;
            for (JasminBaseInstruction class_instructions : entry.getValue()) {
                if (class_instructions.getType() != JasminBaseInstruction.InstructionType.METHOD)
                    continue;

                JasminMethodInstruction     method_instruction = (JasminMethodInstruction)class_instructions;
                List<JasminBaseInstruction> method_instructions = method_instruction.getMethodInstructions();

                for (JasminBaseInstruction jasmin_instruction : method_instructions) {
                    if (jasmin_instruction.getType() == JasminBaseInstruction.InstructionType.IADD
                            || jasmin_instruction.getType() == JasminBaseInstruction.InstructionType.ISUB
                            || jasmin_instruction.getType() == JasminBaseInstruction.InstructionType.IMUL
                            || jasmin_instruction.getType() == JasminBaseInstruction.InstructionType.IDIV
                            || jasmin_instruction.getType() == JasminBaseInstruction.InstructionType.IREM){
                        break;
                    }
                    if (jasmin_instruction.getType() == JasminBaseInstruction.InstructionType.ISTORE &&
                        method_instructions.get(instruction_index - 1).getType() == JasminBaseInstruction.InstructionType.LDC) {
                        JasminIStoreInstruction istore_instruction = (JasminIStoreInstruction)jasmin_instruction;
                        JasminLdcInstruction    ldc_instruction    = (JasminLdcInstruction)method_instructions.get(instruction_index - 1);

                        m_symbol_table.get(istore_instruction.m_index).setValue(Integer.parseInt(ldc_instruction.m_constant));
                    } else if (jasmin_instruction.getType() == JasminBaseInstruction.InstructionType.ILOAD) {
                        JasminILoadInstruction iload_instruction = (JasminILoadInstruction)jasmin_instruction;

                        SymbolMetaData cached_value = m_symbol_table.get(iload_instruction.getIndex());
                        if (cached_value != null && cached_value.getValue() != null)
                            method_instructions.set(instruction_index, new JasminLdcInstruction(cached_value.getValue().toString()));
                    }

                    instruction_index++;
                }
            }
        }
    }

    //------------------------------------------------------------------------------

    private void applyDeadCodeRemoval(Map<String, List<JasminBaseInstruction>> jasmin_instructions) {
        for (Map.Entry<String, List<JasminBaseInstruction>> entry : jasmin_instructions.entrySet()) {
            int           instruction_index = 0;
            List<Integer> indices_to_remove = new ArrayList<>();
            for (JasminBaseInstruction class_instructions : entry.getValue()) {
                if (class_instructions.getType() != JasminBaseInstruction.InstructionType.METHOD)
                    continue;

                JasminMethodInstruction     method_instruction = (JasminMethodInstruction)class_instructions;
                List<JasminBaseInstruction> method_instructions = method_instruction.getMethodInstructions();

                for (JasminBaseInstruction jasmin_instruction : method_instructions) {
                    if (jasmin_instruction.getType() == JasminBaseInstruction.InstructionType.ISTORE &&
                        method_instructions.get(instruction_index - 1).getType() == JasminBaseInstruction.InstructionType.LDC) {

                        JasminIStoreInstruction istore_instruction = (JasminIStoreInstruction)jasmin_instruction;
                        JasminLdcInstruction    ldc_instruction    = (JasminLdcInstruction)method_instructions.get(instruction_index - 1);
                        if (m_symbol_table.get(istore_instruction.m_index).m_is_live == false){
                            indices_to_remove.add(instruction_index-1 );
                            indices_to_remove.add(instruction_index  );
                        }

                    }

                    instruction_index++;
                }

                Collections.reverse(indices_to_remove);

                for (int index_to_remove : indices_to_remove)
                    method_instructions.remove(index_to_remove);
            }
        }
    }

    //------------------------------------------------------------------------------

    private void applySwapRemoval(Map<String, List<JasminBaseInstruction>> jasmin_instructions) {
        for (Map.Entry<String, List<JasminBaseInstruction>> entry : jasmin_instructions.entrySet()) {
            int instruction_index = 0;
            for (JasminBaseInstruction class_instructions : entry.getValue()) {

                if (class_instructions.getType() != JasminBaseInstruction.InstructionType.METHOD)
                    continue;

                List<Integer>               indices_to_remove   = new ArrayList<>();
                JasminMethodInstruction     method_instruction  = (JasminMethodInstruction)class_instructions;
                List<JasminBaseInstruction> method_instructions = method_instruction.getMethodInstructions();

                for (JasminBaseInstruction jasmin_instruction : method_instructions) {
                    if (jasmin_instruction.getType() == JasminBaseInstruction.InstructionType.SWAP) {
                        JasminBaseInstruction swap_1 = method_instructions.get(instruction_index - 1);
                        JasminBaseInstruction swap_2 = method_instructions.get(instruction_index - 2);

                        method_instructions.set(instruction_index - 2, swap_1);
                        method_instructions.set(instruction_index - 1, swap_2);
                        indices_to_remove.add(instruction_index);
                    }

                    instruction_index++;
                }
                Collections.reverse(indices_to_remove);
                for (int index_to_remove : indices_to_remove)
                    method_instructions.remove(index_to_remove);
            }
        }
    }

    //------------------------------------------------------------------------------
    //\TODO dont know if we need this sort of optimization, due to iload istore not existing
    private void applyPeepholeOptimization(Map<String, List<JasminBaseInstruction>> jasmin_instructions) {
        for (Map.Entry<String, List<JasminBaseInstruction>> entry : jasmin_instructions.entrySet()) {
            int instruction_index = 0;
            List<Integer>               indices_to_remove   = new ArrayList<>();
            for (JasminBaseInstruction class_instructions : entry.getValue()) {
                if (class_instructions.getType() != JasminBaseInstruction.InstructionType.METHOD)
                    continue;

                JasminMethodInstruction     method_instruction = (JasminMethodInstruction)class_instructions;
                List<JasminBaseInstruction> method_instructions = method_instruction.getMethodInstructions();

                for (JasminBaseInstruction jasmin_instruction : method_instructions) {
                    if (jasmin_instruction.getType() == JasminBaseInstruction.InstructionType.ISTORE &&
                            method_instructions.get(instruction_index - 1).getType() == JasminBaseInstruction.InstructionType.ILOAD) {
                        JasminIStoreInstruction istore_instruction = (JasminIStoreInstruction)jasmin_instruction;
                        JasminLdcInstruction    iload_instruction    = (JasminLdcInstruction)method_instructions.get(instruction_index - 1);
                        indices_to_remove.add(instruction_index-1 );
                        indices_to_remove.add(instruction_index );
                    }
                    instruction_index++;
                }
                Collections.reverse(indices_to_remove);

                for (int index_to_remove : indices_to_remove)
                    method_instructions.remove(index_to_remove);
            }
        }
    }

    //------------------------------------------------------------------------------

    private int writeInstructionsToDisk(Map<String, List<JasminBaseInstruction>> jasmin_instructions, String out_path) {
        for (Map.Entry<String, List<JasminBaseInstruction>> entry : jasmin_instructions.entrySet()) {
            try {
                String file_name  = entry.getKey() + ".j";
                String output_file_path;
                if (!out_path.endsWith("/"))
                    output_file_path = out_path + "/" + file_name;
                else
                    output_file_path = out_path + file_name;

                OutputStream out_stream = new FileOutputStream(new File(output_file_path));
                for (JasminBaseInstruction jasmin_instruction : entry.getValue()) {
                    String instruction_string = jasmin_instruction.convertToString();
                    out_stream.write(instruction_string.getBytes(), 0, instruction_string.length());
                }

                out_stream.close();
            }
            catch (IOException e) {
                return -1;
            }
        }

        return 0;
    }

    //------------------------------------------------------------------------------
    //+, -, *, /, %
    private void applyConstantFolding(Map<String, List<JasminBaseInstruction>> jasmin_instructions) {
        boolean againpropagate = false;
        for (Map.Entry<String, List<JasminBaseInstruction>> entry : jasmin_instructions.entrySet()) {
            int instruction_index = 0;

            for (JasminBaseInstruction class_instructions : entry.getValue()) {
                if (class_instructions.getType() != JasminBaseInstruction.InstructionType.METHOD)
                    continue;

                List<Integer> indices_to_remove = new ArrayList<>();
                JasminMethodInstruction method_instruction = (JasminMethodInstruction)class_instructions;
                List<JasminBaseInstruction> method_instructions = method_instruction.getMethodInstructions();

                for (JasminBaseInstruction jasmin_instruction : method_instructions) {
                    if ((jasmin_instruction.getType() == JasminBaseInstruction.InstructionType.IADD
                       || jasmin_instruction.getType() == JasminBaseInstruction.InstructionType.ISUB
                       || jasmin_instruction.getType() == JasminBaseInstruction.InstructionType.IMUL
                       || jasmin_instruction.getType() == JasminBaseInstruction.InstructionType.IDIV
                       || jasmin_instruction.getType() == JasminBaseInstruction.InstructionType.IREM)) {

                        if (method_instructions.get(instruction_index - 1).getType() == JasminBaseInstruction.InstructionType.LDC
                                && method_instructions.get(instruction_index - 2).getType() == JasminBaseInstruction.InstructionType.LDC) {

                            //JasminIStoreInstruction istore_instruction = (JasminIStoreInstruction)jasmin_instruction;
                            JasminLdcInstruction    ldc_instruction_1    = (JasminLdcInstruction)method_instructions.get(instruction_index - 1);
                            JasminLdcInstruction    ldc_instruction_2    = (JasminLdcInstruction)method_instructions.get(instruction_index - 2);
                            switch(jasmin_instruction.getType()) {
                                case IADD:
                                    method_instructions.set(instruction_index, new JasminLdcInstruction(String.valueOf(Integer.parseInt(ldc_instruction_2.m_constant) + Integer.parseInt(ldc_instruction_1.m_constant))));
                                    indices_to_remove.add(instruction_index - 2);
                                    indices_to_remove.add(instruction_index - 1);
                                    againpropagate = true;
                                    break;
                                case ISUB:
                                    method_instructions.set(instruction_index, new JasminLdcInstruction(String.valueOf(Integer.parseInt(ldc_instruction_2.m_constant) - Integer.parseInt(ldc_instruction_1.m_constant))));
                                    indices_to_remove.add(instruction_index - 2);
                                    indices_to_remove.add(instruction_index - 1);
                                    againpropagate = true;
                                    break;
                                case IDIV:
                                    if (Integer.parseInt(ldc_instruction_1.m_constant) != 0){

                                        method_instructions.set(instruction_index, new JasminLdcInstruction(String.valueOf(Integer.parseInt(ldc_instruction_2.m_constant) / Integer.parseInt(ldc_instruction_1.m_constant))));
                                        indices_to_remove.add(instruction_index - 2);
                                        indices_to_remove.add(instruction_index - 1);
                                        againpropagate = true;
                                    }
                                           break;
                                case IMUL:
                                    method_instructions.set(instruction_index, new JasminLdcInstruction(String.valueOf(Integer.parseInt(ldc_instruction_2.m_constant) * Integer.parseInt(ldc_instruction_1.m_constant))));
                                    indices_to_remove.add(instruction_index - 2);
                                    indices_to_remove.add(instruction_index - 1);
                                    againpropagate = true;
                                    break;
                                case IREM:
                                    if (Integer.parseInt(ldc_instruction_1.m_constant) != 0) {
                                        method_instructions.set(instruction_index, new JasminLdcInstruction(String.valueOf(Integer.parseInt(ldc_instruction_2.m_constant) % Integer.parseInt(ldc_instruction_1.m_constant))));
                                        indices_to_remove.add(instruction_index - 2);
                                        indices_to_remove.add(instruction_index - 1);
                                        againpropagate = true;
                                    }
                                    break;
                            }
                            break;

                        }else{
                            againpropagate = true;
                        }

                    }

                    instruction_index++;
                }

                Collections.reverse(indices_to_remove);

                for (int index_to_remove : indices_to_remove)
                    method_instructions.remove(index_to_remove);
            }
        }
        if (againpropagate){
            applyConstantPropagation(jasmin_instructions);
            applyConstantFolding(jasmin_instructions);
        }
    }

    //------------------------------------------------------------------------------

    private void removeReturn(Map<String, List<JasminBaseInstruction>> jasmin_instructions) {
        for (Map.Entry<String, List<JasminBaseInstruction>> entry : jasmin_instructions.entrySet()) {
            int instruction_index = 0;
            for (JasminBaseInstruction class_instructions : entry.getValue()) {
                if (class_instructions.getType() != JasminBaseInstruction.InstructionType.METHOD)
                    continue;

                List<Integer>               indices_to_remove   = new ArrayList<>();
                JasminMethodInstruction     method_instruction  = (JasminMethodInstruction)class_instructions;
                List<JasminBaseInstruction> method_instructions = method_instruction.getMethodInstructions();

                for (JasminBaseInstruction jasmin_instruction : method_instructions) {
                    if (jasmin_instruction.getType() == JasminBaseInstruction.InstructionType.RETURN)
                        indices_to_remove.add(instruction_index - 1);

                    instruction_index++;
                }

                Collections.reverse(indices_to_remove);

                for (int index_to_remove : indices_to_remove){
                    method_instructions.remove(index_to_remove);
                }
            }
        }
    }

    //------------------------------------------------------------------------------

}
