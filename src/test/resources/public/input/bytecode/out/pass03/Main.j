.source noSource
.class public Main
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 8
.limit locals 4
  new JonSnow
  dup
  invokespecial JonSnow/<init>()V
  astore 3
  aload 3
  astore 2
  ldc "So... what does Jon Snow know?\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 1
  aload 2
  aconst_null
  ldc  0
  ifeq if_stmt0
  goto else_stmt0
if_stmt0:
  ldc "He knows nix.\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 1
  goto end_0
else_stmt0:
  ldc "He knows somethin... wait, what?!\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 1
  goto end_0
end_0:
  return
.end method
