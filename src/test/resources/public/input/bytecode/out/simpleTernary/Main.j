.source noSource
.class public Main
.super java/lang/Object
.method public static main([Ljava/lang/String;)V
.limit stack 20
.limit locals 10
  ldc 0
  ifne label_0
  goto label_01
  label_0:
  ldc 5
  goto label_02
  label_01:
  ldc 10
  goto label_02
  label_02:
  istore 1
  ldc 0
  ifne label_1
  goto label_11
  label_1:
  ldc 1
  goto label_12
  label_11:
  ldc 0
  goto label_12
  label_12:
  istore 2
  iload 1
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(I)V
  ldc 0
  istore 4
  ldc "\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 4
  iload 2
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Z)V
  ldc 0
  istore 4
  ldc "\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 4
  ldc 1
  ifne label_2
  goto label_21
  label_2:
  ldc 0
  ifne label_3
  goto label_31
  label_3:
  ldc 3
  goto label_32
  label_31:
  ldc 5
  goto label_32
  label_32:
  goto label_22
  label_21:
  ldc 0
  goto label_22
  label_22:
  istore 3
  iload 3
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(I)V
  ldc 0
  istore 4
  ldc "\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 4
  ldc 5
  ldc 4
  if_icmplt label_5
  ldc 1
  goto label_51
  label_5:
  ldc 0
  label_51:
  ifne label_4
  goto label_41
  label_4:
  ldc 5
  goto label_42
  label_41:
  ldc 10
  goto label_42
  label_42:
  istore 1
  ldc 5
  ldc 4
  if_icmplt label_7
  ldc 1
  goto label_71
  label_7:
  ldc 0
  label_71:
  ifne label_6
  goto label_61
  label_6:
  ldc 1
  goto label_62
  label_61:
  ldc 0
  goto label_62
  label_62:
  istore 2
  iload 1
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(I)V
  ldc 0
  istore 4
  ldc "\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 4
  iload 2
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Z)V
  ldc 0
  istore 4
  ldc 0
  return
.end method
