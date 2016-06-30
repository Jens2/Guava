import elaboration.*;
import grammar.GuavaLexer;
import grammar.GuavaParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Dion on 21-6-2016.
 *
 */
public class Guava {

    private GuavaChecker checker;
    private GuavaGenerator generator;
    private String[] registers = {"regA", "regB", "regC", "regD", "regE", "regF"
                                , "regG", "regH", "regI", "regJ", "regK", "regL"
                                , "regM", "regN", "regO", "regP", "regQ", "regR"
                                , "regS", "regT", "regU", "regV", "regW"};

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
            if (result.isConc()) {
                guava.writeToFile(instructions, args[0], result.getVarMap(), result.getGlobalVarMap(), 4);
            } else {
                guava.writeToFile(instructions, args[0], result.getVarMap(), result.getGlobalVarMap(), 1);
            }
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
        this.generator = new GuavaGenerator(tree, result, registers);
        return this.generator.getInstructions();
    }

    public String capitalize(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }


    public void writeToFile(List<String> instructions, String filename, Map<Integer, String> varMap, Map<Integer, String> globalVarMap, int processors) {
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

            if (globalVarMap.size() > 0) {
                writer.println("-- Global variables");
                for (int i : globalVarMap.keySet()) {
                    writer.println(globalVarMap.get(i) + outline(globalVarMap.get(i), globalVarMap) + " = " + i);
                }
            }

            if (varMap.size() > 0) {
                writer.println("\n-- Local variables");
                for (int i : varMap.keySet()) {
                    writer.println(varMap.get(i) + outline(varMap.get(i), varMap) + " = " + i);
                }
            }

            if (instructions.size() >= 1) {
                writer.println("\nprogram :: [Instruction]");
                writer.println("program = [ " + instructions.get(0));
            }
            for (int i = 1; i < instructions.size(); i++) {
                if (i == instructions.size() - 1) {
                    writer.println("          , " + instructions.get(i) + " ]\n");
                } else {
                    writer.println("          , " + instructions.get(i));
                }
            }

            List<List<String>> concInstr = this.generator.getConcurrentInstructions();


            for (int i = 0; i < processors -1; i++) {
                List<String> instr = concInstr.get(i);
                writer.println("\nprogram" + i + " :: [Instruction]");
                writer.println("program" + i + " = [ " + instr.get(0));
                for (int j = 1; j < instr.size(); j++) {
                    if (j == instr.size() - 1) {
                        writer.println("           , " + instr.get(j) + " ]\n");
                    } else {
                        writer.println("           , " + instr.get(j));
                    }
                }
            }

            String programs = "[program, ";
            for (int i = 0; i < processors-2; i++) {
                programs += "program" + i + ", ";
            }
            programs += "program2]";
            writer.println("testProgram = sysTest " + programs);
            writer.flush();
            writer.close();
        }
    }

    public String maxOutline(Map<Integer, String> vars) {
        String longest = "";

        for (String var : vars.values()) {
            if (var.length() > longest.length()) {
                longest = var;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longest.toCharArray().length; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }

    public String outline(String var, Map<Integer, String> varMap) {
        String maxOutline = maxOutline(varMap);
        return maxOutline.substring(0, maxOutline.length() - var.length());
    }

}
