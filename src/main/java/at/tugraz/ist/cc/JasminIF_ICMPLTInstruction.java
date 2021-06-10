package at.tugraz.ist.cc;

public class JasminIF_ICMPLTInstruction implements JasminBaseInstruction{
    public final InstructionType Type = InstructionType.IF_ICMPLT;
    public final String          m_label;

    //------------------------------------------------------------------------------

    JasminIF_ICMPLTInstruction(String label) {
        m_label = label;
    }

    //------------------------------------------------------------------------------

    public JasminBaseInstruction.InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  if_icmplt " + m_label + "\n";
    }
}
