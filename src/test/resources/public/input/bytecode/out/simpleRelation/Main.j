.source noSource
.class public Main
.super java/lang/Object
.method public static main([Ljava/lang/String;)V
.limit stack 20
.limit locals 10
  ldc 3
  istore 3
  ldc 6
  istore 4
  ldc 6
  ldc 6
  if_icmplt label_0
  ldc 1
  goto label_01
  label_0:
  ldc 0
  label_01:
  istore 1
  ldc "Trues below: \n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 2
  iload 1
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Z)V
  ldc 0
  istore 2
  ldc "\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 2
  ldc 3
  ldc 6
  if_icmpeq label_1
  ldc 1
  goto label_11
  label_1:
  ldc 0
  label_11:
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Z)V
  ldc 0
  istore 2
  ldc "\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 2
  ldc 3
  ldc 3
  if_icmpne label_2
  ldc 1
  goto label_21
  label_2:
  ldc 0
  label_21:
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Z)V
  ldc 0
  istore 2
  ldc "\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 2
  ldc 4
  ldc 3
  if_icmplt label_3
  ldc 1
  goto label_31
  label_3:
  ldc 0
  label_31:
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Z)V
  ldc 0
  istore 2
  ldc "\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 2
  ldc 4
  ldc 3
  if_icmplt label_4
  ldc 1
  goto label_41
  label_4:
  ldc 0
  label_41:
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Z)V
  ldc 0
  istore 2
  ldc "\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 2
  ldc "False below: \n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 2
  iload 3
  iload 4
  if_icmpne label_5
  ldc 1
  goto label_51
  label_5:
  ldc 0
  label_51:
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Z)V
  ldc 0
  istore 2
  ldc "\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 2
  iload 3
  iload 3
  if_icmpeq label_6
  ldc 1
  goto label_61
  label_6:
  ldc 0
  label_61:
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Z)V
  ldc 0
  istore 2
  ldc "\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 2
  ldc 5
  ldc 6
  if_icmplt label_7
  ldc 1
  goto label_71
  label_7:
  ldc 0
  label_71:
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Z)V
  ldc 0
  istore 2
  ldc "\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 2
  ldc 6
  ldc 4
  if_icmpgt label_8
  ldc 1
  goto label_81
  label_8:
  ldc 0
  label_81:
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Z)V
  ldc 0
  istore 2
  ldc "\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 2
  ldc 0
  return
.end method
