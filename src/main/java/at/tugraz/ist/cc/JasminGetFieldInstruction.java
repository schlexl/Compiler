package at.tugraz.ist.cc;

public class JasminGetFieldInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.GETFIELD;
    private final String m_class_name;
    private final String m_field_name;
    private final String m_field_type;

    //------------------------------------------------------------------------------

    JasminGetFieldInstruction(String class_name, String field_name, String field_type) {
        m_class_name = class_name;
        m_field_name = field_name;
        m_field_type = field_type;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  getfield " + m_class_name + "/" + m_field_name + " " + m_field_type + "\n";
    }
}
