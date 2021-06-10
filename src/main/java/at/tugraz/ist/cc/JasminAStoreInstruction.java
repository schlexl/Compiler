package at.tugraz.ist.cc;

public class JasminAStoreInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.ASTORE;
    public final int             m_index;

    //------------------------------------------------------------------------------

    JasminAStoreInstruction(int index) {
        m_index = index;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  astore " + m_index + "\n";
    }
}
