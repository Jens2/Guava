import grammar.GuavaLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jens on 14-6-2016.
 *
 */
public class LexerTest {

    /** Test the parsing phase of the compiler. */
    @Test
    public void test() {
        // The corresponding expected numbers(types) can be found in "GuavaLexer.tokens"
        int[] test1 = {28,39,30,32,34};
        test("for 5 int char sweet", test1);
        // Whitespaces should be skipped
        int[] test2 = {1,2,3,4,5,6,7,8,9,10};
        test(".,;/*+-^=~            \n\n", test2);
        // Comments should not produce any tokens
        int[] test3 = {};
        test(">> blablablabla\n >~hoihoihoi\n\n\n\n\n~<", test3);
        // Testing multiple characters
        int[] test4 = {24,22,23,21,20,15,16,17,18,19,11,13,14,12};
        test("])[   (} <=> >=~={ |==<&", test4);
        // Testing multiple keywords, note that without whitespaces, they will be seen as variables
        int[] test5 = {33,41,37,35,36,30,25,28,31,27,26,32,29,34};
        test("pulp pulpp join sour branch int epicarp for double else if char while sweet", test5);
        // Testing the more complicated lexer rules
        int[] test6 = {38, 39, 42};
        test("1.5 28 \"string\"", test6);
    }

    public void test(String text, int[] tokens) {
        CharStream stream = new ANTLRInputStream(text);
        Lexer lexer = new GuavaLexer(stream);
        int i = 0;
        for (Token t : lexer.getAllTokens()) {
            if (i < tokens.length) {
                Assert.assertEquals(t.getType(), tokens[i]);
                i++;
            } else {
                // If the token list is any longer than the expected list, the test failed
                Assert.fail();
            }
        }
    }
}
