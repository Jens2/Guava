import org.junit.Test;

/**
 * Created by Jens on 1-7-2016.
 *
 */
public class CompleteTest {
    private LexerTest lt = new LexerTest();
    private CheckerTest ct = new CheckerTest();
    private ParserTest pt = new ParserTest();
    private GenerateTest gt = new GenerateTest();

    public static void main(String[] args) {
        CompleteTest test = new CompleteTest();
        test.test();
    }


    @Test
    public void test() {
        lt.test();
        ct.test();
        pt.test();
        gt.test();
    }
}
