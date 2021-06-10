.source noSource
.class public Printer
.super java/lang/Object
.method public init()V
.limit stack 1
.limit locals 1
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method
.method public <printf>(int)I
.limit stack 6
.limit locals 3
  iload 1
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(I)V
  ldc 0
  istore 2
  ldc "\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 2
  ldc 0
  ireturn
.end method
