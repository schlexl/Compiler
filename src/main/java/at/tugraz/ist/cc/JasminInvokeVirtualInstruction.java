package at.tugraz.ist.cc;

public class JasminInvokeVirtualInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.INVOKEVIRTUAL;
    private final String         m_method_name;
    private final String         m_method_params;
    private final String         m_method_type;

    //------------------------------------------------------------------------------

    JasminInvokeVirtualInstruction(String method_name, String method_params, String method_type) {
        m_method_name   = method_name;
        m_method_params = method_params;
        m_method_type   = method_type;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  invokevirtual " + m_method_name + "(" + m_method_params + ")" + m_method_type + "\n";
    }
}
