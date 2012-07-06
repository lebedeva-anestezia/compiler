grammar Pascal;

@header {

import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

}

@members {
	private Map<String, Integer> intVars = new HashMap<String, Integer>();  
	private int localVariables = 2;
    	private int currentStack = 1;
    	private int maxStack = 5;
	private int bufferedReaderIdentifier = 2;
	private static String code = "";                     
	private static String pre = "";
	private static int labelCount = 0;

	private void recordPush() {
        	++currentStack;
        	maxStack = Math.max(maxStack, currentStack);
   	 }

 	private void recordPop() {
        	--currentStack;
    	}
}

program returns [String ret]
	: 'program ' ID ';'
	('var' (variableDeclaration)*)?
	'begin'
	(statement)*
	'end.'
	{   
	  pre += ".class " + $ID.text + "\n";
          pre += ".super java/lang/Object\n";
          pre += ".method private <init>()V\n";
          pre += "aload_0\n";
          pre += "invokenonvirtual java/lang/Object/<init>()V\n";
          pre += "return\n";
          pre += ".end method\n";
          pre += ".method static public main([Ljava/lang/String;)V\n";
          pre += ".limit stack " + maxStack + "\n";
          pre += ".limit locals " + (localVariables + 1) + "\n";
          pre += "new java/io/BufferedReader\n";
          pre += "dup\n";
          pre += "new java/io/InputStreamReader\n";
          pre += "dup\n";
          pre += "getstatic java/lang/System/in Ljava/io/InputStream;\n";
          pre += "invokenonvirtual java/io/InputStreamReader/<init>(Ljava/io/InputStream;)V\n";
          pre += "invokenonvirtual java/io/BufferedReader/<init>(Ljava/io/Reader;)V\n";
          pre += "astore " + bufferedReaderIdentifier + "\n";
	
	  code = pre + code;
	  code += "aload " + bufferedReaderIdentifier + "\n";
          code += "invokevirtual java/io/Reader/close()V\n";
          code += "return\n";
          code += ".end method\n";
	  $ret = code;
	}
;

statement
	: writeOperation';'
	| variableAssignment';'
	| ifOperation
	| whileOperation
;

writeOperation
	: WRITE '('intExpression ')'
	{	code += "invokestatic java/lang/String/valueOf(I)Ljava/lang/String;\n"; 
		code += "getstatic java/lang/System/out Ljava/io/PrintStream;\n";
		code += "swap\n";
		code += "invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V\n";
		recordPop();
          	recordPop();	
	}
	| WRITELN '('intExpression ')'
	{	code += "invokestatic java/lang/String/valueOf(I)Ljava/lang/String;\n"; 
		code += "getstatic java/lang/System/out Ljava/io/PrintStream;\n";
		code += "swap\n";
		code += "invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n";
		recordPop();
          	recordPop();	
	}
;


whileOperation
@init {
	int goTrue = ++labelCount;
	int goFalse = ++labelCount;
	int localLabel = 0;
}
	: 'while' {                       
		localLabel = ++labelCount; 
		code += "label" + localLabel + ":\n";
	}
	logicExpression[goTrue, goFalse]
	'do' 'begin' {
		code += "label" + goTrue + ":\n";
	}
	(statement)* {
		code += "goto label" +  localLabel + "\n";
	}
	'end;' {
		code += "label" + goFalse + ":\n";
	}
;

ifOperation
@init {
	int localLabel = ++labelCount;
}
	: 'if' {                                         
		labelCount += 2;                              
	} logicExpression[localLabel + 1, localLabel] 'then' 'begin' { 
		code += "goto label" + localLabel + "\n"; 
		code += "label" + (localLabel + 1) + ":\n";
	}
	(statement)* (
		{
			code += "goto label" + (localLabel + 2) + "\n";
			code += "label" + localLabel + ":\n";
		}(
		'end;' 
		| 'end' 'else' 'begin' 
		(statement)* 'end;'
		)) {
			code += "label" + (localLabel + 2) + ":\n";
		}	
;

logicExpression[int isTrue, int isFalse]
	: logicOrExpression[isTrue, isFalse]
;

