package at.tugraz.ist.cc;

public class JasminIfneInstruction implements JasminBaseInstruction{
    public final InstructionType Type = InstructionType.IFNE;
    public final String          m_label;

    //------------------------------------------------------------------------------

    JasminIfneInstruction(String label) {
        m_label = label;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  ifne " + m_label + "\n";
    }
}
