package at.tugraz.ist.cc;

import java.util.ArrayList;
import java.util.List;

public class JasminStartMethodInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.START_METHOD;
    private final String         m_method_amod;
    private final String         m_method_name;
    private final String         m_method_params;
    private final String         m_method_type;

    //------------------------------------------------------------------------------

    JasminStartMethodInstruction(String method_amod, String method_name, String method_params, String method_type) {
        m_method_amod   = method_amod;
        m_method_name   = method_name;
        m_method_params = method_params;
        m_method_type   = method_type;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return ".method " + m_method_amod + " " + m_method_name + "(" + m_method_params + ")" + m_method_type + "\n";
    }
}