logicOrExpression[int isTrue, int isFalse]
@init {
	int goTrue = ++labelCount;
	int localLabel = ++labelCount;
}
	: logicAndExpression[goTrue, localLabel] 
      	('or' { 
			code += "label" + localLabel + ":\n";
			localLabel = ++labelCount;   
		} 
	logicAndExpression[goTrue, localLabel] )* {
		code += "label" + localLabel + ":\n";
		code += "goto label" + isFalse + "\n";	
		code += "label" + goTrue+ ":\n";
		code += "goto label" + isTrue + "\n";
	}	
;

logicAndExpression[int isTrue, int isFalse] 
@init {
	int goFalse = ++labelCount;
	int localLabel = ++labelCount;
}
    : logicCompareExpression[localLabel, goFalse] 
	      ('and' {
		code += "label" + localLabel + ":\n";
		localLabel = ++labelCount;        
        }
	logicCompareExpression[localLabel, goFalse] )* {
		code += "label" + localLabel + ":\n";	
		code += "goto label" + isTrue + "\n";
		code += "label" + goFalse + ":\n";
		code += "goto label" + isFalse + "\n";
	};


logicCompareExpression[int isTrue, int isFalse]
	: intExpression ( 
	'>' intExpression  {                                              	
		code += "if_icmpgt label" + isTrue + "\n";	
		code += "goto label" + isFalse + "\n";
	}
	|'<' intExpression {                                              
		code += "if_icmplt label" + isTrue + "\n";
		code += "goto label" + isFalse + "\n";
	}
	|'=' intExpression {                                              
		code += "if_icmpeq label" + isTrue + "\n";
		code += "goto label" + isFalse + "\n";
	}
	|'>=' intExpression {                                             
		code += "if_icmpge label" + isTrue + "\n";
		code += "goto label" + isFalse + "\n";
	}
	|'<=' intExpression {                                           
		code += "if_icmple label" + isTrue + "\n";
		code += "goto label" + isFalse + "\n";
	}
	|'<>' intExpression {                                           
		code += "if_icmpne label" + isTrue + "\n";
		code += "goto label" + isFalse + "\n";
	}
	){
		recordPop();
		recordPop();
	}
	| 'not ('logicExpression[isFalse, isTrue] ')'    
	| TRUE {
		code += "goto label" + isTrue + "\n";
	}
	| FALSE {
		code += "goto label" + isFalse + "\n";
	}
;


variableDeclaration
	: ID ':' 'Integer'
        {
            intVars.put($ID.text, ++localVariables);
        }
       ';'
;

variableAssignment 
    : {intVars.containsKey(input.LT(1).getText())}?=> ID ':=' intExpression 
      {
          code += "istore " + intVars.get($ID.text) + "\n";
	  recordPop();
      }
    ;


intExpression 
    : intMultExpression
      (('+' intMultExpression
          {
              code += "iadd\n";
	      recordPop();
          }
      ) | ('-' intMultExpression
          {
              code += "isub\n";
              recordPop();
          }
      ))*
    ;


intMultExpression
	: intValue
      	(('*' intValue
        {
              code += "imul\n";
	      recordPop();
        }
      	) | ('div' i3=intValue
          {
              code += "idiv\n";
	      recordPop();
          }
      ))*	;
               

intValue 
	: NUMBER
	{
		code += "ldc " + Integer.parseInt($NUMBER.text) + "\n";	
		recordPush();
	}
	| {intVars.containsKey(input.LT(1).getText())}?=> ID
      	{
          	code += "iload " + intVars.get($ID.text) + "\n";
		recordPush();
      	}
    	| '(' intExpression ')'
	| READ '()'
	{
		code += "aload " + bufferedReaderIdentifier + "\n";
          	recordPush();
          	code += "invokevirtual java/io/BufferedReader/readLine()Ljava/lang/String;\n"; 
		code += "invokestatic java/lang/Integer/parseInt(Ljava/lang/String;)I\n";	
	}
 	;

WRITE	: 'write';
WRITELN : 'writeln';
READ	: 'read';
TRUE	: 'true';
FALSE	: 'false';
ID	: ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '0'..'9' | '_')*;
NUMBER	: ('0'..'9')+;              
WS      : (' ' | '\t' | '\n' | '\r')+ { skip(); };
