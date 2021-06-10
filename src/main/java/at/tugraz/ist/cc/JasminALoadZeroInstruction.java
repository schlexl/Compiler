package at.tugraz.ist.cc;

public class JasminALoadZeroInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.ALOAD_0;

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  aload_0\n";
    }
}
