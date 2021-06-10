package at.tugraz.ist.cc;

public class JasminIF_ICMPGEInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.IF_ICMPGE;
    public final String m_label;

    //------------------------------------------------------------------------------

    JasminIF_ICMPGEInstruction(String label) {
        m_label = label;
    }

    //------------------------------------------------------------------------------

    public JasminBaseInstruction.InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  if_icmpge " + m_label + "\n";
    }
}
