.source noSource
.class public Main
.super java/lang/Object
.method public static main([Ljava/lang/String;)V
.limit stack 28
.limit locals 14
  ldc 1
  istore 2
  ldc 2
  istore 3
  iload 2
  ldc 1
  if_icmpne label_1
  ldc 1
  goto label_11
  label_1:
  ldc 0
  label_11:
  ifne label_0
  goto label_01
  label_0:
  iload 3
  ldc 2
  if_icmpne label_3
  ldc 1
  goto label_31
  label_3:
  ldc 0
  label_31:
  ifne label_2
  goto label_21
  label_2:
  ldc 3
  goto label_22
  label_21:
  ldc 5
  goto label_22
  label_22:
  goto label_02
  label_01:
  ldc 0
  goto label_02
  label_02:
  istore 5
  ldc "nested Result\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 6
  iload 5
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(I)V
  ldc 0
  istore 6
  ldc 0
  return
.end method
