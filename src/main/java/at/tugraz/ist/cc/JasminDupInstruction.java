package at.tugraz.ist.cc;

public class JasminDupInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.DUP;

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  dup\n";
    }
}
