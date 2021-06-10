package at.tugraz.ist.cc;

public class JasminIReturnInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.IRETURN;

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  ireturn\n";
    }
}
