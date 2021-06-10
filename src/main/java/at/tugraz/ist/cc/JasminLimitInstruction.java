package at.tugraz.ist.cc;

public class JasminLimitInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.LIMIT;
    private final String m_context;
    private final int    m_amount;

    //------------------------------------------------------------------------------

    JasminLimitInstruction(String context, int amount) {
        m_context = context;
        m_amount  = amount;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return ".limit " + m_context + " " + m_amount + "\n";
    }
}
