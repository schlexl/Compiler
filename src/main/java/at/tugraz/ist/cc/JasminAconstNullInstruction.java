package at.tugraz.ist.cc;

public class JasminAconstNullInstruction implements JasminBaseInstruction {
    public final InstructionType Type = InstructionType.ACONST_NULL;

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
        return "  aconst_null\n";
    }
}
