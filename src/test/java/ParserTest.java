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

    private static final String PATH = "src//test//java//testfiles//";

    @Test
    public void test() {
        fails(PATH + "fail0.guava");
        fails(PATH + "fail1.guava");
        succeeds(PATH + "succ0.guava");

    }

    /** This method checks whether the given file fails like it should. */
    private void fails(String fileName) {
        if (!getError(fileName)) {
            fail("Parsing " + fileName + " should have failed, but didn't.");
        }
    }

    private void succeeds(String fileName) {
        if (getError(fileName)) {
            fail("Parsing " + fileName + " should have worked, but failed.");
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
        SimpleListener listener = new SimpleListener();
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, parser.program());
        return listener.parseError();
    }
}
