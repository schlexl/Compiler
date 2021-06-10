package at.tugraz.ist.cc;

public class JasminIAndInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.IAND;

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  iand\n";
    }
}
