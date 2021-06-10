package at.tugraz.ist.cc;

public class JasminNewInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.NEW;
    private final String         m_class_name;

    //------------------------------------------------------------------------------

    JasminNewInstruction(String class_name) {
        m_class_name = class_name;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  new " + m_class_name + "\n";
    }
}