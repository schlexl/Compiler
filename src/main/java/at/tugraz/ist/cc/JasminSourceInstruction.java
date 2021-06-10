package at.tugraz.ist.cc;

public class JasminSourceInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.SOURCE;
    public final String          m_source_of_assembly;

    //------------------------------------------------------------------------------

    JasminSourceInstruction(String source_of_assembly) {
        m_source_of_assembly = source_of_assembly;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return ".source " + m_source_of_assembly + "\n";
    }
}
