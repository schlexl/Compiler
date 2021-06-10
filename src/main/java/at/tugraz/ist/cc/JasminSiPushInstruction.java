package at.tugraz.ist.cc;

public class JasminSiPushInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.SUPER;
    public final int             m_constant;

    //------------------------------------------------------------------------------

    JasminSiPushInstruction(int constant) {
        m_constant = constant;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  sipush " + m_constant + "\n";
    }
}
