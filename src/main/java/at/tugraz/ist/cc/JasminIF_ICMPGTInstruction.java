package at.tugraz.ist.cc;

public class JasminIF_ICMPGTInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.IF_ICMPGT;
    public final String          m_label;

    //------------------------------------------------------------------------------

    JasminIF_ICMPGTInstruction(String label) {
        m_label = label;
    }

    //------------------------------------------------------------------------------

    public JasminBaseInstruction.InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  if_icmpgt " + m_label + "\n";
    }
}