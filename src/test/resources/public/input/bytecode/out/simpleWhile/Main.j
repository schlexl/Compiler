.source noSource
.class public Main
.super java/lang/Object
.method public static main([Ljava/lang/String;)V
.limit stack 20
.limit locals 10
  ldc 2
  istore 2
  ldc 4
  istore 3
  ldc 1
  istore 4
  label_0:
  iload 4
  ifeq label_1
  ldc 0
  istore 4
  iload 3
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
  iload 3
  ldc 1
  iadd
  istore 3
  goto label_0
  label_1:
  ldc 0
  return
.end method
