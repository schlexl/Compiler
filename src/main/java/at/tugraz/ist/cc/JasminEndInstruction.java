package at.tugraz.ist.cc;

public class JasminEndInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.END;

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return ".end method\n";
    }
}
