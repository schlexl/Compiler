package at.tugraz.ist.cc;

public class JasminIF_ICMPNEInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.IF_ICMPNE;
    public final String          m_label;

    //------------------------------------------------------------------------------

    JasminIF_ICMPNEInstruction(String label) {
        m_label = label;
    }

    //------------------------------------------------------------------------------

    public JasminBaseInstruction.InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  if_icmpne " + m_label + "\n";
    }
}