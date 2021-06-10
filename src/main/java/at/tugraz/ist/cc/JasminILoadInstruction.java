package at.tugraz.ist.cc;

public class JasminILoadInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.ILOAD;
    private final int            m_index;

    //------------------------------------------------------------------------------

    JasminILoadInstruction(int index) {
        m_index = index;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public Integer getIndex() { return m_index; }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  iload " + m_index + "\n";
    }
}
