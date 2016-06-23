import elaboration.GuavaGenerator;
import elaboration.CheckerResult;
import elaboration.GuavaChecker;
import elaboration.GuavaException;
import grammar.GuavaLexer;
import grammar.GuavaParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.List;

/**
 * Created by Dion on 21-6-2016.
 */
public class Guava {

    private GuavaChecker checker;
    private GuavaGenerator generator;

    public Guava() {
        this.checker = new GuavaChecker();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: [filename].guava");
            return;
        }
        Guava guava = new Guava();
        ParseTree tree = guava.parse(args[0]);

        System.out.println(">> Typechecking " + args[0]);
        CheckerResult result = guava.check(tree);
        if (result == null) {
            System.err.println(">> Typechecking of " + args[0] + " failed.");
        } else {
            System.out.println(">> Typechecking of " + args[0] + " is done\n");

            System.out.println(">> Generating Sprockell code for " + args[0]);
            List<String> instructions = guava.compile(tree, result);
            System.out.println(">> Generating Sprockell code for " + args[0] + " is done\n");

            guava.writeToFile(instructions, args[0]);
            System.out.println(">> Output is written to " + args[0] + ".hs");
        }
    }

    public ParseTree parse(String filename) {
        File file = new File(filename + ".guava");
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

    public CheckerResult check(ParseTree tree) {
        CheckerResult checkerResult = null;

        try {
            checkerResult = this.checker.check(tree);
        } catch (GuavaException e) {
            e.print();
        }

        return checkerResult;
    }

    public List<String> compile(ParseTree tree, CheckerResult result) {
        this.generator = new GuavaGenerator(tree, result);
        return this.generator.getOperations();
    }

    public String capitalize(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public void writeToFile(List<String> instructions, String filename) {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter("src/haskell/" + filename + ".hs");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (writer != null) {
            writer.println("module " + capitalize(filename) + " where\n");
            writer.println("import HardwareTypes");
            writer.println("import BasicFunctions");
            writer.println("import Sprockell");
            writer.println("import System");
            writer.println("import Simulation\n");

            if (instructions.size() >= 1) {
                writer.println("program :: [Instruction]");
                writer.println("program = [ " + instructions.get(0));
            }
            for (int i = 1; i < instructions.size(); i++) {
                if (i == instructions.size() - 1) {
                    writer.println("          , " + instructions.get(i) + " ]\n");
                } else {
                    writer.println("          , " + instructions.get(i));
                }
            }
            writer.println("testProgram = sysTest [program]");
            writer.flush();
            writer.close();
        }
    }

}
