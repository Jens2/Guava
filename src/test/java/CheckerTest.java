import elaboration.GuavaChecker;
import elaboration.GuavaException;
import elaboration.CheckerResult;
import elaboration.Type;
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
 *
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
    public void test() {
        setUp();
        try {
            testBasicDeclarations();
            testFailBasicDeclarations();
            testWhileLoops();
            testFailWhileLoops();
            testForLoops();
            testFailForLoops();
            testFork();
            testFailFork();
            testFib();
            testFailFib();
        } catch (GuavaException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testArrays() throws GuavaException {
        checkFail("fail_arraylength");
        checkFail("fail_arraytype");
    }

    @Test
    public void testBasicDeclarations() throws GuavaException {
        ParseTree tree = parse("basicdeclarations");
        CheckerResult checkerResult = check(tree);

        ParseTree body      = tree.getChild(1);
        ParseTree integer   = body.getChild(1);
        ParseTree character = body.getChild(2);
        ParseTree array     = body.getChild(3);
        ParseTree arrElem   = body.getChild(4);
        ParseTree modulo    = body.getChild(5);

        assertEquals(Type.INT, checkerResult.getType(integer.getChild(1)));
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
            for (String s : e.getMessages()) {
                System.out.println(s);
            }
            System.out.println("**********************");
            System.out.println("Correctly thrown errors");
            // Expected exception was thrown
        }

    }
}
