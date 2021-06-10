package at.tugraz.ist.cc;

public class JasminSuperInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.SUPER;

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return ".super java/lang/Object\n";
    }
}
