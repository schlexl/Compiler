.source noSource
.class public Printer
.super java/lang/Object

.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public printf(I)I
  .limit stack 13
  .limit locals 4
  getstatic java/lang/System/out Ljava/io/PrintStream;
  iload 1
  invokevirtual java/io/PrintStream/print(I)V
  ldc 0
  istore 2
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc "\n"
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 2
  ldc 0
  ireturn
.end method
