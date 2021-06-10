package at.tugraz.ist.cc;

import java.util.HashMap;
import java.util.Map;

public class JasminFieldInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.FIELD;

    private final String m_field_amod;
    private final String m_field_type;
    private final String m_field_name;

    private Map<String, String> m_jasmin_type_mapping = new HashMap<>();

    //------------------------------------------------------------------------------

    JasminFieldInstruction(String field_amod, String field_type, String field_name) {
        m_field_amod = field_amod;
        m_field_type = field_type;
        m_field_name = field_name;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return ".field " + m_field_amod + " " + m_field_name + " " + m_field_type + "\n";
    }
}
