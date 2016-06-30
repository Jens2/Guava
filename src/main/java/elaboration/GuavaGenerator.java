package elaboration;

import spril.Instruction;
import spril.MemAddr;
import spril.Op;
import spril.Target;
import grammar.GuavaBaseVisitor;
import grammar.GuavaParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.junit.Assert;

import java.util.*;

/**
 * Created by Jens on 30-6-2016.
 *
 */
public class GuavaGenerator extends GuavaBaseVisitor<String> {
    /** This is the result of the checking phase.*/
    private CheckerResult result;

    /** This is the list with instructions which will be filled during the code generation.*/
    private List<String> instructions;

    /** This is the list with instructions which will be executed concurrently.*/
    private List<List<String>> concurrentInstructions;

    /** The ParseTreeProperty and Map are used for register allocation and retrieval of registers for certain nodes.*/
    private ParseTreeProperty<String> registers;

    /** This is a list of all registers which can be overwritten.*/
    private List<String> emptyRegisters;

    /** This ParseTreeProperty is used to store the number of lines generated by each specific ParseTree.
     *  This is used to determine where to jump to in the if, while and for statements.*/
    private ParseTreeProperty<Integer> codeLines;


    private ParseTreeProperty<Integer> concurrentList;

    /** Variables declared in for-loops will be stored here. These variables are saved and handled entirely in
     *  registers, to speed up execution*/
    private Map<String, String> nestedVars;

    /** OPTIMIZATION*/

    private Map<String, String> loadedVariables;

    private ParseTreeProperty<List<String>> arrayValues;

    /** Will be set to true when a for-loop declaration is entered, to ensure some registers do not get emptied*/
    private boolean nested;

    private boolean locked;

    private static ParserRuleContext END;

    private static final String CONST = "CONST";
    private static final String DIR = "DIR";
    private static final String REG0 = "reg0";
    private static final String TRUE = "1";
    private static final String FALSE = "0";

    public GuavaGenerator(ParseTree tree, CheckerResult result, String[] availableRegs) {
        Assert.assertTrue(result != null);

        this.result = result;
        this.instructions = new ArrayList<>();
        this.concurrentInstructions = new ArrayList<>();
        this.registers = new ParseTreeProperty<>();
        this.emptyRegisters = new ArrayList<>();
        this.codeLines = new ParseTreeProperty<>();
        this.concurrentList = new ParseTreeProperty<>();
        this.nestedVars = new HashMap<>();
        this.loadedVariables = new HashMap<>();
        this.arrayValues = new ParseTreeProperty<>();
        this.nested = false;

        Collections.addAll(emptyRegisters, availableRegs);
        tree.accept(this);
    }

    /** Get the list of all instructions.*/
    public List<String> getInstructions() {
        return this.instructions;
    }

    public List<List<String>> getConcurrentInstructions() {return this.concurrentInstructions; }

