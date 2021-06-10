package at.tugraz.ist.cc;

public class JasminInvokeSpecialInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.ALOAD_0;
    private final String         m_invoke_method_name;
    private final String         m_invoke_method_type;

    //------------------------------------------------------------------------------

    JasminInvokeSpecialInstruction(String invoke_method_name, String invoke_method_type) {
        m_invoke_method_name = invoke_method_name;
        m_invoke_method_type = invoke_method_type;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  invokespecial " + m_invoke_method_name + m_invoke_method_type + "\n";
    }
}
