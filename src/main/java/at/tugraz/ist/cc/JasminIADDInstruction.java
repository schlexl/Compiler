package at.tugraz.ist.cc;

public class JasminIADDInstruction implements JasminBaseInstruction {
    public final JasminBaseInstruction.InstructionType Type = InstructionType.IADD;

    //------------------------------------------------------------------------------

    public JasminBaseInstruction.InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  iadd\n" ;
    }
}
