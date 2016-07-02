import org.junit.Test;

/**
 * Created by Jens on 1-7-2016.
 *
 */
public class CompleteTest {
    private LexerTest lt = new LexerTest();
    private CheckerTest ct = new CheckerTest();
    private ParserTest pt = new ParserTest();


    @Test
    public void test() {
        lt.test();
        ct.test();
        pt.test();
    }
}
