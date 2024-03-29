// $ANTLR 3.3 Nov 30, 2010 12:50:56 Pascal.g 2012-07-07 01:36:58


import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PascalParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "WRITE", "WRITELN", "TRUE", "FALSE", "NUMBER", "READ", "WS", "'program '", "';'", "'var'", "'begin'", "'end.'", "'('", "')'", "'while'", "'do'", "'end;'", "'if'", "'then'", "'end'", "'else'", "'or'", "'and'", "'>'", "'<'", "'='", "'>='", "'<='", "'<>'", "'not ('", "':'", "'Integer'", "':='", "'+'", "'-'", "'*'", "'div'", "'()'"
    };
    public static final int EOF=-1;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int ID=4;
    public static final int WRITE=5;
    public static final int WRITELN=6;
    public static final int TRUE=7;
    public static final int FALSE=8;
    public static final int NUMBER=9;
    public static final int READ=10;
    public static final int WS=11;

    // delegates
    // delegators


        public PascalParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PascalParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PascalParser.tokenNames; }
    public String getGrammarFileName() { return "Pascal.g"; }


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



    // $ANTLR start "program"
    // Pascal.g:36:1: program returns [String ret] : 'program ' ID ';' ( 'var' ( variableDeclaration )* )? 'begin' ( statement )* 'end.' ;
    public final String program() throws RecognitionException {
        String ret = null;

        Token ID1=null;

        try {
            // Pascal.g:37:2: ( 'program ' ID ';' ( 'var' ( variableDeclaration )* )? 'begin' ( statement )* 'end.' )
            // Pascal.g:37:4: 'program ' ID ';' ( 'var' ( variableDeclaration )* )? 'begin' ( statement )* 'end.'
            {
            match(input,12,FOLLOW_12_in_program27); 
            ID1=(Token)match(input,ID,FOLLOW_ID_in_program29); 
            match(input,13,FOLLOW_13_in_program31); 
            // Pascal.g:38:2: ( 'var' ( variableDeclaration )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Pascal.g:38:3: 'var' ( variableDeclaration )*
                    {
                    match(input,14,FOLLOW_14_in_program35); 
                    // Pascal.g:38:9: ( variableDeclaration )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==ID) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // Pascal.g:38:10: variableDeclaration
                    	    {
                    	    pushFollow(FOLLOW_variableDeclaration_in_program38);
                    	    variableDeclaration();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,15,FOLLOW_15_in_program45); 
            // Pascal.g:40:2: ( statement )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=WRITE && LA3_0<=WRITELN)) ) {
                    alt3=1;
                }
                else if ( (LA3_0==ID) && ((intVars.containsKey(input.LT(1).getText())))) {
                    alt3=1;
                }
                else if ( (LA3_0==19||LA3_0==22) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Pascal.g:40:3: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program49);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,16,FOLLOW_16_in_program54); 
               
            	  pre += ".class " + (ID1!=null?ID1.getText():null) + "\n";
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
            	  ret = code;
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret;
    }
    // $ANTLR end "program"


    // $ANTLR start "statement"
    // Pascal.g:71:1: statement : ( writeOperation ';' | variableAssignment ';' | ifOperation | whileOperation );
    public final void statement() throws RecognitionException {
        try {
            // Pascal.g:72:2: ( writeOperation ';' | variableAssignment ';' | ifOperation | whileOperation )
            int alt4=4;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=WRITE && LA4_0<=WRITELN)) ) {
                alt4=1;
            }
            else if ( (LA4_0==ID) && ((intVars.containsKey(input.LT(1).getText())))) {
                alt4=2;
            }
            else if ( (LA4_0==22) ) {
                alt4=3;
            }
            else if ( (LA4_0==19) ) {
                alt4=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // Pascal.g:72:4: writeOperation ';'
                    {
                    pushFollow(FOLLOW_writeOperation_in_statement67);
                    writeOperation();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statement68); 

                    }
                    break;
                case 2 :
                    // Pascal.g:73:4: variableAssignment ';'
                    {
                    pushFollow(FOLLOW_variableAssignment_in_statement73);
                    variableAssignment();

                    state._fsp--;

                    match(input,13,FOLLOW_13_in_statement74); 

                    }
                    break;
                case 3 :
                    // Pascal.g:74:4: ifOperation
                    {
                    pushFollow(FOLLOW_ifOperation_in_statement79);
                    ifOperation();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // Pascal.g:75:4: whileOperation
                    {
                    pushFollow(FOLLOW_whileOperation_in_statement84);
                    whileOperation();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "statement"


    // $ANTLR start "writeOperation"
    // Pascal.g:78:1: writeOperation : ( WRITE '(' intExpression ')' | WRITELN '(' intExpression ')' );
    public final void writeOperation() throws RecognitionException {
        try {
            // Pascal.g:79:2: ( WRITE '(' intExpression ')' | WRITELN '(' intExpression ')' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==WRITE) ) {
                alt5=1;
            }
            else if ( (LA5_0==WRITELN) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // Pascal.g:79:4: WRITE '(' intExpression ')'
                    {
                    match(input,WRITE,FOLLOW_WRITE_in_writeOperation94); 
                    match(input,17,FOLLOW_17_in_writeOperation96); 
                    pushFollow(FOLLOW_intExpression_in_writeOperation97);
                    intExpression();

                    state._fsp--;

                    match(input,18,FOLLOW_18_in_writeOperation99); 
                    	code += "invokestatic java/lang/String/valueOf(I)Ljava/lang/String;\n"; 
                    		code += "getstatic java/lang/System/out Ljava/io/PrintStream;\n";
                    		code += "swap\n";
                    		code += "invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V\n";
                    		recordPop();
                              	recordPop();	
                    	

                    }
                    break;
                case 2 :
                    // Pascal.g:87:4: WRITELN '(' intExpression ')'
                    {
                    match(input,WRITELN,FOLLOW_WRITELN_in_writeOperation107); 
                    match(input,17,FOLLOW_17_in_writeOperation109); 
                    pushFollow(FOLLOW_intExpression_in_writeOperation110);
                    intExpression();

                    state._fsp--;

                    match(input,18,FOLLOW_18_in_writeOperation112); 
                    	code += "invokestatic java/lang/String/valueOf(I)Ljava/lang/String;\n"; 
                    		code += "getstatic java/lang/System/out Ljava/io/PrintStream;\n";
                    		code += "swap\n";
                    		code += "invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n";
                    		recordPop();
                              	recordPop();	
                    	

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "writeOperation"


    // $ANTLR start "whileOperation"
    // Pascal.g:98:1: whileOperation : 'while' logicExpression[goTrue, goFalse] 'do' 'begin' ( statement )* 'end;' ;
    public final void whileOperation() throws RecognitionException {

        	int goTrue = ++labelCount;
        	int goFalse = ++labelCount;
        	int localLabel = 0;

        try {
            // Pascal.g:104:2: ( 'while' logicExpression[goTrue, goFalse] 'do' 'begin' ( statement )* 'end;' )
            // Pascal.g:104:4: 'while' logicExpression[goTrue, goFalse] 'do' 'begin' ( statement )* 'end;'
            {
            match(input,19,FOLLOW_19_in_whileOperation131); 
                                   
            		localLabel = ++labelCount; 
            		code += "label" + localLabel + ":\n";
            	
            pushFollow(FOLLOW_logicExpression_in_whileOperation136);
            logicExpression(goTrue, goFalse);

            state._fsp--;

            match(input,20,FOLLOW_20_in_whileOperation140); 
            match(input,15,FOLLOW_15_in_whileOperation142); 

            		code += "label" + goTrue + ":\n";
            	
            // Pascal.g:112:2: ( statement )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=WRITE && LA6_0<=WRITELN)) ) {
                    alt6=1;
                }
                else if ( (LA6_0==ID) && ((intVars.containsKey(input.LT(1).getText())))) {
                    alt6=1;
                }
                else if ( (LA6_0==19||LA6_0==22) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Pascal.g:112:3: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_whileOperation148);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            		code += "goto label" +  localLabel + "\n";
            	
            match(input,21,FOLLOW_21_in_whileOperation155); 

            		code += "label" + goFalse + ":\n";
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "whileOperation"


    // $ANTLR start "ifOperation"
    // Pascal.g:120:1: ifOperation : 'if' logicExpression[localLabel + 1, localLabel] 'then' 'begin' ( statement )* ( ( 'end;' | 'end' 'else' 'begin' ( statement )* 'end;' ) ) ;
    public final void ifOperation() throws RecognitionException {

        	int localLabel = ++labelCount;

        try {
            // Pascal.g:124:2: ( 'if' logicExpression[localLabel + 1, localLabel] 'then' 'begin' ( statement )* ( ( 'end;' | 'end' 'else' 'begin' ( statement )* 'end;' ) ) )
            // Pascal.g:124:4: 'if' logicExpression[localLabel + 1, localLabel] 'then' 'begin' ( statement )* ( ( 'end;' | 'end' 'else' 'begin' ( statement )* 'end;' ) )
            {
            match(input,22,FOLLOW_22_in_ifOperation172); 
                                                     
            		labelCount += 2;                              
            	
            pushFollow(FOLLOW_logicExpression_in_ifOperation176);
            logicExpression(localLabel + 1, localLabel);

            state._fsp--;

            match(input,23,FOLLOW_23_in_ifOperation179); 
            match(input,15,FOLLOW_15_in_ifOperation181); 
             
            		code += "goto label" + localLabel + "\n"; 
            		code += "label" + (localLabel + 1) + ":\n";
            	
            // Pascal.g:130:2: ( statement )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=WRITE && LA7_0<=WRITELN)) ) {
                    alt7=1;
                }
                else if ( (LA7_0==ID) && ((intVars.containsKey(input.LT(1).getText())))) {
                    alt7=1;
                }
                else if ( (LA7_0==19||LA7_0==22) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Pascal.g:130:3: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_ifOperation187);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // Pascal.g:130:15: ( ( 'end;' | 'end' 'else' 'begin' ( statement )* 'end;' ) )
            // Pascal.g:131:3: ( 'end;' | 'end' 'else' 'begin' ( statement )* 'end;' )
            {

            			code += "goto label" + (localLabel + 2) + "\n";
            			code += "label" + localLabel + ":\n";
            		
            // Pascal.g:134:4: ( 'end;' | 'end' 'else' 'begin' ( statement )* 'end;' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            else if ( (LA9_0==24) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // Pascal.g:135:3: 'end;'
                    {
                    match(input,21,FOLLOW_21_in_ifOperation200); 

                    }
                    break;
                case 2 :
                    // Pascal.g:136:5: 'end' 'else' 'begin' ( statement )* 'end;'
                    {
                    match(input,24,FOLLOW_24_in_ifOperation207); 
                    match(input,25,FOLLOW_25_in_ifOperation209); 
                    match(input,15,FOLLOW_15_in_ifOperation211); 
                    // Pascal.g:137:3: ( statement )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>=WRITE && LA8_0<=WRITELN)) ) {
                            alt8=1;
                        }
                        else if ( (LA8_0==ID) && ((intVars.containsKey(input.LT(1).getText())))) {
                            alt8=1;
                        }
                        else if ( (LA8_0==19||LA8_0==22) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // Pascal.g:137:4: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_ifOperation217);
                    	    statement();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    match(input,21,FOLLOW_21_in_ifOperation221); 

                    }
                    break;

            }


            }


            			code += "label" + (localLabel + 2) + ":\n";
            		

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ifOperation"


    // $ANTLR start "logicExpression"
    // Pascal.g:143:1: logicExpression[int isTrue, int isFalse] : logicOrExpression[isTrue, isFalse] ;
    public final void logicExpression(int isTrue, int isFalse) throws RecognitionException {
        try {
            // Pascal.g:144:2: ( logicOrExpression[isTrue, isFalse] )
            // Pascal.g:144:4: logicOrExpression[isTrue, isFalse]
            {
            pushFollow(FOLLOW_logicOrExpression_in_logicExpression240);
            logicOrExpression(isTrue, isFalse);

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "logicExpression"


    // $ANTLR start "logicOrExpression"
    // Pascal.g:147:1: logicOrExpression[int isTrue, int isFalse] : logicAndExpression[goTrue, localLabel] ( 'or' logicAndExpression[goTrue, localLabel] )* ;
    public final void logicOrExpression(int isTrue, int isFalse) throws RecognitionException {

        	int goTrue = ++labelCount;
        	int localLabel = ++labelCount;

        try {
            // Pascal.g:152:2: ( logicAndExpression[goTrue, localLabel] ( 'or' logicAndExpression[goTrue, localLabel] )* )
            // Pascal.g:152:4: logicAndExpression[goTrue, localLabel] ( 'or' logicAndExpression[goTrue, localLabel] )*
            {
            pushFollow(FOLLOW_logicAndExpression_in_logicOrExpression257);
            logicAndExpression(goTrue, localLabel);

            state._fsp--;

            // Pascal.g:153:8: ( 'or' logicAndExpression[goTrue, localLabel] )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==26) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Pascal.g:153:9: 'or' logicAndExpression[goTrue, localLabel]
            	    {
            	    match(input,26,FOLLOW_26_in_logicOrExpression269); 
            	     
            	    			code += "label" + localLabel + ":\n";
            	    			localLabel = ++labelCount;   
            	    		
            	    pushFollow(FOLLOW_logicAndExpression_in_logicOrExpression275);
            	    logicAndExpression(goTrue, localLabel);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            		code += "label" + localLabel + ":\n";
            		code += "goto label" + isFalse + "\n";	
            		code += "label" + goTrue+ ":\n";
            		code += "goto label" + isTrue + "\n";
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "logicOrExpression"


    // $ANTLR start "logicAndExpression"
    // Pascal.g:165:1: logicAndExpression[int isTrue, int isFalse] : logicCompareExpression[localLabel, goFalse] ( 'and' logicCompareExpression[localLabel, goFalse] )* ;
    public final void logicAndExpression(int isTrue, int isFalse) throws RecognitionException {

        	int goFalse = ++labelCount;
        	int localLabel = ++labelCount;

        try {
            // Pascal.g:170:5: ( logicCompareExpression[localLabel, goFalse] ( 'and' logicCompareExpression[localLabel, goFalse] )* )
            // Pascal.g:170:7: logicCompareExpression[localLabel, goFalse] ( 'and' logicCompareExpression[localLabel, goFalse] )*
            {
            pushFollow(FOLLOW_logicCompareExpression_in_logicAndExpression302);
            logicCompareExpression(localLabel, goFalse);

            state._fsp--;

            // Pascal.g:171:8: ( 'and' logicCompareExpression[localLabel, goFalse] )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==27) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Pascal.g:171:9: 'and' logicCompareExpression[localLabel, goFalse]
            	    {
            	    match(input,27,FOLLOW_27_in_logicAndExpression314); 

            	    		code += "label" + localLabel + ":\n";
            	    		localLabel = ++labelCount;        
            	            
            	    pushFollow(FOLLOW_logicCompareExpression_in_logicAndExpression319);
            	    logicCompareExpression(localLabel, goFalse);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            		code += "label" + localLabel + ":\n";	
            		code += "goto label" + isTrue + "\n";
            		code += "label" + goFalse + ":\n";
            		code += "goto label" + isFalse + "\n";
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "logicAndExpression"


    // $ANTLR start "logicCompareExpression"
    // Pascal.g:183:1: logicCompareExpression[int isTrue, int isFalse] : ( intExpression ( '>' intExpression | '<' intExpression | '=' intExpression | '>=' intExpression | '<=' intExpression | '<>' intExpression ) | 'not (' logicExpression[isFalse, isTrue] ')' | TRUE | FALSE );
    public final void logicCompareExpression(int isTrue, int isFalse) throws RecognitionException {
        try {
            // Pascal.g:184:2: ( intExpression ( '>' intExpression | '<' intExpression | '=' intExpression | '>=' intExpression | '<=' intExpression | '<>' intExpression ) | 'not (' logicExpression[isFalse, isTrue] ')' | TRUE | FALSE )
            int alt13=4;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==NUMBER) ) {
                alt13=1;
            }
            else if ( (LA13_0==ID) && ((intVars.containsKey(input.LT(1).getText())))) {
                alt13=1;
            }
            else if ( (LA13_0==READ||LA13_0==17) ) {
                alt13=1;
            }
            else if ( (LA13_0==34) ) {
                alt13=2;
            }
            else if ( (LA13_0==TRUE) ) {
                alt13=3;
            }
            else if ( (LA13_0==FALSE) ) {
                alt13=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // Pascal.g:184:4: intExpression ( '>' intExpression | '<' intExpression | '=' intExpression | '>=' intExpression | '<=' intExpression | '<>' intExpression )
                    {
                    pushFollow(FOLLOW_intExpression_in_logicCompareExpression336);
                    intExpression();

                    state._fsp--;

                    // Pascal.g:184:18: ( '>' intExpression | '<' intExpression | '=' intExpression | '>=' intExpression | '<=' intExpression | '<>' intExpression )
                    int alt12=6;
                    switch ( input.LA(1) ) {
                    case 28:
                        {
                        alt12=1;
                        }
                        break;
                    case 29:
                        {
                        alt12=2;
                        }
                        break;
                    case 30:
                        {
                        alt12=3;
                        }
                        break;
                    case 31:
                        {
                        alt12=4;
                        }
                        break;
                    case 32:
                        {
                        alt12=5;
                        }
                        break;
                    case 33:
                        {
                        alt12=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }

                    switch (alt12) {
                        case 1 :
                            // Pascal.g:185:2: '>' intExpression
                            {
                            match(input,28,FOLLOW_28_in_logicCompareExpression342); 
                            pushFollow(FOLLOW_intExpression_in_logicCompareExpression344);
                            intExpression();

                            state._fsp--;

                                                                          	
                            		code += "if_icmpgt label" + isTrue + "\n";	
                            		code += "goto label" + isFalse + "\n";
                            	

                            }
                            break;
                        case 2 :
                            // Pascal.g:189:3: '<' intExpression
                            {
                            match(input,29,FOLLOW_29_in_logicCompareExpression351); 
                            pushFollow(FOLLOW_intExpression_in_logicCompareExpression353);
                            intExpression();

                            state._fsp--;

                                                                          
                            		code += "if_icmplt label" + isTrue + "\n";
                            		code += "goto label" + isFalse + "\n";
                            	

                            }
                            break;
                        case 3 :
                            // Pascal.g:193:3: '=' intExpression
                            {
                            match(input,30,FOLLOW_30_in_logicCompareExpression359); 
                            pushFollow(FOLLOW_intExpression_in_logicCompareExpression361);
                            intExpression();

                            state._fsp--;

                                                                          
                            		code += "if_icmpeq label" + isTrue + "\n";
                            		code += "goto label" + isFalse + "\n";
                            	

                            }
                            break;
                        case 4 :
                            // Pascal.g:197:3: '>=' intExpression
                            {
                            match(input,31,FOLLOW_31_in_logicCompareExpression367); 
                            pushFollow(FOLLOW_intExpression_in_logicCompareExpression369);
                            intExpression();

                            state._fsp--;

                                                                         
                            		code += "if_icmpge label" + isTrue + "\n";
                            		code += "goto label" + isFalse + "\n";
                            	

                            }
                            break;
                        case 5 :
                            // Pascal.g:201:3: '<=' intExpression
                            {
                            match(input,32,FOLLOW_32_in_logicCompareExpression375); 
                            pushFollow(FOLLOW_intExpression_in_logicCompareExpression377);
                            intExpression();

                            state._fsp--;

                                                                       
                            		code += "if_icmple label" + isTrue + "\n";
                            		code += "goto label" + isFalse + "\n";
                            	

                            }
                            break;
                        case 6 :
                            // Pascal.g:205:3: '<>' intExpression
                            {
                            match(input,33,FOLLOW_33_in_logicCompareExpression383); 
                            pushFollow(FOLLOW_intExpression_in_logicCompareExpression385);
                            intExpression();

                            state._fsp--;

                                                                       
                            		code += "if_icmpne label" + isTrue + "\n";
                            		code += "goto label" + isFalse + "\n";
                            	

                            }
                            break;

                    }


                    		recordPop();
                    		recordPop();
                    	

                    }
                    break;
                case 2 :
                    // Pascal.g:213:4: 'not (' logicExpression[isFalse, isTrue] ')'
                    {
                    match(input,34,FOLLOW_34_in_logicCompareExpression396); 
                    pushFollow(FOLLOW_logicExpression_in_logicCompareExpression397);
                    logicExpression(isFalse, isTrue);

                    state._fsp--;

                    match(input,18,FOLLOW_18_in_logicCompareExpression400); 

                    }
                    break;
                case 3 :
                    // Pascal.g:214:4: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_logicCompareExpression409); 

                    		code += "goto label" + isTrue + "\n";
                    	

                    }
                    break;
                case 4 :
                    // Pascal.g:217:4: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_logicCompareExpression416); 

                    		code += "goto label" + isFalse + "\n";
                    	

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "logicCompareExpression"


    // $ANTLR start "variableDeclaration"
    // Pascal.g:223:1: variableDeclaration : ID ':' 'Integer' ';' ;
    public final void variableDeclaration() throws RecognitionException {
        Token ID2=null;

        try {
            // Pascal.g:224:2: ( ID ':' 'Integer' ';' )
            // Pascal.g:224:4: ID ':' 'Integer' ';'
            {
            ID2=(Token)match(input,ID,FOLLOW_ID_in_variableDeclaration429); 
            match(input,35,FOLLOW_35_in_variableDeclaration431); 
            match(input,36,FOLLOW_36_in_variableDeclaration433); 

                        intVars.put((ID2!=null?ID2.getText():null), ++localVariables);
            	    code += "ldc 0\n";	
            	    recordPush();
            	    code += "istore " + localVariables + "\n";
                        recordPop();
                    
            match(input,13,FOLLOW_13_in_variableDeclaration452); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "variableDeclaration"


    // $ANTLR start "variableAssignment"
    // Pascal.g:235:1: variableAssignment : {...}? => ID ':=' intExpression ;
    public final void variableAssignment() throws RecognitionException {
        Token ID3=null;

        try {
            // Pascal.g:236:5: ({...}? => ID ':=' intExpression )
            // Pascal.g:236:7: {...}? => ID ':=' intExpression
            {
            if ( !((intVars.containsKey(input.LT(1).getText()))) ) {
                throw new FailedPredicateException(input, "variableAssignment", "intVars.containsKey(input.LT(1).getText())");
            }
            ID3=(Token)match(input,ID,FOLLOW_ID_in_variableAssignment469); 
            match(input,37,FOLLOW_37_in_variableAssignment471); 
            pushFollow(FOLLOW_intExpression_in_variableAssignment473);
            intExpression();

            state._fsp--;


                      code += "istore " + intVars.get((ID3!=null?ID3.getText():null)) + "\n";
            	  recordPop();
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "variableAssignment"


    // $ANTLR start "intExpression"
    // Pascal.g:244:1: intExpression : intMultExpression ( ( '+' intMultExpression ) | ( '-' intMultExpression ) )* ;
    public final void intExpression() throws RecognitionException {
        try {
            // Pascal.g:245:5: ( intMultExpression ( ( '+' intMultExpression ) | ( '-' intMultExpression ) )* )
            // Pascal.g:245:7: intMultExpression ( ( '+' intMultExpression ) | ( '-' intMultExpression ) )*
            {
            pushFollow(FOLLOW_intMultExpression_in_intExpression501);
            intMultExpression();

            state._fsp--;

            // Pascal.g:246:7: ( ( '+' intMultExpression ) | ( '-' intMultExpression ) )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==38) ) {
                    alt14=1;
                }
                else if ( (LA14_0==39) ) {
                    alt14=2;
                }


                switch (alt14) {
            	case 1 :
            	    // Pascal.g:246:8: ( '+' intMultExpression )
            	    {
            	    // Pascal.g:246:8: ( '+' intMultExpression )
            	    // Pascal.g:246:9: '+' intMultExpression
            	    {
            	    match(input,38,FOLLOW_38_in_intExpression511); 
            	    pushFollow(FOLLOW_intMultExpression_in_intExpression513);
            	    intMultExpression();

            	    state._fsp--;


            	                  code += "iadd\n";
            	    	      recordPop();
            	              

            	    }


            	    }
            	    break;
            	case 2 :
            	    // Pascal.g:251:11: ( '-' intMultExpression )
            	    {
            	    // Pascal.g:251:11: ( '-' intMultExpression )
            	    // Pascal.g:251:12: '-' intMultExpression
            	    {
            	    match(input,39,FOLLOW_39_in_intExpression538); 
            	    pushFollow(FOLLOW_intMultExpression_in_intExpression540);
            	    intMultExpression();

            	    state._fsp--;


            	                  code += "isub\n";
            	                  recordPop();
            	              

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "intExpression"


    // $ANTLR start "intMultExpression"
    // Pascal.g:260:1: intMultExpression : intValue ( ( '*' intValue ) | ( 'div' i3= intValue ) )* ;
    public final void intMultExpression() throws RecognitionException {
        try {
            // Pascal.g:261:2: ( intValue ( ( '*' intValue ) | ( 'div' i3= intValue ) )* )
            // Pascal.g:261:4: intValue ( ( '*' intValue ) | ( 'div' i3= intValue ) )*
            {
            pushFollow(FOLLOW_intValue_in_intMultExpression577);
            intValue();

            state._fsp--;

            // Pascal.g:262:8: ( ( '*' intValue ) | ( 'div' i3= intValue ) )*
            loop15:
            do {
                int alt15=3;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==40) ) {
                    alt15=1;
                }
                else if ( (LA15_0==41) ) {
                    alt15=2;
                }


                switch (alt15) {
            	case 1 :
            	    // Pascal.g:262:9: ( '*' intValue )
            	    {
            	    // Pascal.g:262:9: ( '*' intValue )
            	    // Pascal.g:262:10: '*' intValue
            	    {
            	    match(input,40,FOLLOW_40_in_intMultExpression588); 
            	    pushFollow(FOLLOW_intValue_in_intMultExpression590);
            	    intValue();

            	    state._fsp--;


            	                  code += "imul\n";
            	    	      recordPop();
            	            

            	    }


            	    }
            	    break;
            	case 2 :
            	    // Pascal.g:267:12: ( 'div' i3= intValue )
            	    {
            	    // Pascal.g:267:12: ( 'div' i3= intValue )
            	    // Pascal.g:267:13: 'div' i3= intValue
            	    {
            	    match(input,41,FOLLOW_41_in_intMultExpression614); 
            	    pushFollow(FOLLOW_intValue_in_intMultExpression618);
            	    intValue();

            	    state._fsp--;


            	                  code += "idiv\n";
            	    	      recordPop();
            	              

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "intMultExpression"


    // $ANTLR start "intValue"
    // Pascal.g:275:1: intValue : ( NUMBER | {...}? => ID | '(' intExpression ')' | READ '()' );
    public final void intValue() throws RecognitionException {
        Token NUMBER4=null;
        Token ID5=null;

        try {
            // Pascal.g:276:2: ( NUMBER | {...}? => ID | '(' intExpression ')' | READ '()' )
            int alt16=4;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==NUMBER) ) {
                alt16=1;
            }
            else if ( (LA16_0==ID) && ((intVars.containsKey(input.LT(1).getText())))) {
                alt16=2;
            }
            else if ( (LA16_0==17) ) {
                alt16=3;
            }
            else if ( (LA16_0==READ) ) {
                alt16=4;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // Pascal.g:276:4: NUMBER
                    {
                    NUMBER4=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_intValue667); 

                    		code += "ldc " + Integer.parseInt((NUMBER4!=null?NUMBER4.getText():null)) + "\n";	
                    		recordPush();
                    	

                    }
                    break;
                case 2 :
                    // Pascal.g:281:4: {...}? => ID
                    {
                    if ( !((intVars.containsKey(input.LT(1).getText()))) ) {
                        throw new FailedPredicateException(input, "intValue", "intVars.containsKey(input.LT(1).getText())");
                    }
                    ID5=(Token)match(input,ID,FOLLOW_ID_in_intValue678); 

                              	code += "iload " + intVars.get((ID5!=null?ID5.getText():null)) + "\n";
                    		recordPush();
                          	

                    }
                    break;
                case 3 :
                    // Pascal.g:286:8: '(' intExpression ')'
                    {
                    match(input,17,FOLLOW_17_in_intValue696); 
                    pushFollow(FOLLOW_intExpression_in_intValue698);
                    intExpression();

                    state._fsp--;

                    match(input,18,FOLLOW_18_in_intValue700); 

                    }
                    break;
                case 4 :
                    // Pascal.g:287:4: READ '()'
                    {
                    match(input,READ,FOLLOW_READ_in_intValue705); 
                    match(input,42,FOLLOW_42_in_intValue707); 

                    		code += "aload " + bufferedReaderIdentifier + "\n";
                              	recordPush();
                              	code += "invokevirtual java/io/BufferedReader/readLine()Ljava/lang/String;\n"; 
                    		code += "invokestatic java/lang/Integer/parseInt(Ljava/lang/String;)I\n";	
                    	

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "intValue"

    // Delegated rules


 

    public static final BitSet FOLLOW_12_in_program27 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_program29 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_program31 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_program35 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_variableDeclaration_in_program38 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_15_in_program45 = new BitSet(new long[]{0x0000000000490070L});
    public static final BitSet FOLLOW_statement_in_program49 = new BitSet(new long[]{0x0000000000490070L});
    public static final BitSet FOLLOW_16_in_program54 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_writeOperation_in_statement67 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statement68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableAssignment_in_statement73 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_statement74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifOperation_in_statement79 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileOperation_in_statement84 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITE_in_writeOperation94 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_writeOperation96 = new BitSet(new long[]{0x0000000000020610L});
    public static final BitSet FOLLOW_intExpression_in_writeOperation97 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_writeOperation99 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITELN_in_writeOperation107 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_writeOperation109 = new BitSet(new long[]{0x0000000000020610L});
    public static final BitSet FOLLOW_intExpression_in_writeOperation110 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_writeOperation112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_whileOperation131 = new BitSet(new long[]{0x0000000400020790L});
    public static final BitSet FOLLOW_logicExpression_in_whileOperation136 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_whileOperation140 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_whileOperation142 = new BitSet(new long[]{0x0000000000680070L});
    public static final BitSet FOLLOW_statement_in_whileOperation148 = new BitSet(new long[]{0x0000000000680070L});
    public static final BitSet FOLLOW_21_in_whileOperation155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ifOperation172 = new BitSet(new long[]{0x0000000400020790L});
    public static final BitSet FOLLOW_logicExpression_in_ifOperation176 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ifOperation179 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ifOperation181 = new BitSet(new long[]{0x0000000001680070L});
    public static final BitSet FOLLOW_statement_in_ifOperation187 = new BitSet(new long[]{0x0000000001680070L});
    public static final BitSet FOLLOW_21_in_ifOperation200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ifOperation207 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ifOperation209 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ifOperation211 = new BitSet(new long[]{0x0000000000680070L});
    public static final BitSet FOLLOW_statement_in_ifOperation217 = new BitSet(new long[]{0x0000000000680070L});
    public static final BitSet FOLLOW_21_in_ifOperation221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicOrExpression_in_logicExpression240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicAndExpression_in_logicOrExpression257 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_logicOrExpression269 = new BitSet(new long[]{0x0000000400020790L});
    public static final BitSet FOLLOW_logicAndExpression_in_logicOrExpression275 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_logicCompareExpression_in_logicAndExpression302 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_logicAndExpression314 = new BitSet(new long[]{0x0000000400020790L});
    public static final BitSet FOLLOW_logicCompareExpression_in_logicAndExpression319 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_intExpression_in_logicCompareExpression336 = new BitSet(new long[]{0x00000003F0000000L});
    public static final BitSet FOLLOW_28_in_logicCompareExpression342 = new BitSet(new long[]{0x0000000000020610L});
    public static final BitSet FOLLOW_intExpression_in_logicCompareExpression344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_logicCompareExpression351 = new BitSet(new long[]{0x0000000000020610L});
    public static final BitSet FOLLOW_intExpression_in_logicCompareExpression353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_logicCompareExpression359 = new BitSet(new long[]{0x0000000000020610L});
    public static final BitSet FOLLOW_intExpression_in_logicCompareExpression361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_logicCompareExpression367 = new BitSet(new long[]{0x0000000000020610L});
    public static final BitSet FOLLOW_intExpression_in_logicCompareExpression369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_logicCompareExpression375 = new BitSet(new long[]{0x0000000000020610L});
    public static final BitSet FOLLOW_intExpression_in_logicCompareExpression377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_logicCompareExpression383 = new BitSet(new long[]{0x0000000000020610L});
    public static final BitSet FOLLOW_intExpression_in_logicCompareExpression385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_logicCompareExpression396 = new BitSet(new long[]{0x0000000400020790L});
    public static final BitSet FOLLOW_logicExpression_in_logicCompareExpression397 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_logicCompareExpression400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_logicCompareExpression409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_logicCompareExpression416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_variableDeclaration429 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_variableDeclaration431 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_variableDeclaration433 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_variableDeclaration452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_variableAssignment469 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_variableAssignment471 = new BitSet(new long[]{0x0000000000020610L});
    public static final BitSet FOLLOW_intExpression_in_variableAssignment473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_intMultExpression_in_intExpression501 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_38_in_intExpression511 = new BitSet(new long[]{0x0000000000020610L});
    public static final BitSet FOLLOW_intMultExpression_in_intExpression513 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_39_in_intExpression538 = new BitSet(new long[]{0x0000000000020610L});
    public static final BitSet FOLLOW_intMultExpression_in_intExpression540 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_intValue_in_intMultExpression577 = new BitSet(new long[]{0x0000030000000002L});
    public static final BitSet FOLLOW_40_in_intMultExpression588 = new BitSet(new long[]{0x0000000000020610L});
    public static final BitSet FOLLOW_intValue_in_intMultExpression590 = new BitSet(new long[]{0x0000030000000002L});
    public static final BitSet FOLLOW_41_in_intMultExpression614 = new BitSet(new long[]{0x0000000000020610L});
    public static final BitSet FOLLOW_intValue_in_intMultExpression618 = new BitSet(new long[]{0x0000030000000002L});
    public static final BitSet FOLLOW_NUMBER_in_intValue667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_intValue678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_intValue696 = new BitSet(new long[]{0x0000000000020610L});
    public static final BitSet FOLLOW_intExpression_in_intValue698 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_intValue700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READ_in_intValue705 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_intValue707 = new BitSet(new long[]{0x0000000000000002L});

}