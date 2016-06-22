package elaboration;

import grammar.GuavaBaseVisitor;
import grammar.GuavaLexer;
import grammar.GuavaParser;
import instructions.MemAddr;
import instructions.Op;
import instructions.SPRIL;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.io.*;
import java.util.*;

/**
 * Created by Jens on 14-6-2016.
 *
 */
public class GuavaGenerator extends GuavaBaseVisitor<String> {

    private CheckerResult result;
    private List<String> operations;

    private ParseTreeProperty<String> registers;
    private Map<String, String> varRegisters;
    private List<String> emptyRegisters;
    private ParseTreeProperty<ParserRuleContext> next;
    private ParseTreeProperty<Integer> codeLines;

    private static final String[] availableRegs = {"RegA", "RegB", "RegC", "RegD", "RegE", "RegF"
                                                 , "RegG", "RegH", "RegI", "RegJ", "RegK", "RegL"
                                                 , "RegM", "RegN", "RegO", "RegP", "RegQ", "RegR"
                                                 , "RegS", "RegT", "RegU", "RegV", "RegW", "RegX"};
    private static ParserRuleContext END;


    private static final String CONST = "CONST";
    private static final String DIR = "DIR";
    private static final String IND = "IND";
    private static final String SWEET = "sweet";
    private static final String MINUS = "minus";
    private static final String SOUR = "sour";
    private static final String TRUE = "1";
    private static final String FALSE = "0";


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
        codeLines = new ParseTreeProperty<>();
        emptyRegisters = new ArrayList<>();
        Collections.addAll(emptyRegisters, availableRegs);
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
        int lines = 0;
        if (ctx.expr() != null) {
            visit(ctx.expr());
            lines += getCodeLines(ctx.expr());
            setRegExplicit(var, reg(ctx.expr()));
        }
        setCodeLines(ctx, lines);
        return null;
    }

    @Override
    public String visitArrayDeclStat(GuavaParser.ArrayDeclStatContext ctx) {
        //@TODO implement storage of arrays
        return null;
    }

    @Override
    public String visitAssignStat(GuavaParser.AssignStatContext ctx) {
        String var = ctx.ID().getText();
        visit(ctx.expr());
        int lines = /*getCodeLines(ctx.expr());*/ 0;
        addOp(new SPRIL.LOAD(MemAddr.DirAddr, reg(ctx.expr()), reg(var)).toString());
        setCodeLines(ctx, lines+1);
        return null;
    }

    @Override
    public String visitIfStat(GuavaParser.IfStatContext ctx) {

        return null;
    }

    @Override
    public String visitBlockStat(GuavaParser.BlockStatContext ctx) {
        for (int i = 0; i < ctx.stat().size() - 1; i++) {
            if (i == ctx.stat().size() - 1) {
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
        int lines = 0;
        visitChildren(ctx);
        for (int i = 0; i < ctx.stat().size(); i++) {
            lines += getCodeLines(ctx.stat(i));
        }
        setCodeLines(ctx, lines);
        return null;
    }

    @Override
    public String visitJoinStat(GuavaParser.JoinStatContext ctx) {
        return null;
    }

    /** All expressions. */
    @Override
    public String visitPrfExpr(GuavaParser.PrfExprContext ctx) {
        setNext(ctx.expr(), getNext(ctx));
        int lines = 0;
        visit(ctx.expr());

        lines += getCodeLines(ctx.expr());

        String reg = reg(ctx.expr());

        SPRIL.LOAD load;
        SPRIL.COMP neg;
        if (result.getType(ctx.expr()) == Type.BOOL) {
            load = new SPRIL.LOAD(MemAddr.ImmValue, String.valueOf(1), reg(ctx));
            neg = new SPRIL.COMP(Op.Xor, reg, reg(ctx), reg(ctx));
        } else {
            load = new SPRIL.LOAD(MemAddr.ImmValue, String.valueOf(-1), reg(ctx));
            neg = new SPRIL.COMP(Op.Mul, reg, reg(ctx), reg(ctx));
        }

        addOp(load.toString());
        addOp(neg.toString());
        setCodeLines(ctx, lines + 1);
        emptyReg(ctx.expr());
        return DIR;
    }

    @Override
    public String visitMultExpr(GuavaParser.MultExprContext ctx) {
        int lines = 0;
        visit(ctx.expr(0));
        visit(ctx.expr(1));

        lines += getCodeLines(ctx.expr(0));
        lines += getCodeLines(ctx.expr(1));

        String reg1 = reg(ctx.expr(0));
        String reg2 = reg(ctx.expr(1));
        SPRIL.COMP mult;

        switch (ctx.multOp().getText()) {
            case "*":
                mult = new SPRIL.COMP(Op.Mul, reg1, reg2, reg(ctx));
                break;
            case "/":
                mult = new SPRIL.COMP(Op.Div, reg1, reg2, reg(ctx));
                break;
            case "^":
                // TODO: implement power
                mult = new SPRIL.COMP(Op.Mul, reg1, reg2, reg(ctx));
                break;
            default:
                // This should never be reached
                mult = new SPRIL.COMP(Op.Mul, reg1, reg2, reg(ctx));
                break;

        }

        addOp(mult.toString());
        setCodeLines(ctx, lines + 1);
        emptyReg(ctx.expr(0));
        emptyReg(ctx.expr(1));
        return DIR;
    }

    @Override
    public String visitPlusExpr(GuavaParser.PlusExprContext ctx) {
        int lines = 0;
        visit(ctx.expr(0));
        visit(ctx.expr(1));

        lines += getCodeLines(ctx.expr(0));
        lines += getCodeLines(ctx.expr(1));

        String reg1 = reg(ctx.expr(0));
        String reg2 = reg(ctx.expr(1));
        SPRIL.COMP plus;

        switch (ctx.plusOp().getText()) {
            case "+":
                plus = new SPRIL.COMP(Op.Add, reg1, reg2, reg(ctx));
                break;
            case "-":
                plus = new SPRIL.COMP(Op.Sub, reg1, reg2, reg(ctx));
                break;
            default:
                // This should never be reached
                plus = new SPRIL.COMP(Op.Add, reg1, reg2, reg(ctx));
                break;
        }

        addOp(plus.toString());
        setCodeLines(ctx, lines + 1);
        emptyReg(ctx.expr(0));
        emptyReg(ctx.expr(1));
        return DIR;
    }

    @Override
    public String visitBoolExpr(GuavaParser.BoolExprContext ctx) {
        int lines = 0;
        visit(ctx.expr(0));
        visit(ctx.expr(1));

        lines += getCodeLines(ctx.expr(0));
        lines += getCodeLines(ctx.expr(1));

        String reg1 = reg(ctx.expr(0));
        String reg2 = reg(ctx.expr(1));
        SPRIL.COMP bool;

        switch (ctx.boolOp().getText()) {
            case "&":
                bool = new SPRIL.COMP(Op.And, reg1, reg2, reg(ctx));
                break;
            case "|":
                bool = new SPRIL.COMP(Op.Or, reg1, reg2, reg(ctx));
                break;
            default:
                // This should never be reached
                bool = new SPRIL.COMP(Op.And, reg1, reg2, reg(ctx));
                break;
        }

        addOp(bool.toString());
        setCodeLines(ctx, lines + 1);
        emptyReg(ctx.expr(0));
        emptyReg(ctx.expr(1));
        return DIR;
    }

    @Override
    public String visitCompExpr(GuavaParser.CompExprContext ctx) {
        int lines = 0;
        visit(ctx.expr(0));
        visit(ctx.expr(1));

        lines += getCodeLines(ctx.expr(0));
        lines += getCodeLines(ctx.expr(1));

        String reg1 = reg(ctx.expr(0));
        String reg2 = reg(ctx.expr(1));
        SPRIL.COMP comp;

        switch (ctx.compOp().getText()) {
            case ">":
                comp = new SPRIL.COMP(Op.Gt, reg1, reg2, reg(ctx));
                break;
            case ">=":
                comp = new SPRIL.COMP(Op.GtE, reg1, reg2, reg(ctx));
                break;
            case "<":
                comp = new SPRIL.COMP(Op.Lt, reg1, reg2, reg(ctx));
                break;
            case "<=":
                comp = new SPRIL.COMP(Op.LtE, reg1, reg2, reg(ctx));
                break;
            case "~=":
                comp = new SPRIL.COMP(Op.NEq, reg1, reg2, reg(ctx));
                break;
            case "==":
                comp = new SPRIL.COMP(Op.Equal, reg1, reg2, reg(ctx));
                break;
            default:
                // This should never be reached
                comp = new SPRIL.COMP(Op.Gt, reg1, reg2, reg(ctx));
                break;
        }

        addOp(comp.toString());
        setCodeLines(ctx, lines + 1);
        emptyReg(ctx.expr(0));
        emptyReg(ctx.expr(1));
        return DIR;
    }

    @Override
    public String visitParExpr(GuavaParser.ParExprContext ctx) {
        visit(ctx.expr());
        setCodeLines(ctx, getCodeLines(ctx.expr()));
        return DIR;
    }

    @Override
    public String visitArrayExpr(GuavaParser.ArrayExprContext ctx) {
        // TODO: Implement arrays
        return DIR;
    }

    @Override
    public String visitConstExpr(GuavaParser.ConstExprContext ctx) {
        SPRIL.LOAD load = null;
        int lines = 0;

        if (result.getType(ctx) == Type.INT) {
            load = new SPRIL.LOAD(MemAddr.ImmValue, String.valueOf(ctx.getText()), reg(ctx));
            lines = 1;
        } else if (result.getType(ctx) == Type.BOOL) {
            if (ctx.getText().equals(SWEET)) {
                load = new SPRIL.LOAD(MemAddr.ImmValue, TRUE, reg(ctx));
            } else {
                load = new SPRIL.LOAD(MemAddr.ImmValue, FALSE, reg(ctx));
            }
            lines = 1;
        } else if (result.getType(ctx) == Type.CHAR) {
            String ch = ctx.getText().replaceAll("\'", "");
            char c = ch.charAt(0);
            int i = (int) c;
            load = new SPRIL.LOAD(MemAddr.ImmValue, String.valueOf(i), reg(ctx));
            lines = 1;
        } else if (result.getType(ctx) == Type.DOUBLE) {
            // TODO: implement doubles
        } else if (result.getType(ctx) == Type.STR) {
            // TODO: implement strings
        } else {
            // This should not happen
            load = new SPRIL.LOAD(MemAddr.ImmValue, String.valueOf(ctx.getText()), reg(ctx));
            lines = 1;
        }
        addOp(load.toString());
        setCodeLines(ctx, lines);
        return CONST;
    }

    @Override
    public String visitIdExpr(GuavaParser.IdExprContext ctx) {
        String var = ctx.ID().getText();
        setRegExplicit(ctx, reg(var));
        setCodeLines(ctx, 0);
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
            this.varRegisters.put(var, emptyRegisters.remove(0));
            return this.varRegisters.get(var);
        }
    }

    private String reg(ParseTree tree) {
        if (this.registers.get(tree) != null) {
            return this.registers.get(tree);
        } else {
            this.registers.put(tree, emptyRegisters.remove(0));
            return this.registers.get(tree);
        }
    }

    private void emptyReg(ParseTree tree) {
        if (!varRegisters.containsKey(tree.getText())) {
            this.emptyRegisters.add(0, reg(tree));
        }
    }

    private int getCodeLines(ParseTree tree) {
        return this.codeLines.get(tree);
    }

    private void setCodeLines(ParseTree tree, int i) {
        this.codeLines.put(tree, i);
    }

    private void setNext(ParseTree tree, ParserRuleContext node) {
        this.next.put(tree, node);
    }

    private ParserRuleContext getNext(ParseTree tree) {
        return this.next.get(tree);
    }
}
