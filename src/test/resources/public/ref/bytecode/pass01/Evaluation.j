.source noSource
.class public Evaluation
.super java/lang/Object
.method public <init>()V
.limit stack 1
.limit locals 1
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method
.method public init()I
.limit stack 2
.limit locals 1
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc "Please dont forget to evaluate this course!\n"
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  ireturn
.end method

.method public setEvalMsg(Ljava/lang/String;I)I
.limit stack 2
.limit locals 4
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc "New evaluation for course "
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 3
  getstatic java/lang/System/out Ljava/io/PrintStream;
  iload 2
  invokevirtual java/io/PrintStream/print(I)V
  ldc 0
  istore 3
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc "\n"
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 3
  getstatic java/lang/System/out Ljava/io/PrintStream;
  aload 1
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 3
  ldc 0
  ireturn
.end method
