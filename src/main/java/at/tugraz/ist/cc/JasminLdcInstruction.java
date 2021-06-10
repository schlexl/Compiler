package at.tugraz.ist.cc;

public class JasminLdcInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.LDC;
    public final String          m_constant;

    //------------------------------------------------------------------------------

    JasminLdcInstruction(String constant) {
        m_constant = constant;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  ldc " + m_constant + "\n";
    }
}
