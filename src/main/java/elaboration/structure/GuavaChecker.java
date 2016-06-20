package elaboration.structure;

import grammar.GuavaBaseListener;
import grammar.GuavaParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dion on 15-6-2016.
 */
public class GuavaChecker extends GuavaBaseListener {

    private CheckerResult checkerResult;
    private VariableScope variableScope;
    private ParseTreeProperty<Integer> arrayLength;
    private List<String> errors;

    public CheckerResult check(ParseTree tree) throws GuavaException {
        this.arrayLength = new ParseTreeProperty<>();
        this.variableScope = new VariableScope();
        this.checkerResult = new CheckerResult();
        this.errors = new ArrayList<>();
        new ParseTreeWalker().walk(this, tree);
        if (hasErrors()) {
            throw new GuavaException(getErrors());
        }
        return this.checkerResult;
    }

    @Override
    public void exitVarDeclStat(GuavaParser.VarDeclStatContext ctx) {
        setType(ctx.ID(), getType(ctx.type()));
        setEntry(ctx, entry(ctx.expr()));
        if (contains(ctx.ID())) {
            addError(ctx, "Variable '%s' is already declared", ctx.ID());
        } else {
            addVariable(ctx.ID(), getType(ctx.type()));
        }
    }

    @Override
    public void enterArrayDeclStat(GuavaParser.ArrayDeclStatContext ctx) {
        if (ctx.expr() != null) {
            setArrayLength(ctx.expr(), Integer.parseInt(ctx.NUM().getText()));
        } else {
            setArrayLength(ctx, Integer.parseInt(ctx.NUM().getText()));
        }
    }

    @Override
    public void exitArrayDeclStat(GuavaParser.ArrayDeclStatContext ctx) {
        Type.Array type = new Type.Array(getType(ctx.type()));
        Type.Array exprType = (Type.Array) getType(ctx.expr());

        if (ctx.expr() != null) {
            if (type.getElemType() == exprType.getElemType()) {
                setType(ctx.ID(), type);
            } else {
                addError(ctx, "Expected type '%s' but found '%s'", type, getType(ctx.expr()));
            }
        } else {
            setArrayLength(ctx, Integer.parseInt(ctx.NUM().getText()));
        }

        if (contains(ctx.ID())) {
            addError(ctx, "Variable '%s' is already declared", ctx.ID());
        } else {
            addVariable(ctx.ID(), getType(ctx.type()));
        }

        setEntry(ctx, entry(ctx.expr()));
    }

    @Override
    public void exitAssignStat(GuavaParser.AssignStatContext ctx) {
        if (variableType(ctx.ID()) != getType(ctx.expr())) {
            addError(ctx, "Expected type '%s' but found '%s'", getType(ctx.ID()), getType(ctx.expr()));
        }

        setEntry(ctx, entry(ctx.expr()));
    }

    @Override
    public void exitIfStat(GuavaParser.IfStatContext ctx) {
        if (getType(ctx.expr()) != Type.BOOL) {
            addError(ctx, "Expected type 'Bool' but found '%s'", getType(ctx.expr()));
        }

        setEntry(ctx, entry(ctx.expr()));
    }

    @Override
    public void exitBlockStat(GuavaParser.BlockStatContext ctx) {
        setEntry(ctx, entry(ctx.stat(0)));
    }

    @Override
    public void exitWhileStat(GuavaParser.WhileStatContext ctx) {
        if (getType(ctx.expr()) != Type.BOOL) {
            addError(ctx, "Expected type 'Bool' but found '%s'", getType(ctx.expr()));
        }

        setEntry(ctx, entry(ctx.expr()));
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
            if (variableType(ctx.ID()) != Type.INT && !errorFound) {
                addError(ctx, "Expected type 'Integer' but found '%s'", getType(ctx.ID()));
            }
        }

