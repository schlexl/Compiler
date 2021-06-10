package at.tugraz.ist.cc;

public class JasminISUBInstruction implements JasminBaseInstruction {
    public final JasminBaseInstruction.InstructionType Type = InstructionType.ISUB;

    //------------------------------------------------------------------------------

    public JasminBaseInstruction.InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  isub\n" ;
    }
}
