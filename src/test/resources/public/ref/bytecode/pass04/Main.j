.source noSource
.class public Main
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 2
.limit locals 2
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc "Hi, I am boolean: "
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 1
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc 1
  invokevirtual java/io/PrintStream/print(Z)V
  ldc 0
  istore 1
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc "\nHi boolean, I am number: "
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 1
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc 42
  invokevirtual java/io/PrintStream/print(I)V
  ldc 0
  istore 1
  return
.end method
