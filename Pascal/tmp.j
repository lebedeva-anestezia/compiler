.class test
.super java/lang/Object
.method private <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method
.method static public main([Ljava/lang/String;)V
.limit stack 5
.limit locals 5
new java/io/BufferedReader
dup
new java/io/InputStreamReader
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokenonvirtual java/io/InputStreamReader/<init>(Ljava/io/InputStream;)V
invokenonvirtual java/io/BufferedReader/<init>(Ljava/io/Reader;)V
astore 2
ldc 3
istore 3
label3:
iload 3
ldc 0
if_icmpgt label7
goto label6
label7:
goto label4
label6:
goto label5
label5:
goto label2
label4:
goto label1
label1:
iload 3
ldc 1
isub
istore 3
iload 3
invokestatic java/lang/String/valueOf(I)Ljava/lang/String;
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
goto label3
label2:
ldc 3
ldc 2
ldc 1
iadd
imul
istore 4
iload 3
ldc 2
ldc 2
imul
if_icmplt label14
goto label13
label14:
goto label11
label13:
goto label12
label12:
iload 3
ldc 1
if_icmpeq label17
goto label16
label17:
goto label11
label16:
goto label15
label15:
goto label8
label11:
goto label9
goto label8
label9:
ldc 1
invokestatic java/lang/String/valueOf(I)Ljava/lang/String;
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
goto label10
label8:
ldc 2
ldc 1
imul
invokestatic java/lang/String/valueOf(I)Ljava/lang/String;
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
label10:
aload 2
invokevirtual java/io/Reader/close()V
return
.end method

