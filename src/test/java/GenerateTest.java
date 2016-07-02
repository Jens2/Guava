import elaboration.CheckerResult;
import grammar.GuavaLexer;
import grammar.GuavaParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Jens on 1-7-2016.
 *
 */
public class GenerateTest {
    private final static String BASE_DIR = "src/test/java/generator/";
    private final static String EXTENSION = ".guava";
    private Guava guava;

    private void refresh() {
        guava = new Guava();
    }

    @Test
    public void test() {
        refresh();
        test("bank");
        refresh();
        test("fib28");
    }

    private void test(String filename) {
        ParseTree node = parse(filename);
        CheckerResult result = guava.check(node);
        List<String> instructions = guava.compile(node, result);
        if (result.isConc()) {
            guava.writeToFile(instructions, filename, result.getVarMap(), result.getGlobalVarMap(), 4);
        } else {
            guava.writeToFile(instructions, filename, result.getVarMap(), result.getGlobalVarMap(), 1);
        }
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
}
