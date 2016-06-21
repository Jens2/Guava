package elaboration;

import elaboration.structure.CheckerResult;
import elaboration.structure.GuavaChecker;
import elaboration.structure.GuavaException;
import grammar.GuavaBaseVisitor;
import grammar.GuavaLexer;
import grammar.GuavaParser;
import instructions.MemAddr;
import instructions.SPRIL;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static instructions.SPRIL.*;

/**
 * Created by Jens on 14-6-2016.
 *
 */
public class GuavaGenerator extends GuavaBaseVisitor<String> {

    private CheckerResult result;
    private List<String> operations;
    private ParseTreeProperty<Integer> registers;
    private Map<String, Integer> varRegisters;
    private ParseTreeProperty<ParserRuleContext> next;
    private int regCount;
    private static ParserRuleContext END;
    private static final String CONST = "CONST";
    private static final String DIR = "DIR";
    private static final String IND = "IND";


    public static void main(String[] args) {
        File file = new File("output.hs");
        File input = new File("src/main/java/elaboration/structure/test.guava");
        CharStream chars = null;
        try {
            chars = new ANTLRInputStream(new FileReader(input));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(chars);

        Lexer lexer = new GuavaLexer(chars);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        System.out.println(tokenStream.getText());
        GuavaParser parser = new GuavaParser(tokenStream);
        System.out.println(parser.program().getText());

        GuavaChecker checker = new GuavaChecker();
        CheckerResult result = null;
        try {
            System.out.println("************");
            result = checker.check(parser.program());
            System.out.println("---------------");
        } catch (GuavaException e) {
            e.printStackTrace();
        }
        System.out.println(checker.hasErrors());

        GuavaGenerator g = new GuavaGenerator(parser.program(), result);

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> operations = g.getOperations();
        if (writer != null) {
            if (operations.size() >= 1) {
                writer.println("program = [ " + operations.get(0));
            }
            for (int i = 1; i < operations.size(); i++) {
                writer.println(", " + operations.get(i));
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
    }

    public GuavaGenerator(ParseTree tree, CheckerResult result) {
        this.result = result;
        operations = new ArrayList<>();
        registers = new ParseTreeProperty<>();
        varRegisters = new HashMap<>();
        next = new ParseTreeProperty<>();
        regCount = 1;
        tree.accept(this);
    }

    /** Get the list of all operations.*/
    public List<String> getOperations() {
        return this.operations;
    }

    /** Start of the program. */
    @Override
    public String visitProgram(GuavaParser.ProgramContext ctx) {
        END = ctx;
        visitChildren(ctx);
        addOp(new SPRIL.ENDPROG().toString());
        return null;
    }

    /** Body of the program. */
    @Override
    public String visitBody(GuavaParser.BodyContext ctx) {
        for (int i = 0; i < ctx.stat().size() - 1; i++) {
            setNext(ctx.stat(i), result.getEntry(ctx.stat(i+1)));
        }
        setNext(ctx.stat(ctx.stat().size() - 1), END);
        visitChildren(ctx);
        return null;
    }

    /** All stats of the program. */
    @Override
    public String visitVarDeclStat(GuavaParser.VarDeclStatContext ctx) {
        String var = ctx.ID().getText();
        if (ctx.expr() != null) {
            String s = visit(ctx.expr());
            if (s.equals(CONST)) {
                int i = Integer.parseInt(ctx.expr().getText());
                addOp(new SPRIL.LOAD(MemAddr.ImmValue, i, reg(ctx.expr())).toString());
            } else if (s.equals(DIR)) {
                addOp(new SPRIL.LOAD(MemAddr.DirAddr, reg(ctx.expr()), reg(ctx.expr())).toString());
            } else if (s.equals(IND)) {
                addOp(new SPRIL.LOAD(MemAddr.IndAddr, reg(ctx.expr()), reg(ctx.expr())).toString());
            }
            setRegExplicit(var, reg(ctx.expr()));
        }
        return null;
    }

    @Override
    public String  visitArrayDeclStat(GuavaParser.ArrayDeclStatContext ctx) {
        return null;
    }

    @Override
    public String visitAssignStat(GuavaParser.AssignStatContext ctx) {
        return null;
    }

    @Override
    public String visitIfStat(GuavaParser.IfStatContext ctx) {
        return null;
    }

    @Override
    public String visitBlockStat(GuavaParser.BlockStatContext ctx) {
        for (int i = 0; i < ctx.stat().size()-1; i++) {
            if (i == ctx.stat().size() -1) {
                setNext(ctx.stat(i), getNext(ctx));
            } else {
                setNext(ctx.stat(i), result.getEntry(ctx.stat(i + 1)));
            }
        }
        return null;
    }

    @Override
    public String visitWhileStat(GuavaParser.WhileStatContext ctx) {
        return null;
    }

    @Override
    public String visitForStat(GuavaParser.ForStatContext ctx) {
        return null;
    }

    @Override
    public String visitPrintStat(GuavaParser.PrintStatContext ctx) {
        return null;
    }

    @Override
    public String visitForkStat(GuavaParser.ForkStatContext ctx) {
        for (int i = 0; i < ctx.stat().size()-1; i++) {
            if (i == ctx.stat().size() -1) {
                setNext(ctx.stat(i), getNext(ctx));
            } else {
                setNext(ctx.stat(i), result.getEntry(ctx.stat(i + 1)));
            }
        }
        return null;
    }

    @Override
    public String visitJoinStat(GuavaParser.JoinStatContext ctx) {
        return null;
    }

    /** All expressions. */
    @Override
    public String visitPrfExpr(GuavaParser.PrfExprContext ctx) {
        return null;
    }

    @Override
    public String visitMultExpr(GuavaParser.MultExprContext ctx) {
        return null;
    }

    @Override
    public String visitPlusExpr(GuavaParser.PlusExprContext ctx) {
        return null;
    }

    @Override
    public String visitBoolExpr(GuavaParser.BoolExprContext ctx) {
        return null;
    }

    @Override
    public String visitCompExpr(GuavaParser.CompExprContext ctx) {
        return null;
    }

    @Override
    public String visitParExpr(GuavaParser.ParExprContext ctx) {
        return null;
    }

    @Override
    public String visitArrayExpr(GuavaParser.ArrayExprContext ctx) {
        return null;
    }

    @Override
    public String visitConstExpr(GuavaParser.ConstExprContext ctx) {
        return CONST;
    }

    @Override
    public String visitIdExpr(GuavaParser.IdExprContext ctx) {
        return null;
    }

    /** Assignments in a for loop.*/
    @Override
    public String visitForDecl(GuavaParser.ForDeclContext ctx) {
        return null;
    }

    @Override
    public String visitForExisting(GuavaParser.ForExistingContext ctx) {
        return null;
    }

    /** All different operations. */
    @Override
    public String visitPrfOp(GuavaParser.PrfOpContext ctx) {
        return null;
    }

    @Override
    public String visitMultOp(GuavaParser.MultOpContext ctx) {
        return null;
    }

    @Override
    public String visitPlusOp(GuavaParser.PlusOpContext ctx) {
        return null;
    }

    @Override
    public String visitBoolOp(GuavaParser.BoolOpContext ctx) {
        return null;
    }

    @Override
    public String visitCompOp(GuavaParser.CompOpContext ctx) {
        return null;
    }

    /** All types. */
    @Override
    public String visitIntType(GuavaParser.IntTypeContext ctx) {
        return null;
    }

    @Override
    public String visitBoolType(GuavaParser.BoolTypeContext ctx) {
        return null;
    }

    @Override
    public String visitDoubleType(GuavaParser.DoubleTypeContext ctx) {
        return null;
    }

    @Override
    public String visitCharType(GuavaParser.CharTypeContext ctx) {
        return null;
    }

    @Override
    public String visitStringType(GuavaParser.StringTypeContext ctx) {
        return null;
    }



    /** Getters and setters. */
    private void addOp(String op) {
        this.operations.add(op);
    }

    private void setRegExplicit(String var, int reg) {
        this.varRegisters.put(var, reg);
    }

    private Integer reg(String var) {
        if (this.varRegisters.containsKey(var)) {
            return this.varRegisters.get(var);
        } else {
            this.varRegisters.put(var, regCount);
            regCount++;
            return this.varRegisters.get(var);
        }
    }

    private Integer reg(ParseTree tree) {
        if (this.registers.get(tree) != null) {
            return this.registers.get(tree);
        } else {
            this.registers.put(tree, regCount);
            regCount++;
            return this.registers.get(tree);
        }
    }

    private void setNext(ParseTree tree, ParserRuleContext node) {
        this.next.put(tree, node);
    }

    private ParserRuleContext getNext(ParseTree tree) {
        return this.next.get(tree);
    }
}
