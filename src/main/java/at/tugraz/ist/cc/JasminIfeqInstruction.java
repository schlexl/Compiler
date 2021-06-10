package at.tugraz.ist.cc;

public class JasminIfeqInstruction implements JasminBaseInstruction{
    public final InstructionType Type = InstructionType.IFEQ;
    public final String          m_label;

    //------------------------------------------------------------------------------

    JasminIfeqInstruction(String label) {
        m_label = label;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  ifeq " + m_label + "\n";
    }
}
