.source noSource
.class public Main
.super java/lang/Object
.method public static main([Ljava/lang/String;)V
.limit stack 16
.limit locals 8
  ldc 3
  istore 2
  ldc 2
  istore 3
  iload 3
  iload 2
  if_icmplt label_1
  ldc 0
  goto label_11
  label_1:
  ldc 1
  label_11:
  ifeq label_1
  ldc "works!!"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 1
  label_1:
  ldc 0
  return
.end method
