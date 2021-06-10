.source noSource
.class public Main
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 2
.limit locals 3
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc "Set it to W for WUMBO!\n"
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 1
  ldc 1
  istore 2
  iload 2
  ifeq L_0
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc "MAGNIFY!\n"
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 1
  goto L_1
  L_0:
  getstatic java/lang/System/out Ljava/io/PrintStream;
  ldc "EEEVIL!\n"
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 1
  L_1:
  return
.end method
