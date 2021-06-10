package at.tugraz.ist.cc;

public class JasminIDIVInstruction implements JasminBaseInstruction {
    public final JasminBaseInstruction.InstructionType Type = InstructionType.IDIV;

    //------------------------------------------------------------------------------

    public JasminBaseInstruction.InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  idiv\n" ;
    }
}
