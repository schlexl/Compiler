package at.tugraz.ist.cc;

interface JasminBaseInstruction {
    enum InstructionType {
        SOURCE,
        CLASS,
        SUPER,
        FIELD,
        DEFAULT_CTOR,
        START_METHOD,
        METHOD,
        LIMIT,
        RETURN,
        IRETURN,
        ARETURN,
        END,
        SWAP,
        DUP,
        POP,
        ILOAD,
        ISTORE,
        ALOAD,
        ASTORE,
        SIPUSH,
        BIPUSH,
        ICONST_N,
        LDC,
        IADD,
        ISUB,
        IMUL,
        IDIV,
        IREM,
        INEG,
        IAND,
        IOR,
        IF_ICMPLT, // <
        IF_ICMPLE, // <=
        IF_ICMPGE, // >=
        IF_ICMPGT, // >
        IF_ICMPEQ, // ==
        IF_ICMPNE, // !=
        IF_ACMPNE,
        IFEQ,
        IFNE,
        LABEL,
        GOTO,
        PUTFIELD,
        GETFIELD,
        GETSTATIC,
        INVOKEVIRTUAL,
        ALOAD_0,
        ACONST_NULL,
        NEW,
    }

    //------------------------------------------------------------------------------

    InstructionType getType();

    //------------------------------------------------------------------------------

    default String convertToString() {
        return null;
    }

    //------------------------------------------------------------------------------
}
