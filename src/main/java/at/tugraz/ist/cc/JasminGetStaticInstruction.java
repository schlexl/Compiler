package at.tugraz.ist.cc;

public class JasminGetStaticInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.GETSTATIC;
    public final String          m_field_name;
    public final String          m_descriptor;

    //------------------------------------------------------------------------------

    JasminGetStaticInstruction(String field_name, String descriptor) {
        m_field_name = field_name;
        m_descriptor = descriptor;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  getstatic " + m_field_name + " " + m_descriptor + "\n";
    }
}
