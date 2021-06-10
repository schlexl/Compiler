package at.tugraz.ist.cc;

public class JasminIREMInstruction implements JasminBaseInstruction {
    public final JasminBaseInstruction.InstructionType Type = InstructionType.IREM;

    //------------------------------------------------------------------------------

    public JasminBaseInstruction.InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  irem\n" ;
    }
}
