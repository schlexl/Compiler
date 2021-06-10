package at.tugraz.ist.cc;

public class JasminReturnInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.RETURN;

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  return\n";
    }
}
