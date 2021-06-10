package at.tugraz.ist.cc;

public class JasminClassInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.CLASS;
    public String                m_class_name;

    //------------------------------------------------------------------------------

    JasminClassInstruction(String class_name) {
        m_class_name = class_name;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return ".class public " + m_class_name + "\n";
    }
}
