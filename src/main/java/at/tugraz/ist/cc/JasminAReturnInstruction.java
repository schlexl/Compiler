package at.tugraz.ist.cc;

public class JasminAReturnInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.ARETURN;

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  areturn\n";
    }
}
