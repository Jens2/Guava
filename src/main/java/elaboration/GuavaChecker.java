package elaboration;

import grammar.GuavaBaseListener;
import grammar.GuavaParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dion on 15-6-2016.
 *
 */
public class GuavaChecker extends GuavaBaseListener {

    private CheckerResult checkerResult;
    private GuavaVariableTable variables;
    private List<String> sharedVariables;
    private ParseTreeProperty<Integer> arrayLength;
    private Map<String, Integer> arrayLengthVars;
    private List<String> errors;

    public CheckerResult check(ParseTree tree) throws GuavaException {
        this.checkerResult = new CheckerResult();
        this.variables = new GuavaVariableTable();
        this.sharedVariables = new ArrayList<>();
        this.arrayLength = new ParseTreeProperty<>();
        this.arrayLengthVars = new LinkedHashMap<>();
        this.errors = new ArrayList<>();

        new ParseTreeWalker().walk(this, tree);
        if (hasErrors()) {
            throw new GuavaException(getErrors());
        }

        return this.checkerResult;
    }

    @Override
    public void exitGlobalDecl(GuavaParser.GlobalDeclContext ctx) {
        if (contains(ctx.ID())) {
            addError(ctx, "Variable '%s' is already declared", ctx.ID());
        } else {
            addVariableType(ctx.ID(), getType(ctx.type()), ctx, true);
            setShared(ctx.ID(), true);
        }

        if (ctx.expr() != null) {
            setEntry(ctx, entry(ctx.expr()));
            assign(ctx.ID());
        } else {
            setEntry(ctx, entry(ctx.type()));
        }

        setOffset(ctx.ID(), this.variables.globalOffset(ctx.ID().getText()), true);
        setType(ctx.ID(), getType(ctx.type()));
    }

    @Override
    public void exitVarDeclStat(GuavaParser.VarDeclStatContext ctx) {
        if (contains(ctx.ID())) {
            addError(ctx, "Variable '%s' is already declared", ctx.ID());
        } else {
            addVariableType(ctx.ID(), getType(ctx.type()), ctx, false);
        }

        if (ctx.expr() != null) {
            setEntry(ctx, entry(ctx.expr()));
            assign(ctx.ID());
        } else {
            setEntry(ctx, entry(ctx.type()));
        }

        setOffset(ctx.ID(), this.variables.offset(ctx.ID().getText()), false);
        setType(ctx.ID(), getType(ctx.type()));
    }

    @Override
    public void enterArrayDeclStat(GuavaParser.ArrayDeclStatContext ctx) {
        if (ctx.expr() != null) {
            setArrayLength(ctx.expr(), Integer.parseInt(ctx.NUM().getText()));
        }

        setArrayLengthAsVar(ctx.ID(), Integer.parseInt(ctx.NUM().getText()));
    }

    @Override
    public void exitArrayDeclStat(GuavaParser.ArrayDeclStatContext ctx) {
        Type.Array type = new Type.Array(getType(ctx.type()));
        Type.Array exprType = (Type.Array) getType(ctx.expr());

        if (contains(ctx.ID())) {
            addError(ctx, "Variable '%s' is already declared", ctx.ID());
        } else {
            addArray(ctx.ID(), type, ctx);
        }

        if (ctx.expr() != null) {
            if (type.getElemType() != exprType.getElemType()) {
                addError(ctx, "Expected type '%s' but found '%s'", type, getType(ctx.expr()));
            }

            setEntry(ctx, entry(ctx.expr()));
            assign(ctx.ID());
        } else {
            setEntry(ctx, entry(ctx.type()));
        }

        setType(ctx.ID(), type);
        setOffset(ctx.ID(), this.variables.offset(ctx.ID().getText()), false);
    }

    @Override
    public void enterAssignStat(GuavaParser.AssignStatContext ctx) {
        if (variableType(ctx.ID()).getKind().equals(PrimitiveTypes.ARRAY)) {
            setArrayLength(ctx.expr(), getArrayLengthVar(ctx.ID()));
        }
    }

