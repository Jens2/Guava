import grammar.GuavaLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Jens on 14-6-2016.
 *
 */
public class LexerTest {

    /** Test the parsing phase of the compiler. */
    @Test
    public void test() {
        test("for 5 int char sweet", 5);
        // Whitespaces should be skipped
        test(".,;/*+-^=~            \n\n", 10);
        // Comments should not produce any tokens
        test(">> blablablabla\n >~hoihoihoi\n\n\n\n\n~<", 0);
        // Testing multiple characters
        test("])[   (} <=> >=~={ |==<&", 14);
        // Testing multiple keywords, note that without whitespaces, they will be seen as variables
        test("pulp pulpp join sour branch int epicarp for double else if char while sweet", 14);
        // Testing the more complicated lexer rules
        test("1 xasdf ;", 3);
    }

    private void test(String text, int noOfTokens) {
        CharStream stream = new ANTLRInputStream(text);
        Lexer lexer = new GuavaLexer(stream);
        Assert.assertEquals(noOfTokens, lexer.getAllTokens().size());
        for (Token t : lexer.getAllTokens()) {
        }
    }
}