        setEntry(ctx, ctx.forAss());
    }

    @Override
    public void exitPrfExpr(GuavaParser.PrfExprContext ctx) {
        Type type;

        if (ctx.prfOp().MINUS() != null) {
            if (isNumerical(ctx.expr())) {
                type = getType(ctx.expr());
            } else {
                addError(ctx, "'%s' has to be numerical", ctx.getText());
                type = null;
            }
        } else {
            if (getType(ctx.expr()) == Type.BOOL) {
                type = Type.BOOL;
            } else {
                addError(ctx, "Expected type '%s' but found '%s'", Type.BOOL, getType(ctx.expr()));
                type = null;
            }
        }

        checkType(ctx.expr(), type);
        if (type != null) {
            setType(ctx, type);
        }
        setEntry(ctx, entry(ctx.expr()));
    }

    @Override
    public void exitMultExpr(GuavaParser.MultExprContext ctx) {
        Type type;

        if (getType(ctx.expr(0)) == Type.DOUBLE || getType(ctx.expr(1)) == Type.DOUBLE) {
            type = Type.DOUBLE;
        } else if (getType(ctx.expr(0)) == Type.INT && getType(ctx.expr(1)) == Type.INT) {
            type = Type.INT;
        } else if (getType(ctx.expr(0)) == Type.STR && getType(ctx.expr(1)) == Type.STR) {
            type = Type.STR;
        } else {
            addError(ctx, "'%s' and '%s' have to be numerical", ctx.expr(0).getText(), ctx.expr(1).getText());
            type = null;
        }

        if (type != null) {
            setType(ctx, type);
        }

        setEntry(ctx, entry(ctx.expr(0)));
    }

    @Override
    public void exitPlusExpr(GuavaParser.PlusExprContext ctx) {
        Type type;

        if (getType(ctx.expr(0)) == Type.DOUBLE || getType(ctx.expr(0)) == Type.DOUBLE) {
            type = Type.DOUBLE;
        } else if (getType(ctx.expr(0)) == Type.INT && getType(ctx.expr(0)) == Type.INT) {
            type = Type.INT;
        } else {
            addError(ctx, "'%s' and '%s' have to be numerical", ctx.expr(0).getText(), ctx.expr(1).getText());
            type = null;
        }

        if (type != null) {
            setType(ctx, type);
        }
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
            type = null;
        } else {
            type = Type.BOOL;
        }

        if (type != null) {
            setType(ctx, type);
        }

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

        if (ctx.expr().size() != getArrayLength(ctx)) {
            addError(ctx, "Expected array size '%s' but found '%s'", getArrayLength(ctx), ctx.expr().size());
        }

        for (int i = 0; i < ctx.expr().size(); i++) {
            if (!(getType(ctx.expr(i)) == type)) {
                addError(ctx, "Expected type '%s' but found '%s'", type, getType(ctx.expr(i)));
                type = getType(ctx.expr(i));
                break;
            }
        }

        if (type != null) {
            type = new Type.Array(type, ctx.expr());
            setType(ctx, type);
        }
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
        } else if (ctx.DEC() != null) {
            type = Type.DOUBLE;
        } else if (ctx.STR() != null) {
            type = Type.STR;
        } else {
            addError(ctx, "Invalid expression '%s'", ctx.getText());
            type = null;
        }

        if (type != null) {
            setType(ctx, type);
        }
        setEntry(ctx, ctx);
    }

    @Override
    public void exitIdExpr(GuavaParser.IdExprContext ctx) {
        String id = ctx.ID().getText();
        Type type = this.variableScope.type(id);
        if (type == null) {
            addError(ctx, "Variable '%s' not declared", id);
        } else {
            setType(ctx, type);
            setEntry(ctx, ctx);
        }
    }

    @Override
    public void exitForDecl(GuavaParser.ForDeclContext ctx) {
        Type type;

        if (getType(ctx.type()) != getType(ctx.expr())) {
            addError(ctx, "Expected type '%s' but found '%s'", getType(ctx.type()), getType(ctx.expr()));
            type = null;
        } else {
            type = getType(ctx.type());
        }

        if (type != null) {
            setType(ctx, type);
            this.variableScope.put(ctx.ID().getText(), type);
        }

        setEntry(ctx, ctx.expr());
    }

    @Override
    public void exitForExisting(GuavaParser.ForExistingContext ctx) {
        setType(ctx, this.variableScope.type(ctx.ID().getText()));
        setEntry(ctx, ctx);
    }

    @Override
    public void exitIntType(GuavaParser.IntTypeContext ctx) {
        setType(ctx, Type.INT);
    }

    @Override
    public void exitBoolType(GuavaParser.BoolTypeContext ctx) {
        setType(ctx, Type.BOOL);
    }

    @Override
    public void exitDoubleType(GuavaParser.DoubleTypeContext ctx) {
        setType(ctx, Type.DOUBLE);
    }

    @Override
    public void exitCharType(GuavaParser.CharTypeContext ctx) {
        setType(ctx, Type.CHAR);
    }

    @Override
    public void exitStringType(GuavaParser.StringTypeContext ctx) {
        setType(ctx, Type.STR);
    }


    public boolean hasErrors() {
        return !getErrors().isEmpty();
    }

    public List<String> getErrors() {
        return this.errors;
    }

    private boolean isNumerical(ParserRuleContext node) {
        if (getType(node) == Type.INT || getType(node) == Type.DOUBLE) {
            return true;
        } else {
            return false;
        }
    }

    private boolean contains(ParseTree node) {
        return this.variableScope.contains(node.getText());
    }

    private Type variableType(ParseTree node) {
        return this.variableScope.type(node.getText());
    }

    private void addVariable(ParseTree node, Type type) {
        this.variableScope.put(node.getText(), type);
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

    private int getArrayLength(ParseTree node) {
        return this.arrayLength.get(node);
    }

    private void setEntry(ParseTree node, ParserRuleContext entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Null flow graph entry");
        }
        this.checkerResult.setEntry(node, entry);
    }

    private ParserRuleContext entry(ParseTree node) {
        return this.checkerResult.getEntry(node);
    }
}
