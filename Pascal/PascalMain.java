import org.antlr.runtime.*;
import java.io.*;

public class PascalMain {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Expected: the source file; the target file");
            System.exit(1);
        }
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(args[0]));
        PascalLexer lexer = new PascalLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PascalParser parser = new PascalParser(tokens);
        String r = parser.program();

        PrintWriter out = new PrintWriter(args[1]);
        out.println(r);
        out.close();
    }
}