    @Override
    public void exitAssignStat(GuavaParser.AssignStatContext ctx) {
        if (!variableType(ctx.ID()).equals(getType(ctx.expr()))) {
            addError(ctx, "Expected type '%s' but found '%s'", variableType(ctx.ID()), getType(ctx.expr()));
        }

        if (isShared(ctx.ID())) {
            setShared(ctx.ID(), true);
            setOffset(ctx.ID(), this.variables.globalOffset(ctx.ID().getText()), true);
        } else {
            setOffset(ctx.ID(), this.variables.offset(ctx.ID().getText()), false);
        }

        setEntry(ctx, entry(ctx.expr()));
        assign(ctx.ID());
    }

    @Override
    public void enterAssignArrayStat(GuavaParser.AssignArrayStatContext ctx) {
        //setArrayLength(ctx.ID(), Integer.parseInt(ctx.NUM().getText()));
    }

    @Override
    public void exitAssignArrayStat(GuavaParser.AssignArrayStatContext ctx) {
        if (!((Type.Array)variableType(ctx.ID())).getElemType().equals(getType(ctx.expr()))) {
            addError(ctx, "Expected type '%s' but found '%s'", ((Type.Array)variableType(ctx.ID())).getElemType(), getType(ctx.expr()));
        }

        int index = 0;
        if (ctx.NUM() != null) {
            index = Integer.parseInt(ctx.NUM().getText());
        } else {
            if (getType(ctx.expr()) != Type.INT) {
                addError(ctx, "Expected type '%s' but found '%s'", Type.INT, getType(ctx.expr()));
            }
        }

        if (index >= getArrayLengthVar(ctx.ID()) || index < 0) {
            addError(ctx, "Array index out of bounds for array '%s'. Array size is %s, requested index is %s", ctx.ID(), getArrayLengthVar(ctx.ID()), index);
        }

        setOffset(ctx.ID(), this.variables.offset(ctx.ID().getText()), false);
        setEntry(ctx, entry(ctx.expr()));
    }

    @Override
    public void enterIfStat(GuavaParser.IfStatContext ctx) {
        openScope();
    }

    @Override
    public void exitIfStat(GuavaParser.IfStatContext ctx) {
        if (getType(ctx.expr()) != Type.BOOL) {
            addError(ctx, "Expected type 'Bool' but found '%s'", getType(ctx.expr()));
        }

        setEntry(ctx, entry(ctx.expr()));
        closeScope();
    }

    @Override
    public void exitBlockStat(GuavaParser.BlockStatContext ctx) {
        if (ctx.stat(0) != null) {
            setEntry(ctx, entry(ctx.stat(0)));
        }
    }

    @Override
    public void enterWhileStat(GuavaParser.WhileStatContext ctx) {
        openScope();
    }

    @Override
    public void exitWhileStat(GuavaParser.WhileStatContext ctx) {
        if (getType(ctx.expr()) != Type.BOOL) {
            addError(ctx, "Expected type 'Bool' but found '%s'", getType(ctx.expr()));
        }

        setEntry(ctx, entry(ctx.expr()));
        closeScope();
    }

    @Override
    public void enterForStat(GuavaParser.ForStatContext ctx) {
        openScope();
    }

    @Override
    public void exitForStat(GuavaParser.ForStatContext ctx) {
        boolean errorFound = false;

        if (getType(ctx.forAss()) != Type.INT) {
            addError(ctx, "Expected type 'Integer' but found '%s'", getType(ctx.forAss()));
            errorFound = true;
        }

        if (getType(ctx.expr(0)) != Type.BOOL && !errorFound) {
            addError(ctx, "Expected type 'Bool' but found '%s'", getType(ctx.expr(0)));
            errorFound = true;
        }

        if (ctx.expr(1) != null) {
            if (getType(ctx.expr(1)) != Type.INT && !errorFound) {
                addError(ctx, "Expected type 'Integer' but found '%s'", getType(ctx.expr(1)));
            }
        } else {
            if (assigned(ctx.ID())) {
                if (variableType(ctx.ID()) != Type.INT && !errorFound) {
                    addError(ctx, "Expected type 'Integer' but found '%s'", getType(ctx.ID()));
                }
            } else {
                addError(ctx, "Variable '%s' has no value", ctx.ID());
            }

        }

        setEntry(ctx, ctx.forAss());
        closeScope();
    }

