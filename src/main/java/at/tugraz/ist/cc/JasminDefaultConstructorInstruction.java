package at.tugraz.ist.cc;

public class JasminDefaultConstructorInstruction implements JasminBaseInstruction {
    public final InstructionType    Type                = InstructionType.DEFAULT_CTOR;
    private JasminMethodInstruction m_ctor_instructions = null;

    //------------------------------------------------------------------------------

    JasminDefaultConstructorInstruction() {
        JasminMethodInstruction ctor = new JasminMethodInstruction("public", "<init>", "" ,"V");

        ctor.addMethodInstruction(new JasminLimitInstruction("stack", 1));
        ctor.addMethodInstruction(new JasminLimitInstruction("locals", 1));
        ctor.addMethodInstruction(new JasminALoadZeroInstruction());
        ctor.addMethodInstruction(new JasminInvokeSpecialInstruction("java/lang/Object/<init>()", "V"));
        ctor.addMethodInstruction(new JasminReturnInstruction());

        m_ctor_instructions = ctor;
    }

    //------------------------------------------------------------------------------

    public InstructionType getType() {
        return Type;
    }

    //------------------------------------------------------------------------------

    public String convertToString() {
       return m_ctor_instructions.convertToString();
    }
}
