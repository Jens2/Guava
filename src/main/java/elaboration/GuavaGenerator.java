package elaboration;

import grammar.GuavaBaseVisitor;
import grammar.GuavaLexer;
import grammar.GuavaParser;
import instructions.MemAddr;
import instructions.Op;
import instructions.SPRIL;
import instructions.Target;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.junit.Assert;

import java.io.*;
import java.util.*;

/**
 * Created by Jens on 14-6-2016.
 *
 */
public class GuavaGenerator extends GuavaBaseVisitor<String> {
    /** This is the result of the checking phase.*/
    private CheckerResult result;
    /** This is the list with operations which will be filled during the code generation.*/
    private List<String> operations;

    /** The ParseTreeProperty and Map are used for register allocation and retrieval of registers for certain nodes.*/
    private ParseTreeProperty<String> registers;
    private Map<String, String> varRegisters;
    /** This is a list of all registers which can be overwritten.*/
    private List<String> emptyRegisters;

    private ParseTreeProperty<ParserRuleContext> next;

    /** This ParseTreeProperty is used to store the number of lines generated by each specific ParseTree.
     *  This is used to determine where to jump to in the if, while and for statements.*/
    private ParseTreeProperty<Integer> codeLines;
    /** This is the static array of all registers available in Haskell.*/
    private static final String[] availableRegs = {"regA", "regB", "regC", "regD", "regE", "regF"
                                                 , "regG", "regH", "regI", "regJ", "regK", "regL"
                                                 , "regM", "regN", "regO", "regP", "regQ", "regR"
                                                 , "regS", "regT", "regU", "regV", "regW"};
    private static ParserRuleContext END;

    private static final String CONST = "CONST";
    private static final String DIR = "DIR";
//    private static final String IND = "IND";
    private static final String SWEET = "sweet";
    private static final String MINUS = "minus";
    private static final String SOUR = "sour";
    private static final String TRUE = "1";
    private static final String FALSE = "0";

    public GuavaGenerator(ParseTree tree, CheckerResult result) {
        Assert.assertTrue(result != null);
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
        int lines = 0;
        String var = ctx.ID().getText();
        visit(ctx.expr());

        lines += getCodeLines(ctx.expr());

        addOp(new SPRIL.REGCOPY(reg(ctx.expr()), reg(var)).toString());

        setCodeLines(ctx, lines + 1);
        emptyReg(ctx.expr());
        return null;
    }

    @Override
    public String visitIfStat(GuavaParser.IfStatContext ctx) {
        int lines = 0;
        visit(ctx.expr());
        lines += getCodeLines(ctx.expr());
        if (ctx.ELSE() == null) {
            addOp(new SPRIL.BRANCH(reg(ctx.expr()), Target.Rel, "2").toString());
            int index = reserveOp();        // We want to insert a relative jump instruction on this index later on.
            visit(ctx.stat(0));
            int jump = getCodeLines(ctx.stat(0)) + 1;
            lines += jump;
            addOp(new SPRIL.JUMP(Target.Rel, "" + jump).toString(), index);
            lines += 2;
        } else {
            addOp(new SPRIL.BRANCH(reg(ctx.expr()), Target.Rel, "2").toString());

            int ifJump = reserveOp();       // We want to insert a relative jump instruction on this index later on.
            visit(ctx.stat(0));
            int elseJump = reserveOp();     // We want to insert a relative jump instruction on this index later on.
            visit(ctx.stat(1));

            int jump0 = getCodeLines(ctx.stat(0)) + 2;      // We need to jump over all the generated code (hence + 1) and over the extra jump instruction (hence another +1).
            int jump1 = getCodeLines(ctx.stat(1)) + 1;      // We need to jump over all the generated code.

            addOp(new SPRIL.JUMP(Target.Rel, "" + jump0).toString(), ifJump);
            addOp(new SPRIL.JUMP(Target.Rel, "" + jump1).toString(), elseJump);

            lines += getCodeLines(ctx.stat(0));
            lines += getCodeLines(ctx.stat(1));
            lines += 3;
        }
        setCodeLines(ctx, lines);
        return null;
    }

    @Override
    public String visitBlockStat(GuavaParser.BlockStatContext ctx) {
        int lines = 0;
        for (int i = 0; i < ctx.stat().size() - 1; i++) {
            if (i == ctx.stat().size() - 1) {
                setNext(ctx.stat(i), getNext(ctx));
            } else {
                setNext(ctx.stat(i), result.getEntry(ctx.stat(i + 1)));
            }
        }
        visitChildren(ctx);
        for (int i = 0; i < ctx.stat().size(); i++) {
            lines += getCodeLines(ctx.stat(i));
        }
        setCodeLines(ctx, lines);
        return null;
    }