    @Override public void enterBranchStat(GuavaParser.BranchStatContext ctx) {
        checkerResult.setConc(true);
    }

    @Override public void enterLockStat(GuavaParser.LockStatContext ctx) {
        if (!checkerResult.isConc()) {
            addError(ctx, "Can't use locks in a sequential program.");
        } else {
            setOffset(ctx.ID(), this.variables.globalOffset(ctx.ID().getText()), true);
        }
        setEntry(ctx, ctx);
    }

    @Override
    public void exitPrfExpr(GuavaParser.PrfExprContext ctx) {
        Type type;

        if (ctx.prfOp().MINUS() != null) {
            if (isNumerical(ctx.expr())) {
                type = getType(ctx.expr());
            } else {
                addError(ctx, "'%s' has to be numerical", ctx.getText());
                type = Type.ERROR;
            }
        } else {
            if (getType(ctx.expr()) == Type.BOOL) {
                type = Type.BOOL;
            } else {
                addError(ctx, "Expected type '%s' but found '%s'", Type.BOOL, getType(ctx.expr()));
                type = Type.ERROR;
            }
        }

        checkType(ctx.expr(), type);
        setType(ctx, type);
        setEntry(ctx, entry(ctx.expr()));
    }

    @Override
    public void exitModExpr(GuavaParser.ModExprContext ctx) {
        Type type;

        if (getType(ctx.expr(0)) == Type.INT && getType(ctx.expr(1)) == Type.INT) {
            type = Type.INT;
        } else {
            addError(ctx, "Expected 'Integer' but found '%s' and '%s'", getType(ctx.expr(0)), getType(ctx.expr(1)));
            type = Type.ERROR;
        }

        setType(ctx, type);
        setEntry(ctx, entry(ctx.expr(0)));
    }

    @Override
    public void exitMultExpr(GuavaParser.MultExprContext ctx) {
        Type type;

        if (getType(ctx.expr(0)) == Type.INT && getType(ctx.expr(1)) == Type.INT) {
            type = Type.INT;
        } else if (getType(ctx.expr(0)) == Type.STR && getType(ctx.expr(1)) == Type.STR) {
            type = Type.STR;
        } else {
            addError(ctx, "'%s' and '%s' have to be numerical", ctx.expr(0).getText(), ctx.expr(1).getText());
            type = Type.ERROR;
        }

        setType(ctx, type);
        setEntry(ctx, entry(ctx.expr(0)));
    }

    @Override
    public void exitPlusExpr(GuavaParser.PlusExprContext ctx) {
        Type type;

        if (getType(ctx.expr(0)) == Type.INT && getType(ctx.expr(1)) == Type.INT) {
            type = Type.INT;
        } else {
            addError(ctx, "'%s' and '%s' have to be numerical", ctx.expr(0).getText(), ctx.expr(1).getText());
            type = Type.ERROR;
        }

        setType(ctx, type);
        setEntry(ctx, entry(ctx.expr(0)));
    }

    @Override
    public void exitBoolExpr(GuavaParser.BoolExprContext ctx) {
        checkType(ctx.expr(0), Type.BOOL);
        checkType(ctx.expr(1), Type.BOOL);
        setType(ctx, Type.BOOL);
        setEntry(ctx, entry(ctx.expr(0)));
    }

    @Override
    public void exitCompExpr(GuavaParser.CompExprContext ctx) {
        Type type;

        if (!(isNumerical(ctx.expr(0)) && isNumerical(ctx.expr(1)))) {
            addError(ctx, "'%s' and '%s' have to be numerical", ctx.expr(0).getText(), ctx.expr(1).getText());
            type = Type.ERROR;
        } else {
            type = Type.BOOL;
        }

        setType(ctx, type);
        setEntry(ctx, entry(ctx.expr(0)));
    }

