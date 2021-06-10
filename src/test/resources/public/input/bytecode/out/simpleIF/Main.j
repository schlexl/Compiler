.source noSource
.class public Main
.super java/lang/Object
.method public static main([Ljava/lang/String;)V
.limit stack 8
.limit locals 4
  ldc 1
  ifeq label_1
  ldc "show\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 1
  label_1:
  ldc 0
  ifeq label_2
  ldc "dont show\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 1
  goto label_3
  label_2:
  ldc "show again\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 1
  label_3:
  ldc 3
  ldc 5
  if_icmpgt label_3
  ldc 1
  goto label_31
  label_3:
  ldc 0
  label_31:
  ifeq label_3
  ldc "3 <= 5\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 1
  label_3:
  ldc 5
  ldc 3
  if_icmpgt label_5
  ldc 1
  goto label_51
  label_5:
  ldc 0
  label_51:
  ifeq label_5
  ldc 20
  istore 1
  goto label_6
  label_5:
  ldc "5 <= 3\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 1
  label_6:
  ldc 5
  ldc 3
  if_icmpgt label_7
  ldc 1
  goto label_71
  label_7:
  ldc 0
  label_71:
  ifeq label_7
  ldc 20
  istore 1
  label_7:
  ldc "END\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 1
  ldc 0
  return
.end method
