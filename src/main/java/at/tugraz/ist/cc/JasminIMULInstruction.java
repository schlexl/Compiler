package at.tugraz.ist.cc;

public class JasminIMULInstruction implements JasminBaseInstruction {
    public final JasminBaseInstruction.InstructionType Type = InstructionType.IMUL;

    //------------------------------------------------------------------------------

    public JasminBaseInstruction.InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  imul\n" ;
    }
}