    @Override
    public void exitParExpr(GuavaParser.ParExprContext ctx) {
        setType(ctx, getType(ctx.expr()));
        setEntry(ctx, entry(ctx.expr()));
    }

    @Override
    public void exitArrayExpr(GuavaParser.ArrayExprContext ctx) {
        Type type = getType(ctx.expr(0));

        if (ctx.expr().size() > getArrayLength(ctx)) {
            addError(ctx, "Expected array size '%s' but found '%s'", getArrayLength(ctx), ctx.expr().size());
        }

        for (int i = 0; i < ctx.expr().size(); i++) {
            if (!(getType(ctx.expr(i)).equals(type))) {
                addError(ctx, "Expected type '%s' but found '%s'", type, getType(ctx.expr(i)));
                type = Type.ERROR;
                break;
            }
        }

        type = new Type.Array(type);
        setType(ctx, type);
        setEntry(ctx, entry(ctx.expr(0)));
    }

    @Override
    public void exitConstExpr(GuavaParser.ConstExprContext ctx) {
        Type type;

        if (ctx.NUM() != null) {
            type = Type.INT;
        } else if (ctx.BOOL() != null) {
            type = Type.BOOL;
        } else if (ctx.CHAR() != null) {
            type = Type.CHAR;
        } else {
            addError(ctx, "Invalid expression '%s'", ctx.getText());
            type = Type.ERROR;
        }

        setType(ctx, type);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitGetArrayExpr(GuavaParser.GetArrayExprContext ctx) {
        int index = Integer.parseInt(ctx.NUM().getText());

        if (!assigned(ctx.ID())) {
            addError(ctx, "Variable '%s' has no value", ctx.ID());
        }

        if (index >= getArrayLengthVar(ctx.ID()) || index < 0) {
            addError(ctx, "Array index out of bounds for array '%s'. Array size is %s, requested index is %s", ctx.ID(), getArrayLengthVar(ctx.ID()), index);
        }

        setOffset(ctx.ID(), this.variables.offset(ctx.ID().getText()), false);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitIdExpr(GuavaParser.IdExprContext ctx) {
        String id = ctx.ID().getText();
        Type type;

        if (!assigned(ctx.ID())) {
            addError(ctx, "Variable '%s' has no value", ctx.ID());
        }

        type = variableType(ctx.ID());
        if (type == null) {
            addError(ctx, "Variable '%s' is not declared", id);
            type = Type.ERROR;
        }

        if (isShared(ctx.ID())) {
            setOffset(ctx.ID(), this.variables.globalOffset(ctx.ID().getText()), true);
            setShared(ctx.ID(), true);
        } else {
            setOffset(ctx.ID(), this.variables.offset(ctx.ID().getText()), false);

        }

        setType(ctx, type);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitForDecl(GuavaParser.ForDeclContext ctx) {
        Type type;

        if (getType(ctx.type()) != getType(ctx.expr())) {
            addError(ctx, "Expected type '%s' but found '%s'", getType(ctx.type()), getType(ctx.expr()));
            type = Type.ERROR;
        } else {
            type = getType(ctx.type());
        }

        setType(ctx, type);
        addNestedVariable(ctx.ID(), type, ctx);
        assign(ctx.ID());
        setEntry(ctx, ctx.expr());
    }

    @Override
    public void exitForExisting(GuavaParser.ForExistingContext ctx) {
        Type type;

        if (assigned(ctx.ID())) {
            if (contains(ctx.ID())) {
                type = variableType(ctx.ID());
            } else {
                addError(ctx, "Variable '%s' is not declared", ctx.ID().getText());
                type = Type.ERROR;
            }
        } else {
            addError(ctx, "Variable '%s' has no value", ctx.ID());
            type = Type.ERROR;
        }

        setType(ctx, type);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitIntType(GuavaParser.IntTypeContext ctx) {
        setType(ctx, Type.INT);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitBoolType(GuavaParser.BoolTypeContext ctx) {
        setType(ctx, Type.BOOL);
        setEntry(ctx, ctx);
    }

    @Override
    public void exitCharType(GuavaParser.CharTypeContext ctx) {
        setType(ctx, Type.CHAR);
        setEntry(ctx, ctx);
    }

    public boolean hasErrors() {
        return !getErrors().isEmpty();
    }

    public List<String> getErrors() {
        return this.errors;
    }

    private boolean isNumerical(ParserRuleContext node) {
        if (getType(node) == Type.INT) {
            return true;
        } else {
            return false;
        }
    }

    private boolean contains(ParseTree node) {
        return this.variables.contains(node.getText());
    }

    private Type variableType(ParseTree node) {
        Type type;
        if (!contains(node)) {
            type = Type.ERROR;
        } else {
            type = this.variables.getType(node.getText());
        }

        return type;
    }

    private void addVariableType(ParseTree node, Type type, ParserRuleContext ctx, boolean global) {
        if (!this.variables.add(node.getText(), type, global)) {
            addError(ctx, "Variable '%s' is already declared", node.getText());
        }
    }

    private void addNestedVariable(ParseTree node, Type type, ParserRuleContext ctx) {
        if (!this.variables.addLocal(node.getText(), type)) {
            addError(ctx, "Variable '%s' is already declared", node.getText());
        }
    }

    private void addArray(ParseTree node, Type type, ParserRuleContext ctx) {
        if(!this.variables.addArray(node.getText(), type, getArrayLengthVar(node))) {
            addError(ctx, "Variable '%s' is already declared", node.getText());
        }
    }

    private boolean assigned(ParseTree node) {
        return this.variables.isAssigned(node.getText());
    }

    private void assign(ParseTree node) {
        this.variables.assign(node.getText());
    }

    private void openScope() {
        this.variables.openScope();
    }

    private void closeScope() {
        this.variables.closeScope();
    }

    private void checkType(ParserRuleContext node, Type expected) {
        Type actual = getType(node);
        if (actual == null) {
            throw new IllegalArgumentException("Missing inferred type of "
                    + node.getText());
        }
        if (!actual.equals(expected)) {
            addError(node, "Expected type '%s' but found '%s'", expected,
                    actual);
        }
    }

    private void addError(ParserRuleContext node, String message,
                          Object... args) {
        addError(node.getStart(), message, args);
    }

    private void addError(Token token, String message, Object... args) {
        int line = token.getLine();
        int column = token.getCharPositionInLine();
        message = String.format(message, args);
        message = String.format("Line %d:%d - %s", line, column, message);
        this.errors.add(message);
    }

    private void setType(ParseTree node, Type type) {
        this.checkerResult.setType(node, type);
    }

    private Type getType(ParseTree node) {
        return this.checkerResult.getType(node);
    }

    private void setArrayLength(ParseTree node, int length) {
        this.arrayLength.put(node, length);
    }

    private int getArrayLength(ParseTree node) throws NullPointerException {
        return this.arrayLength.get(node);
    }

    private void setArrayLengthAsVar(ParseTree node, int length) {
        this.arrayLengthVars.put(node.getText(), length);
    }

    private int getArrayLengthVar(ParseTree node) throws NullPointerException {
        return this.arrayLengthVars.get(node.getText());
    }

    private void setOffset(ParseTree node, Integer offset, boolean global) {
        if (offset != null) {
            this.checkerResult.setOffset(node, offset, global);
        }
    }

    private void setEntry(ParseTree node, ParserRuleContext entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Null flow graph entry");
        }
        this.checkerResult.setEntry(node, entry);
    }

    private void setShared(ParseTree node, boolean shared) {
        this.checkerResult.setGlobalVar(node, shared);
        this.sharedVariables.add(node.getText());
    }

    private boolean isShared(ParseTree node) {
        return this.sharedVariables.contains(node.getText());
    }

    private ParserRuleContext entry(ParseTree node) {
        return this.checkerResult.getEntry(node);
    }
}
