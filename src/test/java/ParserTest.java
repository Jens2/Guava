import grammar.GuavaLexer;
import grammar.GuavaParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.fail;

/**
 * Created by Jens on 15-6-2016.
 *
 */
public class ParserTest {

    private static final String BASE_DIR = "src/test/java/parser/";
    private static final String EXTENSION = ".guava";

    @Test
    public void test() {
        fails("fail_main");
        fails("fail_main2");
        fails("fail_assign");
        fails("fail_assign2");
        fails("fail_assign3");
        fails("fail_assign4");
        fails("fail_comments");
        fails("fail_expression");
        fails("fail_forloop");
        fails("fail_forloop2");
        fails("fail_branch");
        fails("fail_while");

        succeeds("mixedstatements");
        succeeds("mixedstatements2");
        succeeds("forloopincr");
        succeeds("forloopdecr");
        succeeds("forloopbranch");
        succeeds("fib");
        succeeds("pulpfiction");
        succeeds("comments");
        succeeds("pulps");
        succeeds("basicdeclarations");
    }

    /** This method checks whether the given file fails like it should. */
    private void fails(String filename) {
        if (!getError(BASE_DIR + filename + EXTENSION)) {
            fail("Parsing " + filename + " should have failed, but didn't.");
        }
    }

    private void succeeds(String filename) {
        if (getError(BASE_DIR + filename + EXTENSION)) {
            fail("Parsing " + filename + " should have worked, but failed.");
        }
    }

    /** This method returns whether there was an error during parsing or not. */
    private boolean getError(String fileName) {
        File file = new File(fileName);
        Reader r = null;
        try {
            r = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CharStream charStream = null;
        try {
            charStream = new ANTLRInputStream(r);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Lexer lexer = new GuavaLexer(charStream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        GuavaParser parser = new GuavaParser(tokenStream);
        SimpleErrorListener listener = new SimpleErrorListener();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, parser.program());
        return listener.parseError();
    }
}
