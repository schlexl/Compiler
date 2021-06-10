package at.tugraz.ist.cc;

public class JasminIStoreInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.ISTORE;
    public final int             m_index;

    //------------------------------------------------------------------------------

    JasminIStoreInstruction(int index) {
        m_index = index;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  istore " + m_index + "\n";
    }
}
