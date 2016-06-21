import elaboration.structure.GuavaChecker;
import elaboration.structure.GuavaException;
import elaboration.structure.CheckerResult;
import elaboration.structure.Type;
import grammar.GuavaLexer;
import grammar.GuavaParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Dion on 20-6-2016.
 */
public class CheckerTest {
    private final static String BASE_DIR = "src/test/java/checker/";
    private final static String EXTENSION = ".guava";
    private GuavaChecker checker;

    @Before
    public void setUp() {
        this.checker = new GuavaChecker();
    }

    @Test
    public void testBasicDeclarations() throws GuavaException {
        ParseTree tree = parse("basicdeclarations");
        CheckerResult checkerResult = check(tree);

        ParseTree body      = tree.getChild(1);
        ParseTree integer   = body.getChild(1);
        ParseTree decimal   = body.getChild(2);
        ParseTree str       = body.getChild(3);
        ParseTree character = body.getChild(4);
        ParseTree array     = body.getChild(5);
        ParseTree arrElem   = body.getChild(6);
        ParseTree modulo    = body.getChild(7);

        assertEquals(Type.INT, checkerResult.getType(integer.getChild(1)));
        assertEquals(Type.DOUBLE, checkerResult.getType(decimal.getChild(1)));
        assertEquals(Type.STR, checkerResult.getType(str.getChild(1)));
        assertEquals(Type.CHAR, checkerResult.getType(character.getChild(1)));
        assertEquals(new Type.Array(Type.INT), checkerResult.getType(array.getChild(4)));
        assertEquals(Type.INT, checkerResult.getType(arrElem.getChild(1)));
        assertEquals(Type.INT, checkerResult.getType(modulo.getChild(1)));
    }

    @Test
    public void testFailBasicDeclarations() throws GuavaException {
        checkFail("fail_basicdeclarations");
    }

    @Test
    public void testWhileLoops() throws GuavaException {
        check(parse("whileloops"));
    }

    @Test
    public void testFailWhileLoops() throws GuavaException {
        checkFail("fail_whileloops");
    }

    @Test
    public void testForLoops() throws GuavaException {
        check(parse("forloops"));
    }

    @Test
    public void testFailForLoops() throws GuavaException {
        checkFail("fail_forloops");
    }

    @Test
    public void testFork() throws GuavaException {
        check(parse("fork"));
    }

    @Test
    public void testFailFork() throws GuavaException {
        checkFail("fail_fork");
    }

    @Test
    public void testFib() throws GuavaException {
        check(parse("fib"));
    }

    @Test
    public void testFailFib() throws GuavaException {
        checkFail("fail_fib");
    }


    private ParseTree parse(String filename) {
        File file = new File(BASE_DIR + filename + EXTENSION);
        CharStream chars = null;

        try {
            chars = new ANTLRInputStream(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Lexer lexer = new GuavaLexer(chars);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        GuavaParser parser = new GuavaParser(tokenStream);
        return parser.program();
    }

    private CheckerResult check(ParseTree tree) throws GuavaException {
        CheckerResult checkerResult;
        checkerResult = this.checker.check(tree);
        return checkerResult;
    }

    private void checkFail(String filename) {
        try {
            check(parse(filename));
            fail(filename + " shouldn't check but did");
        } catch (GuavaException e) {
            // Expected exception was thrown
        }

    }
}
