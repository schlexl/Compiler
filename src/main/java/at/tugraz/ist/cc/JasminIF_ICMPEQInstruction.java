package at.tugraz.ist.cc;

public class JasminIF_ICMPEQInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.IF_ICMPEQ;
    public final String          m_label;

    //------------------------------------------------------------------------------

    JasminIF_ICMPEQInstruction(String lable) {
        m_label = lable;
    }

    //------------------------------------------------------------------------------

    public JasminBaseInstruction.InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  if_icmpeq " + m_label + "\n";
    }
}