    @Override
    public String visitWhileStat(GuavaParser.WhileStatContext ctx) {
        int lines = 0;
        visit(ctx.expr());
        lines += getCodeLines(ctx.expr());

        addOp(new SPRIL.BRANCH(reg(ctx.expr()), Target.Rel, "2").toString());
        int index = reserveOp();

        visit(ctx.stat());
        int jump = getCodeLines(ctx.stat()) + 2;
        lines += getCodeLines(ctx.stat());

        addOp(new SPRIL.JUMP(Target.Rel, ""+jump).toString(), index);
        lines += 2;
        addOp(new SPRIL.JUMP(Target.Rel, "(-"+lines+")").toString());
        lines++;

        setCodeLines(ctx, lines);
        return null;
    }

    @Override
    public String visitForStat(GuavaParser.ForStatContext ctx) {
        int lines = 0;
        visit(ctx.forAss());
        lines += getCodeLines(ctx.forAss());

        visit(ctx.expr(0));
        lines += getCodeLines(ctx.expr(0));

        addOp(new SPRIL.BRANCH(reg(ctx.expr(0)), Target.Rel, "2").toString());
        lines++;

        int index = reserveOp();
        visit(ctx.stat());
        lines += getCodeLines(ctx.stat());

        int jump = getCodeLines(ctx.stat()) + 3;
        addOp(new SPRIL.JUMP(Target.Rel, ""+jump).toString(), index);
        lines++;
        int add = 0;
        if (ctx.expr().size() > 1) {
            visit(ctx.expr(1));
            lines += getCodeLines(ctx.expr(1));
            add = getCodeLines(ctx.expr(1));
        } else if (ctx.PLUS() != null) {
            addOp(new SPRIL.COMP(Op.Incr, "", reg(ctx.forAss()), reg(ctx.forAss())).toString());
            lines++;
            add = 1;
        } else if (ctx.MINUS() != null) {
            addOp(new SPRIL.COMP(Op.Decr, "", reg(ctx.forAss()), reg(ctx.forAss())).toString());
            lines++;
            add = 1;
        } else {
            // This should not happen.
        }

        jump = getCodeLines(ctx.stat()) + 3 + add;
        addOp(new SPRIL.JUMP(Target.Rel, "(-"+jump+")").toString());

        setCodeLines(ctx, lines);
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
            load = new SPRIL.LOAD(MemAddr.ImmValue, "(-1)", reg(ctx));
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
        emptyReg(ctx.expr(1));
        emptyReg(ctx.expr(0));
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
        emptyReg(ctx.expr(1));
        emptyReg(ctx.expr(0));
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
        emptyReg(ctx.expr(1));
        emptyReg(ctx.expr(0));
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
        emptyReg(ctx.expr(1));
        emptyReg(ctx.expr(0));
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
        SPRIL.CONST load = null;
        int lines = 0;
        if (result.getType(ctx) == Type.INT) {
            load = new SPRIL.CONST(ctx.getText(), reg(ctx));
            lines = 1;
        } else if (result.getType(ctx) == Type.BOOL) {
            if (ctx.getText().equals(SWEET)) {
                load = new SPRIL.CONST(TRUE, reg(ctx));
            } else {
                load = new SPRIL.CONST(FALSE, reg(ctx));
            }
            lines = 1;
        } else if (result.getType(ctx) == Type.CHAR) {
            String ch = ctx.getText().replaceAll("'", "");
            char c = ch.charAt(0);
            int i = (int) c;
            load = new SPRIL.CONST(String.valueOf(i), reg(ctx));
            lines = 1;
        } else if (result.getType(ctx) == Type.DOUBLE) {
            // TODO: implement doubles
        } else if (result.getType(ctx) == Type.STR) {
            // TODO: implement strings
        } else {
            // This should not happen
            load = new SPRIL.CONST(ctx.getText(), reg(ctx));
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
        String var = ctx.ID().getText();
        int lines = 0;
        if (ctx.expr() != null) {
            visit(ctx.expr());
            lines += getCodeLines(ctx.expr());
            setRegExplicit(var, reg(ctx.expr()));
            setRegExplicit(ctx, reg(var));
        }
        setCodeLines(ctx, lines);


        return null;
    }

    @Override
    public String visitForExisting(GuavaParser.ForExistingContext ctx) {
        String var = ctx.ID().getText();
        setRegExplicit(ctx, reg(var));
        setCodeLines(ctx, 0);
        return null;
    }


    /** Getters and setters. */
    private void addOp(String op) {
        this.operations.add(op);
    }

    private void addOp(String op, int index) {
        this.operations.remove(index);
        this.operations.add(index, op);
    }

    private int reserveOp() {
        this.operations.add("RESERVED");
        return this.operations.size() - 1;
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
