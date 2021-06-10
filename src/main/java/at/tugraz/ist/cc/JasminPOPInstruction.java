package at.tugraz.ist.cc;

public class JasminPOPInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.POP;

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  pop\n";
    }
}
