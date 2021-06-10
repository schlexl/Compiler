package at.tugraz.ist.cc;

public class JasminALoadInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.ALOAD;
    private final int            m_index;

    //------------------------------------------------------------------------------

    JasminALoadInstruction(int index) {
        m_index = index;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  aload " + m_index + "\n";
    }
}
