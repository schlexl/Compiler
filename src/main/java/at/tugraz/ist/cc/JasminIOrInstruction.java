package at.tugraz.ist.cc;

public class JasminIOrInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.IOR;

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  ior\n";
    }
}
