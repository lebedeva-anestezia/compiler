.class test2
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
ldc 0
istore 3
ldc 0
istore 4
iload 3
aload 2
invokevirtual java/io/BufferedReader/readLine()Ljava/lang/String;
invokestatic java/lang/Integer/parseInt(Ljava/lang/String;)I
iadd
istore 4
iload 3
invokestatic java/lang/String/valueOf(I)Ljava/lang/String;
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
iload 4
invokestatic java/lang/String/valueOf(I)Ljava/lang/String;
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
aload 2
invokevirtual java/io/Reader/close()V
return
.end method

