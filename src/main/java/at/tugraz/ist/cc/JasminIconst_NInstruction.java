package at.tugraz.ist.cc;

public class JasminIconst_NInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.ICONST_N;
    private final int            m_index;

    //------------------------------------------------------------------------------

    JasminIconst_NInstruction(int index) {
        m_index = index;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  iconst_ " + m_index + "\n";
    }
}