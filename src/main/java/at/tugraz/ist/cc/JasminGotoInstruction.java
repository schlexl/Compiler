package at.tugraz.ist.cc;

public class JasminGotoInstruction implements JasminBaseInstruction{
    public final InstructionType Type = InstructionType.GOTO;
    public final String          m_label;

    //------------------------------------------------------------------------------

    JasminGotoInstruction(String label) {
        m_label = label;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  goto " + m_label + "\n";
    }
}
