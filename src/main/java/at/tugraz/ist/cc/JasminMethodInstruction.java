package at.tugraz.ist.cc;

import java.util.ArrayList;
import java.util.List;

public class JasminMethodInstruction implements JasminBaseInstruction {
    public InstructionType                    Type                  = InstructionType.METHOD;
    private final List<JasminBaseInstruction> m_method_instructions = new ArrayList<>();

    //------------------------------------------------------------------------------

    JasminMethodInstruction(String method_amod, String method_name, String method_params, String method_type) {
        m_method_instructions.add(new JasminStartMethodInstruction(method_amod, method_name, method_params, method_type));
        m_method_instructions.add(new JasminEndInstruction());
    }

    //------------------------------------------------------------------------------

    public void addMethodInstruction(JasminBaseInstruction instruction) {
        m_method_instructions.add(m_method_instructions.size() - 1, instruction);
    }

    //------------------------------------------------------------------------------

    public int getAmountOfMethodInstructions() {
        return m_method_instructions.size();
    }

    //------------------------------------------------------------------------------

    public List<JasminBaseInstruction> getMethodInstructions() {
        return m_method_instructions;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        String jasmin_instructions = "";

        for (JasminBaseInstruction element : m_method_instructions)
            jasmin_instructions = jasmin_instructions.concat(element.convertToString());

        return jasmin_instructions;
    }
}
