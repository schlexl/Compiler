package at.tugraz.ist.cc;

public class JasminLabelInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.LABEL;
    public final String          m_label;

    //------------------------------------------------------------------------------

    JasminLabelInstruction(String label) {
        m_label = label;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  " + m_label + ":\n";
    }
}
