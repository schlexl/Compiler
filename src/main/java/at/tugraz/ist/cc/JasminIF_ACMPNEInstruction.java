package at.tugraz.ist.cc;

public class JasminIF_ACMPNEInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.IF_ACMPNE;
    public final String          m_label;

    //------------------------------------------------------------------------------

    JasminIF_ACMPNEInstruction(String label) {
        m_label = label;
    }

    //------------------------------------------------------------------------------

    public JasminBaseInstruction.InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  if_acmpne " + m_label + "\n";
    }
}
