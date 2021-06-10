package at.tugraz.ist.cc;

public class JasminSwapInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.SWAP;

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  swap\n";
    }
}