    /** Start of the program. */
    @Override
    public String visitProgram(GuavaParser.ProgramContext ctx) {
        END = ctx;
        visitChildren(ctx);
        // A write instruction is finished after 5 iterations, so we want to make sure that a potential final write is finished.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                addInstr(new Instruction.Nop(), -1, j);
            }
        }
        for (int i = 0; i < 4; i++) {
            addInstr(new Instruction.EndProg(), -1, i);
        }
        return null;
    }

    /** Body of the program. */
    @Override
    public String visitBody(GuavaParser.BodyContext ctx) {
        if (result.isConc()) {
        }
        visitChildren(ctx);
        return null;
    }

    @Override
    public String visitGlobalDecl(GuavaParser.GlobalDeclContext ctx) {
        int lines = 0;

        if (ctx.expr() != null) {
            if (hasThreadNo(ctx)) {
                setThreadNo(ctx.expr(), getThreadNo(ctx));
            }
            visit(ctx.expr());
            lines += getCodeLines(ctx.expr());

            Instruction write;
            if (isZero(ctx.expr())) {
                write = new Instruction.WriteInst(REG0, MemAddr.DirAddr, offset2String(offset(ctx.ID())));
            } else {
                write = new Instruction.WriteInst(reg(ctx.expr()), MemAddr.DirAddr, offset2String(offset(ctx.ID())));
            }
            if (hasThreadNo(ctx)) {
                addInstr(write, -1, getThreadNo(ctx));
            } else {
                addInstr(write);
            }

            emptyReg(ctx.expr());
        }

        setCodeLines(ctx, lines + 1);
        return null;
    }

    /** All stats of the program. */
    @Override
    public String visitVarDeclStat(GuavaParser.VarDeclStatContext ctx) {
        int lines = 0;

        if (ctx.expr() != null) {
            if (hasThreadNo(ctx)) {
                setThreadNo(ctx.expr(), getThreadNo(ctx));
            }
            visit(ctx.expr());
            lines += getCodeLines(ctx.expr());

            Instruction store;
            if (isZero(ctx.expr())) {
                store = new Instruction.Store(REG0, MemAddr.DirAddr, offset2String(offset(ctx.ID())));
            } else {
                store = new Instruction.Store(reg(ctx.expr()), MemAddr.DirAddr, offset2String(offset(ctx.ID())));
            }
            if (hasThreadNo(ctx)) {
                addInstr(store, -1, getThreadNo(ctx));
            } else {
                addInstr(store);
            }

            emptyReg(ctx.expr());
        }

        setCodeLines(ctx, lines + 1);
        return null;
    }

    @Override
    public String visitArrayDeclStat(GuavaParser.ArrayDeclStatContext ctx) {
        int lines = 0;
        Instruction store;

        if (ctx.expr() != null) {
            if (hasThreadNo(ctx)) {
                setThreadNo(ctx.expr(), getThreadNo(ctx));
            }
            visit(ctx.expr());
            lines += getCodeLines(ctx.expr());

            List<String> regs = this.arrayValues.get(ctx.expr());

            for (int i = 0; i < regs.size(); i++) {
                store = new Instruction.Store(regs.get(i), MemAddr.DirAddr, "(" + offset2String(offset(ctx.ID())) + " + " + i + ")");
                if (hasThreadNo(ctx)) {
                    addInstr(store, -1, getThreadNo(ctx));
                } else {
                    addInstr(store);

                }

                lines++;
            }

            for (int i = regs.size() - 1; i >= 0; i--) {
                emptyReg(regs.get(i));
            }
        }

        setCodeLines(ctx, lines);
        return null;
    }

    @Override
    public String visitAssignStat(GuavaParser.AssignStatContext ctx) {
        int lines = 0;

        if (hasThreadNo(ctx)) {
            setThreadNo(ctx.expr(), getThreadNo(ctx));
        }

        visit(ctx.expr());
        lines += getCodeLines(ctx.expr());

        Instruction store;
        if (result.getType(ctx.expr()).getKind() == PrimitiveTypes.ARRAY) {
            List<String> regs = this.arrayValues.get(ctx.expr());

            for (int i = 0; i < regs.size(); i++) {
                store = new Instruction.Store(regs.get(i), MemAddr.DirAddr, "(" + offset2String(offset(ctx.ID())) + " + " + i + ")");
                if (hasThreadNo(ctx)) {
                    addInstr(store, -1, getThreadNo(ctx));
                } else {
                    addInstr(store);
                }
                lines++;
            }

            for (int i = regs.size() - 1; i > 0; i--) {
                emptyReg(regs.get(i));
            }

        } else {
            String reg;

            if (isZero(ctx.expr())) {
                reg = REG0;
            } else {
                reg = reg(ctx.expr());
            }

            if (result.isGlobalVar(ctx.ID())) {
                store = new Instruction.WriteInst(reg, MemAddr.DirAddr, offset2String(offset(ctx.ID())));
            } else {
                store = new Instruction.Store(reg, MemAddr.DirAddr, offset2String(offset(ctx.ID())));
            }

            lines++;
            if (hasThreadNo(ctx)) {
                addInstr(store, -1, getThreadNo(ctx));
            } else {
                addInstr(store);
            }
        }

        setCodeLines(ctx, lines);

        emptyReg(ctx.expr());
        releaseLoadedVariables();
        return null;
    }

    @Override
    public String visitAssignArrayStat(GuavaParser.AssignArrayStatContext ctx) {
        int lines = 0;

        if (hasThreadNo(ctx)) {
            setThreadNo(ctx.expr(), getThreadNo(ctx));
        }

        visit(ctx.expr());
        lines += getCodeLines(ctx.expr());

        Instruction store = new Instruction.Store(reg(ctx.expr()), MemAddr.DirAddr, reg(ctx));
        if (hasThreadNo(ctx)) {
            addInstr(store, -1, getThreadNo(ctx));
        } else {
            addInstr(store);
        }

        lines += 1;

        setCodeLines(ctx, lines);
        emptyReg(reg(ctx.expr()));
        return null;
    }

    @Override
    public String visitIfStat(GuavaParser.IfStatContext ctx) {
        int lines = 0;

        if (hasThreadNo(ctx)) {
            for (int i = 0; i < ctx.stat().size(); i++) {
                setThreadNo(ctx.stat(i), getThreadNo(ctx));
            }
            setThreadNo(ctx.expr(), getThreadNo(ctx));
        }

        visit(ctx.expr());
        lines += getCodeLines(ctx.expr());

        if (ctx.ELSE() == null) {
            if (hasThreadNo(ctx)) {
                addInstr(new Instruction.Branch(reg(ctx.expr()), Target.Rel, "2"), -1, getThreadNo(ctx));
            } else {
                addInstr(new Instruction.Branch(reg(ctx.expr()), Target.Rel, "2"));
            }
            int index = reserveInstr();        // We want to insert a relative jump instruction on this index later on.
            visit(ctx.stat(0));
            int jump = getCodeLines(ctx.stat(0)) + 1;
            lines += jump;
            addInstr(new Instruction.Jump(Target.Rel, "" + jump), index);
            lines += 2;
        } else {
            if (hasThreadNo(ctx)) {
                addInstr(new Instruction.Branch(reg(ctx.expr()), Target.Rel, "2"), -1, getThreadNo(ctx));
            } else {
                addInstr(new Instruction.Branch(reg(ctx.expr()), Target.Rel, "2"));
            }

            int ifJump = reserveInstr();       // We want to insert a relative jump instruction on this index later on.
            visit(ctx.stat(0));
            int elseJump = reserveInstr();     // We want to insert a relative jump instruction on this index later on.
            visit(ctx.stat(1));

            int jump0 = getCodeLines(ctx.stat(0)) + 2;      // We need to jump over all the generated code (hence + 1) and over the extra jump instruction (hence another +1).
            int jump1 = getCodeLines(ctx.stat(1)) + 1;      // We need to jump over all the generated code.

            if (hasThreadNo(ctx)) {
                addInstr(new Instruction.Jump(Target.Rel, "" + jump0), ifJump, getThreadNo(ctx));
                addInstr(new Instruction.Jump(Target.Rel, "" + jump1), elseJump, getThreadNo(ctx));
            } else {
                addInstr(new Instruction.Jump(Target.Rel, "" + jump0), ifJump);
                addInstr(new Instruction.Jump(Target.Rel, "" + jump1), elseJump);
            }

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

        if (hasThreadNo(ctx)) {
            for (int i = 0; i < ctx.stat().size(); i++) {
                setThreadNo(ctx.stat(i), getThreadNo(ctx));
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

        if (hasThreadNo(ctx)) {
            setThreadNo(ctx.stat(), getThreadNo(ctx));
            setThreadNo(ctx.expr(), getThreadNo(ctx));
        }

        visit(ctx.expr());
        lines += getCodeLines(ctx.expr());

        if (hasThreadNo(ctx)) {
            addInstr(new Instruction.Branch(reg(ctx.expr()), Target.Rel, "2"), -1, getThreadNo(ctx));
        } else {
            addInstr(new Instruction.Branch(reg(ctx.expr()), Target.Rel, "2"));
        }
        int index = reserveInstr();

        visit(ctx.stat());
        int jump = getCodeLines(ctx.stat()) + 2;
        lines += getCodeLines(ctx.stat());

        if (hasThreadNo(ctx)) {
            addInstr(new Instruction.Jump(Target.Rel, "" + jump), index, getThreadNo(ctx));
            lines += 2;
            addInstr(new Instruction.Jump(Target.Rel, "(-" + lines + ")"), -1, getThreadNo(ctx));
            lines++;
        } else {
            addInstr(new Instruction.Jump(Target.Rel, "" + jump), index);
            lines += 2;
            addInstr(new Instruction.Jump(Target.Rel, "(-" + lines + ")"));
            lines++;
        }

        setCodeLines(ctx, lines);
        return null;
    }

    @Override
    public String visitForStat(GuavaParser.ForStatContext ctx) {
        int lines = 0;

        if (hasThreadNo(ctx)) {
            setThreadNo(ctx.stat(), getThreadNo(ctx));
            for (int i = 0; i < ctx.expr().size(); i++) {
                setThreadNo(ctx.expr(i), getThreadNo(ctx));
            }
            setThreadNo(ctx.forAss(), getThreadNo(ctx));
        }

        visit(ctx.forAss());
        lines += getCodeLines(ctx.forAss());

        nested = true;
        visit(ctx.expr(0));
        nested = false;

        lines += getCodeLines(ctx.expr(0));

        if (hasThreadNo(ctx)) {
            addInstr(new Instruction.Branch(reg(ctx.expr(0)), Target.Rel, "2"), -1, getThreadNo(ctx));
        } else {
            addInstr(new Instruction.Branch(reg(ctx.expr(0)), Target.Rel, "2"));
        }
        lines++;

        int index = reserveInstr();

        visit(ctx.stat());
        lines += getCodeLines(ctx.stat());

        int jump = getCodeLines(ctx.stat()) + 3;
        if (hasThreadNo(ctx)) {
            addInstr(new Instruction.Jump(Target.Rel, "" + jump), index, getThreadNo(ctx));
        } else {
            addInstr(new Instruction.Jump(Target.Rel, "" + jump), index);
        }
        lines++;
        int add = 0;
        if (ctx.expr().size() > 1) {
            visit(ctx.expr(1));
            lines += getCodeLines(ctx.expr(1));
            add = getCodeLines(ctx.expr(1));
        } else if (ctx.PLUS() != null) {
            if (hasThreadNo(ctx)) {
                addInstr(new Instruction.Compute(Op.Incr, getNestedVarReg(ctx.ID()), REG0, getNestedVarReg(ctx.ID())), -1, getThreadNo(ctx));
            } else {
                addInstr(new Instruction.Compute(Op.Incr, getNestedVarReg(ctx.ID()), REG0, getNestedVarReg(ctx.ID())));
            }
            lines++;
            add = 1;
        } else if (ctx.MINUS() != null) {
            if (hasThreadNo(ctx)) {
                addInstr(new Instruction.Compute(Op.Decr, getNestedVarReg(ctx.ID()), REG0, getNestedVarReg(ctx.ID())), -1, getThreadNo(ctx));
            } else {
                addInstr(new Instruction.Compute(Op.Decr, getNestedVarReg(ctx.ID()), REG0, getNestedVarReg(ctx.ID())));
            }
            lines++;
            add = 1;
        }

        jump = getCodeLines(ctx.stat()) + 3 + add;
        if (hasThreadNo(ctx)) {
            addInstr(new Instruction.Jump(Target.Rel, "(-" + jump + ")"), -1, getThreadNo(ctx));
        } else {
            addInstr(new Instruction.Jump(Target.Rel, "(-" + jump + ")"));
        }
        lines++;

        setCodeLines(ctx, lines);

        emptyReg(ctx.expr(0));
        delNestedVar(ctx.ID());
        return null;
    }

    @Override
    public String visitBranchStat(GuavaParser.BranchStatContext ctx) {
        int lines = 4;
        int statSize = ctx.stat().size();

        Instruction load = new Instruction.LoadConst("1", reg(ctx));
        Instruction wakeUp0 = new Instruction.WriteInst(reg(ctx), MemAddr.DirAddr, "0");
        Instruction wakeUp1 = new Instruction.WriteInst(reg(ctx), MemAddr.DirAddr, "1");
        Instruction wakeUp2 = new Instruction.WriteInst(reg(ctx), MemAddr.DirAddr, "2");

        if (hasThreadNo(ctx)) {
            for (int i = 0; i < statSize; i++) {
                setThreadNo(ctx.stat(i), getThreadNo(ctx));
            }
            addInstr(load, -1, getThreadNo(ctx));
            addInstr(wakeUp0, -1, getThreadNo(ctx));
            addInstr(wakeUp1, -1, getThreadNo(ctx));
            addInstr(wakeUp2, -1, getThreadNo(ctx));
        } else {
            addInstr(load);
            addInstr(wakeUp0);
            addInstr(wakeUp1);
            addInstr(wakeUp2);
        }

        initConcList(ctx);

        for (int i = 0; i < statSize; i++) {
            setThreadNo(ctx.stat(i), (i%4));
        }

        for (int i = 0; i < statSize; i++) {
            visit(ctx.stat(i));
            lines += getCodeLines(ctx.stat(i));
        }


        setCodeLines(ctx, lines);
        return null;
    }

    @Override
    public String visitLockStat(GuavaParser.LockStatContext ctx) {
        if (hasThreadNo(ctx)) {
            for (int i = 0; i < ctx.stat().size(); i++) {
                setThreadNo(ctx.stat(i), getThreadNo(ctx));
            }
        }

        int lines = 5;
        String offset = "(";
        offset += offset2String(result.getOffset(ctx.ID(), result.isGlobalVar(ctx.ID())));
        // The lock is always stored on the offset + 1
        offset += " + 1)";

        Instruction testAndSet = new Instruction.TestAndSet(MemAddr.DirAddr, offset);
        Instruction receive = new Instruction.Receive(reg(ctx));
        Instruction branch = new Instruction.Branch(reg(ctx), Target.Rel, "2");
        Instruction jump = new Instruction.Jump(Target.Rel, "(-3)");

        if (hasThreadNo(ctx)) {
            addInstr(testAndSet, -1, getThreadNo(ctx));
            addInstr(receive, -1, getThreadNo(ctx));
            addInstr(branch, -1, getThreadNo(ctx));
            addInstr(jump, -1, getThreadNo(ctx));
        } else {
            addInstr(testAndSet);
            addInstr(receive);
            addInstr(branch);
            addInstr(jump);
        }
        locked = true;
        for (int i = 0; i < ctx.stat().size(); i++) {
            visit(ctx.stat(i));
            lines += getCodeLines(ctx.stat(i));
        }
        locked = false;

        Instruction write = new Instruction.WriteInst("reg0", MemAddr.DirAddr, offset);
        if (hasThreadNo(ctx)) {
            addInstr(write, -1, getThreadNo(ctx));
        } else {
            addInstr(write);
        }

        emptyReg(ctx);
        setCodeLines(ctx, lines);
        return null;
    }

    /** All expressions. */
    @Override
    public String visitPrfExpr(GuavaParser.PrfExprContext ctx) {
        int lines = 0;
        if (hasThreadNo(ctx)) {
            setThreadNo(ctx.expr(), getThreadNo(ctx));
        }
        visit(ctx.expr());

        lines += getCodeLines(ctx.expr());

        String reg = getReg(ctx.expr());

        Instruction load;
        Instruction neg;
        if (result.getType(ctx.expr()) == Type.BOOL) {
            load = new Instruction.Load(MemAddr.ImmValue, String.valueOf(1), reg(ctx));
            neg = new Instruction.Compute(Op.Xor, reg, reg(ctx), reg(ctx));
        } else {
            load = new Instruction.Load(MemAddr.ImmValue, "(-1)", reg(ctx));
            neg = new Instruction.Compute(Op.Mul, reg, reg(ctx), reg(ctx));
        }

        if (hasThreadNo(ctx)) {
            addInstr(load, -1, getThreadNo(ctx));
            addInstr(load, -1, getThreadNo(ctx));
        } else {
            addInstr(load);
            addInstr(neg);
        }
        setCodeLines(ctx, lines + 1);

        emptyReg(ctx.expr());
        return DIR;
    }

    @Override
    public String visitMultExpr(GuavaParser.MultExprContext ctx) {
        int lines = 0;
        if (hasThreadNo(ctx)) {
            setThreadNo(ctx.expr(0), getThreadNo(ctx));
            setThreadNo(ctx.expr(1), getThreadNo(ctx));
        }
        visit(ctx.expr(0));
        visit(ctx.expr(1));

        String reg1 = getReg(ctx.expr(0));
        String reg2 = getReg(ctx.expr(1));

        if (isZero(ctx.expr(0))) {
            reg1 = REG0;
            emptyReg(ctx.expr(0));
        } else {
            lines += getCodeLines(ctx.expr(0));
        }

        if (isZero(ctx.expr(1))) {
            reg2 = REG0;
            emptyReg(ctx.expr(1));
        } else {
            lines += getCodeLines(ctx.expr(1));
        }

        Instruction mult = null;

        switch (ctx.multOp().getText()) {
            case "*":
                mult = new Instruction.Compute(Op.Mul, reg1, reg2, reg(ctx));
                break;
            case "/":
                mult = new Instruction.Compute(Op.Div, reg1, reg2, reg(ctx));
                break;
            case "^":
                mult = new Instruction.Compute(Op.Pow, reg1, reg2, reg(ctx));
                break;
        }

        if (hasThreadNo(ctx)) {
            addInstr(mult, -1, getThreadNo(ctx));
        } else {
            addInstr(mult);
        }
        setCodeLines(ctx, lines + 1);

        emptyReg(ctx.expr(1));
        emptyReg(ctx.expr(0));
        return DIR;
    }

    @Override
    public String visitPlusExpr(GuavaParser.PlusExprContext ctx) {
        int lines = 0;
        if (hasThreadNo(ctx)) {
            setThreadNo(ctx.expr(0), getThreadNo(ctx));
            setThreadNo(ctx.expr(1), getThreadNo(ctx));
        }
        visit(ctx.expr(0));
        visit(ctx.expr(1));

        String reg1 = getReg(ctx.expr(0));
        String reg2 = getReg(ctx.expr(1));

        if (isZero(ctx.expr(0))) {
            reg1 = REG0;
            emptyReg(ctx.expr(0));
        } else {
            lines += getCodeLines(ctx.expr(0));
        }

        if (isZero(ctx.expr(1))) {
            reg2 = REG0;
            emptyReg(ctx.expr(1));
        } else {
            lines += getCodeLines(ctx.expr(1));
        }

        Instruction plus = null;

        switch (ctx.plusOp().getText()) {
            case "+":
                plus = new Instruction.Compute(Op.Add, reg1, reg2, reg(ctx));
                break;
            case "-":
                plus = new Instruction.Compute(Op.Sub, reg1, reg2, reg(ctx));
                break;
        }

        if (hasThreadNo(ctx)) {
            addInstr(plus, -1, getThreadNo(ctx));
        } else {
            addInstr(plus);
        }
        setCodeLines(ctx, lines + 1);

        emptyReg(ctx.expr(1));
        emptyReg(ctx.expr(0));
        return DIR;
    }

    @Override
    public String visitBoolExpr(GuavaParser.BoolExprContext ctx) {
        int lines = 0;
        if (hasThreadNo(ctx)) {
            setThreadNo(ctx.expr(0), getThreadNo(ctx));
            setThreadNo(ctx.expr(1), getThreadNo(ctx));
        }
        visit(ctx.expr(0));
        visit(ctx.expr(1));

        String reg1 = getReg(ctx.expr(0));
        String reg2 = getReg(ctx.expr(1));

        if (isZero(ctx.expr(0))) {
            reg1 = REG0;
            emptyReg(ctx.expr(0));
        } else {
            lines += getCodeLines(ctx.expr(0));
        }

        if (isZero(ctx.expr(1))) {
            reg2 = REG0;
            emptyReg(ctx.expr(1));
        } else {
            lines += getCodeLines(ctx.expr(1));
        }

        Instruction bool = null;

        switch (ctx.boolOp().getText()) {
            case "&":
                bool = new Instruction.Compute(Op.And, reg1, reg2, reg(ctx));
                break;
            case "|":
                bool = new Instruction.Compute(Op.Or, reg1, reg2, reg(ctx));
                break;
        }

        if (hasThreadNo(ctx)) {
            addInstr(bool, -1, getThreadNo(ctx));
        } else {
            addInstr(bool);
        }        setCodeLines(ctx, lines + 1);

        emptyReg(ctx.expr(1));
        emptyReg(ctx.expr(0));
        return DIR;
    }

    @Override
    public String visitCompExpr(GuavaParser.CompExprContext ctx) {
        int lines = 0;
        if (hasThreadNo(ctx)) {
            setThreadNo(ctx.expr(0), getThreadNo(ctx));
            setThreadNo(ctx.expr(1), getThreadNo(ctx));
        }
        visit(ctx.expr(0));
        visit(ctx.expr(1));

        String reg1 = getReg(ctx.expr(0));
        String reg2 = getReg(ctx.expr(1));

        if (isZero(ctx.expr(0))) {
            reg1 = REG0;
            emptyReg(ctx.expr(0));
        } else {
            lines += getCodeLines(ctx.expr(0));
        }

        if (isZero(ctx.expr(1))) {
            reg2 = REG0;
            emptyReg(ctx.expr(1));
        } else {
            lines += getCodeLines(ctx.expr(1));
        }

        Instruction compute = null;

        switch (ctx.compOp().getText()) {
            case ">":
                compute = new Instruction.Compute(Op.Gt, reg1, reg2, reg(ctx));
                break;
            case ">=":
                compute = new Instruction.Compute(Op.GtE, reg1, reg2, reg(ctx));
                break;
            case "<":
                compute = new Instruction.Compute(Op.Lt, reg1, reg2, reg(ctx));
                break;
            case "<=":
                compute = new Instruction.Compute(Op.LtE, reg1, reg2, reg(ctx));
                break;
            case "~=":
                compute = new Instruction.Compute(Op.NEq, reg1, reg2, reg(ctx));
                break;
            case "==":
                compute = new Instruction.Compute(Op.Equal, reg1, reg2, reg(ctx));
                break;
        }

        if (hasThreadNo(ctx)) {
            addInstr(compute, -1, getThreadNo(ctx));
        } else {
            addInstr(compute);
        }        setCodeLines(ctx, lines + 1);

        emptyReg(ctx.expr(1));
        emptyReg(ctx.expr(0));
        return DIR;
    }

    @Override
    public String visitParExpr(GuavaParser.ParExprContext ctx) {
        if (hasThreadNo(ctx)) {
            setThreadNo(ctx.expr(), getThreadNo(ctx));
        }
        visit(ctx.expr());
        setCodeLines(ctx, getCodeLines(ctx.expr()));
        return DIR;
    }

    @Override
    public String visitArrayExpr(GuavaParser.ArrayExprContext ctx) {
        int lines = 0;
        if (hasThreadNo(ctx)) {
            for (int i = 0; i < ctx.expr().size(); i++) {
                setThreadNo(ctx.expr(i), getThreadNo(ctx));
            }
        }
        List<String> regs = new ArrayList<>();

        for (int i = 0; i < ctx.expr().size(); i++) {
            visit(ctx.expr(i));
            lines += getCodeLines(ctx.expr(i));
            regs.add(reg(ctx.expr(i)));
        }

        this.arrayValues.put(ctx, regs);
        setCodeLines(ctx, lines);
        return DIR;
    }

    @Override
    public String visitConstExpr(GuavaParser.ConstExprContext ctx) {
        Instruction load = null;
        int lines = 0;

        switch (result.getType(ctx).getKind()) {
            case INT:
                load = new Instruction.LoadConst(ctx.getText(), reg(ctx));
                break;
            case BOOL:
                if (ctx.getText().equals("sweet")) {
                    load = new Instruction.LoadConst(TRUE, reg(ctx));
                } else {
                    load = new Instruction.LoadConst(FALSE, reg(ctx));
                }

                break;
            case CHAR:
                String ch = ctx.getText().replaceAll("'", "");
                char c = ch.charAt(0);
                int i = (int) c;

                load = new Instruction.LoadConst(String.valueOf(i), reg(ctx));

                break;
        }

        if (!isZero(ctx)) {
            if (hasThreadNo(ctx)) {
                addInstr(load, -1, getThreadNo(ctx));
            } else {
                addInstr(load);
            }
            lines++;
        }

        setCodeLines(ctx, lines);
        return CONST;
    }

    @Override
    public String visitGetArrayExpr(GuavaParser.GetArrayExprContext ctx) {
        int lines = 0;
        Instruction load = new Instruction.Load(MemAddr.DirAddr, "(" + offset2String(offset(ctx.ID())) + " + " + ctx.NUM().getText() + ")", reg(ctx));
        lines++;

        if (hasThreadNo(ctx)) {
            addInstr(load, -1, getThreadNo(ctx));
        } else {
            addInstr(load);
        }
        setCodeLines(ctx, lines);
        return DIR;
    }

    @Override
    public String visitIdExpr(GuavaParser.IdExprContext ctx) {
        Instruction load = null;
        Instruction receive = null;
        int lines = 0;

        if (result.isGlobalVar(ctx.ID())) {
            load = new Instruction.ReadInstr(MemAddr.DirAddr, offset2String(offset(ctx.ID())));
            if (!locked) {
                receive = new Instruction.Receive(reg(ctx));
            }
        } else {
            if (!isNestedVar(ctx.ID())) {
                load = new Instruction.Load(MemAddr.DirAddr, offset2String(offset(ctx.ID())), reg(ctx));
            }
        }

        if (load != null && !isLoadedVariable(ctx.ID())) {
            if (hasThreadNo(ctx)) {
                addInstr(load, -1, getThreadNo(ctx));
            } else {
                addInstr(load);
            }
            loadVariable(ctx.ID(), reg(ctx));
            lines += 1;
        }

        if (receive != null) {
            addInstr(receive);
            lines += 1;
        }

        setCodeLines(ctx, lines);
        return DIR;
    }

    /** Assignments in a for loop.*/
    @Override
    public String visitForDecl(GuavaParser.ForDeclContext ctx) {
        int lines = 0;
        if (ctx.expr() != null) {
            if (hasThreadNo(ctx)) {
                setThreadNo(ctx.expr(), getThreadNo(ctx));
            }
            visit(ctx.expr());
            lines += getCodeLines(ctx.expr());
        }

        addNestedVar(ctx.ID(), reg(ctx.expr()));
        setCodeLines(ctx, lines);
        return null;
    }

    @Override
    public String visitForExisting(GuavaParser.ForExistingContext ctx) {
        setCodeLines(ctx, 0);
        return null;
    }

    private void initConcList(ParseTree ctx) {
        List<String> one = new ArrayList<>();
        List<String> two = new ArrayList<>();
        List<String> three = new ArrayList<>();
        Instruction read = new Instruction.ReadInstr(MemAddr.DirAddr, "0");
        Instruction receive = new Instruction.Receive(reg(ctx));
        Instruction branch = new Instruction.Branch(reg(ctx), Target.Rel, "2");
        Instruction jump = new Instruction.Jump(Target.Rel, "(-3)");

        one.add(read.toString());
        one.add(receive.toString());
        one.add(branch.toString());
        one.add(jump.toString());

        read = new Instruction.TestAndSet(MemAddr.DirAddr, "1");
        two.add(read.toString());
        two.add(receive.toString());
        two.add(branch.toString());
        two.add(jump.toString());

        read = new Instruction.TestAndSet(MemAddr.DirAddr, "2");
        three.add(read.toString());
        three.add(receive.toString());
        three.add(branch.toString());
        three.add(jump.toString());

        this.concurrentInstructions.add(one);
        this.concurrentInstructions.add(two);
        this.concurrentInstructions.add(three);
    }

    /**
     * Adds a new instruction to the program
     * @param instr
     */
    private void addInstr(Instruction instr, int index,  int threadno) {
        switch (threadno) {
            case 0:
                if (index != -1) {
                    addInstr(instr, index);
                } else {
                    addInstr(instr);
                }
                break;
            default:
                if (index != -1) {
                    this.concurrentInstructions.get(threadno-1).add(index, instr.toString());
                } else {
                    this.concurrentInstructions.get(threadno-1).add(instr.toString());
                }
        }



    }
    private void addInstr(Instruction instr) {
        this.instructions.add(instr.toString());
    }

    /**
     * Inserts an instruction into the program at a given index (line)
     * @param instr
     * @param index
     */
    private void addInstr(Instruction instr, int index) {
        this.instructions.remove(index);
        this.instructions.add(index, instr.toString());
    }

    /**
     * Reserves an instruction slot that will be filled later (e.g. in case of relative jumps)
     * @return the index of the reserved instruction
     */
    private int reserveInstr() {
        this.instructions.add("RESERVED");
        return this.instructions.size() - 1;
    }

    private void setThreadNo(ParseTree tree, int no) {
        this.concurrentList.put(tree, no);
    }

    private boolean hasThreadNo(ParseTree tree) {
        return this.concurrentList.get(tree) != null;
    }

    private int getThreadNo(ParseTree tree) {
        return this.concurrentList.get(tree);
    }

    /**
     *
     * @param node
     * @param reg
     */
    private void addNestedVar(ParseTree node, String reg) {
        if (!this.nestedVars.containsKey(node.getText())) {
            this.nestedVars.put(node.getText(), reg);
        }
    }

    private void delNestedVar(ParseTree node) {
        if (this.nestedVars.containsKey(node.getText())) {
            this.nestedVars.remove(node.getText());
        }
    }

    private boolean isNestedVar(ParseTree node) {
        return this.nestedVars.containsKey(node.getText());
    }

    private String getNestedVarReg(ParseTree node) {
        return this.nestedVars.get(node.getText());
    }

    private String offset(ParseTree node, boolean global) {
        return this.result.getOffset(node, global);
    }

    private String reg(ParseTree node) {
        if (this.registers.get(node) != null) {
            return this.registers.get(node);
        } else {
            this.registers.put(node, emptyRegisters.remove(0));
            return this.registers.get(node);
        }
    }

    private void emptyReg(ParseTree node) {
        if (!nested) {
            this.emptyRegisters.add(0, reg(node));
        }
    }

    private void emptyReg(String reg) {
        if (!nested) {
            this.emptyRegisters.add(0, reg);
        }
    }

    private String getReg(ParseTree node) {
        String reg;
        if (isNestedVar(node)) {
            reg = getNestedVarReg(node);
        } else if (isLoadedVariable(node)){
            reg = getLoadedVariable(node);
        } else {
            reg = reg(node);
        }

        return reg;
    }

    private void loadVariable(ParseTree node, String reg) {
        if (!this.loadedVariables.containsKey(node.getText())) {
            this.loadedVariables.put(node.getText(), reg);
        }
    }

    private boolean isLoadedVariable(ParseTree node) {
        return this.loadedVariables.containsKey(node.getText());
    }

    private String getLoadedVariable(ParseTree node) {
        return this.loadedVariables.get(node.getText());
    }

    private void releaseLoadedVariables() {
        this.loadedVariables = new HashMap<>();
    }

    private String offset2String(String offset) {
        return this.result.getVarMap().get(Integer.parseInt(offset));
    }

    private int getCodeLines(ParseTree node) {
        return this.codeLines.get(node);
    }

    private void setCodeLines(ParseTree node, int i) {
        this.codeLines.put(node, i);
    }

    private boolean isZero(ParseTree node) {
        return node.getText().equals("0");
    }
}
