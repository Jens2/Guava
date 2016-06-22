package elaboration;

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

/**
 * Created by Jens on 14-6-2016.
 *
 */
public class GuavaGenerator extends GuavaBaseVisitor<String> {

    private CheckerResult result;
    private List<String> operations;

    private ParseTreeProperty<String> registers;
    private Map<String, String> varRegisters;
    private ParseTreeProperty<ParserRuleContext> next;
    private ParseTreeProperty<Integer> codeLines;
    private int regCount;

    private static final String[] availableRegs = {"RegA", "RegB", "RegC", "RegD", "RegE", "RegF"
                                                    , "RegG", "RegH", "RegI", "RegJ", "RegK", "RegL"
                                                    , "RegM", "RegN", "RegO", "RegP", "RegQ", "RegR"
                                                    , "RegS", "RegT", "RegU", "RegV", "RegW", "RegX"};
    private static ParserRuleContext END;
    private static final String CONST = "CONST";
    private static final String DIR = "DIR";
    private static final String IND = "IND";
    private static final String SWEET = "sweet";
    private static final String SOUR = "sour";
    private static final int TRUE = 1;
    private static final int FALSE = 0;


    public static void main(String[] args) {
        File file = new File("output.hs");
        File input = new File("src/main/java/elaboration/structure/test.guava");
        CharStream chars = null;
        try {
            chars = new ANTLRInputStream(new FileReader(input));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Lexer lexer = new GuavaLexer(chars);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        GuavaParser parser = new GuavaParser(tokenStream);

        GuavaChecker checker = new GuavaChecker();
        CheckerResult result = null;
        ParseTree tree = parser.program();
        try {
            result = checker.check(tree);
        } catch (GuavaException e) {
            e.printStackTrace();
        }
        GuavaGenerator g = new GuavaGenerator(tree, result);

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
        codeLines = new ParseTreeProperty<>();
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
////////////// Check whether the expression is a constant
            if (s.equals(CONST)) {
                Type type = result.getType(ctx.expr());
                addConstOp(type, ctx, ctx.expr());
            } else if (s.equals(DIR)) {
                addOp(new SPRIL.LOAD(MemAddr.DirAddr, reg(ctx.expr()), reg(ctx)).toString());
            } else if (s.equals(IND)) {
                addOp(new SPRIL.LOAD(MemAddr.IndAddr, reg(ctx.expr()), reg(ctx)).toString());
            }
            setRegExplicit(var, reg(ctx.expr()));
        }
        return null;
    }

    @Override
    public String  visitArrayDeclStat(GuavaParser.ArrayDeclStatContext ctx) {
        //@TODO implement storage of arrays
        return null;
    }

    private void addConstOp(Type type, ParserRuleContext ctx, ParseTree tree) {
////////////////// Check the type and set the appropriate instructions
        if (type.equals(Type.INT)) {
            addOp(new SPRIL.LOAD(MemAddr.ImmValue, tree.getText(), reg(ctx)).toString());

        } else if (type.equals(Type.BOOL)) {
            String s;
            if (tree.getText().equals(SWEET)) {
                s = "1";
            } else if (tree.getText().equals(SOUR)){
                s = "0";
            } else {
                // This should not happen.
                s = "-1";
            }
            addOp(new SPRIL.LOAD(MemAddr.ImmValue, s, reg(ctx)).toString());

        } else if (type.equals(Type.CHAR)) {
            String ch = tree.getText().replaceAll("\'", "");
            char c = ch.charAt(0);
            int i = (int) c;
            addOp(new SPRIL.LOAD(MemAddr.ImmValue, "" + i, reg(ctx)).toString());

        } else if (type.equals(Type.DOUBLE)) {
            //@TODO implement storage of doubles
        } else if (type.equals(Type.STR)) {
            //@TODO implement storage of strings
        }

    }

    @Override
    public String visitAssignStat(GuavaParser.AssignStatContext ctx) {
        String var = ctx.ID().getText();
        String s = visit(ctx.expr());
        if (s.equals(CONST)) {
            Type type = result.getType(ctx.expr());
            addConstOp(type, ctx, ctx.expr());
        } else if (s.equals(DIR)) {
            addOp(new SPRIL.LOAD(MemAddr.DirAddr, reg(ctx.expr()), reg(var)).toString());
        } else if (s.equals(IND)) {
            addOp(new SPRIL.LOAD(MemAddr.IndAddr, reg(ctx.expr()), reg(var)).toString());
        }
        return null;
    }

    @Override
    public String visitIfStat(GuavaParser.IfStatContext ctx) {
        setNext(ctx.stat(0), getNext(ctx));

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
        return DIR;
    }

    @Override
    public String visitMultExpr(GuavaParser.MultExprContext ctx) {
        return DIR;
    }

    @Override
    public String visitPlusExpr(GuavaParser.PlusExprContext ctx) {
        return DIR;
    }

    @Override
    public String visitBoolExpr(GuavaParser.BoolExprContext ctx) {
        return DIR;
    }

    @Override
    public String visitCompExpr(GuavaParser.CompExprContext ctx) {
        return DIR;
    }

    @Override
    public String visitParExpr(GuavaParser.ParExprContext ctx) {
        return DIR;
    }

    @Override
    public String visitArrayExpr(GuavaParser.ArrayExprContext ctx) {
        return DIR;
    }

    @Override
    public String visitConstExpr(GuavaParser.ConstExprContext ctx) {
        return CONST;
    }

    @Override
    public String visitIdExpr(GuavaParser.IdExprContext ctx) {
        String var = ctx.ID().getText();
        setRegExplicit(ctx, reg(var));
        return DIR;
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

    private void setRegExplicit(String var, String reg) {
        this.varRegisters.put(var, reg);
    }

    private void setRegExplicit(ParseTree tree, String reg) {
        this.registers.put(tree, reg);
    }

    private String reg(String var) {
        if (this.varRegisters.containsKey(var)) {
            return this.varRegisters.get(var);
        } else {
            this.varRegisters.put(var, availableRegs[regCount]);
            regCount++;
            return this.varRegisters.get(var);
        }
    }

    private String reg(ParseTree tree) {
        if (this.registers.get(tree) != null) {
            return this.registers.get(tree);
        } else {
            this.registers.put(tree, availableRegs[regCount]);
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
