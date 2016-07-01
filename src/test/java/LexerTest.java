import grammar.GuavaLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jens on 14-6-2016.
 *
 */
public class LexerTest {

    /** Test the parsing phase of the compiler. */
    @Test
    public void test() {
        int[] result = {39,31,28,29,32};
        test("for 5 int char sweet", 5, result);
        // Whitespaces should be skipped
        result = new int[] {1,2,3,6,7,8,9,10,12,13};
        test(".,;/*+-^=~            \n\n", 10, result);
        // Comments should not produce any tokens
        result = new int[] {};
        test(">> blablablabla\n >~hoihoihoi\n\n\n\n\n~<", 0, result);
        // Testing multiple characters
        result = new int[] {27,25,26,24,23,18,19,20,21,22,14,16,17,15};
        test("])[   (} <=> >=~={ |==<&", 14, result);
        // Testing multiple keywords, note that without whitespaces, they will all be seen as variables
        result = new int[] {30,46,32,41,28,36,39,38,37,29,40,32};
        test("pulp pulpp sour branch int epicarp for else if char while sweet", 12, result);
        result = new int[] {5,13,16,43,44,46};
        test("\"~ == universal lock ulock", 6, result);
    }

    private void test(String text, int noOfTokens, int[] result) {
        CharStream stream = new ANTLRInputStream(text);
        Lexer lexer = new GuavaLexer(stream);
        List<? extends Token> tokens = lexer.getAllTokens();
        Assert.assertEquals(noOfTokens, tokens.size());
        Assert.assertEquals(result.length, noOfTokens);
        int i = 0;
        for (Token t : tokens) {
            Assert.assertEquals(result[i], t.getType());
            i++;
        }
    }
}
