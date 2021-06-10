package at.tugraz.ist.cc;

public class JasminIF_ICMPLEInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.IF_ICMPLE;
    public final String          m_label;

    //------------------------------------------------------------------------------

    JasminIF_ICMPLEInstruction(String label) {
        m_label = label;
    }

    //------------------------------------------------------------------------------

    public JasminBaseInstruction.InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  if_icmple " + m_label + "\n";
    }
}
