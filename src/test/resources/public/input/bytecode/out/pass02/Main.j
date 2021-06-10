.source noSource
.class public Main
.super java/lang/Object
.method public static main([Ljava/lang/String;)V
.limit stack 6
.limit locals 3
  ldc "Set it to W for WUMBO!\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 1
  ldc 1
  istore 2
  iload 2
  ifne if_stmt0
  goto else_stmt0
if_stmt0:
  ldc "MAGNIFY!\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 1
  goto end_0
else_stmt0:
  ldc "EEEVIL!\n"
  getstatic java/lang/System/out Ljava/io/PrintStream;
  swap
  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
  ldc 0
  istore 1
  goto end_0
end_0:
  return
.end method
