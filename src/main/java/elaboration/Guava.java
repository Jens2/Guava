package elaboration;

import grammar.GuavaBaseVisitor;
import grammar.GuavaParser;

/**
 * Created by Jens on 14-6-2016.
 *
 */
public class Guava extends GuavaBaseVisitor {

    /** Start of the program. */
    @Override
    public Object visitProgram(GuavaParser.ProgramContext ctx) {
        return super.visitProgram(ctx);
    }

    /** Body of the program. */
    @Override
    public Object visitBody(GuavaParser.BodyContext ctx) {
        return super.visitBody(ctx);
    }

    /** All statements in the program.*/
    @Override
    public Object visitBlockStat(GuavaParser.BlockStatContext ctx) {
        return super.visitBlockStat(ctx);
    }

    @Override
    public Object visitDeclStat(GuavaParser.DeclStatContext ctx) {
        return super.visitDeclStat(ctx);
    }

    @Override
    public Object visitAssignStat(GuavaParser.AssignStatContext ctx) {
        return super.visitAssignStat(ctx);
    }

    @Override
    public Object visitIfStat(GuavaParser.IfStatContext ctx) {
        return super.visitIfStat(ctx);
    }

    @Override
    public Object visitWhileStat(GuavaParser.WhileStatContext ctx) {
        return super.visitWhileStat(ctx);
    }

    @Override
    public Object visitForStat(GuavaParser.ForStatContext ctx) {
        return super.visitForStat(ctx);
    }

    @Override
    public Object visitUpdateStat(GuavaParser.UpdateStatContext ctx) {
        return super.visitUpdateStat(ctx);
    }

    /** All boolean expressions. */
    @Override
    public Object visitEqExpr(GuavaParser.EqExprContext ctx) {
        return super.visitEqExpr(ctx);
    }

    @Override
    public Object visitGtExpr(GuavaParser.GtExprContext ctx) {
        return super.visitGtExpr(ctx);
    }

    @Override
    public Object visitGeExpr(GuavaParser.GeExprContext ctx) {
        return super.visitGeExpr(ctx);
    }

    @Override
    public Object visitLtExpr(GuavaParser.LtExprContext ctx) {
        return super.visitLtExpr(ctx);
    }

    @Override
    public Object visitLeExpr(GuavaParser.LeExprContext ctx) {
        return super.visitLeExpr(ctx);
    }

    @Override
    public Object visitNeExpr(GuavaParser.NeExprContext ctx) {
        return super.visitNeExpr(ctx);
    }

    @Override
    public Object visitAndExpr(GuavaParser.AndExprContext ctx) {
        return super.visitAndExpr(ctx);
    }

    @Override
    public Object visitOrExpr(GuavaParser.OrExprContext ctx) {
        return super.visitOrExpr(ctx);
    }

    @Override
    public Object visitNotExpr(GuavaParser.NotExprContext ctx) {
        return super.visitNotExpr(ctx);
    }

    /** All arithmetic expressions. */
    @Override
    public Object visitAddExpr(GuavaParser.AddExprContext ctx) {
        return super.visitAddExpr(ctx);
    }

    @Override
    public Object visitMinusExpr(GuavaParser.MinusExprContext ctx) {
        return super.visitMinusExpr(ctx);
    }

    @Override
    public Object visitMultExpr(GuavaParser.MultExprContext ctx) {
        return super.visitMultExpr(ctx);
    }

    @Override
    public Object visitDivExpr(GuavaParser.DivExprContext ctx) {
        return super.visitDivExpr(ctx);
    }

    @Override
    public Object visitPowExpr(GuavaParser.PowExprContext ctx) {
        return super.visitPowExpr(ctx);
    }

    /** Expression within parentheses. */
    @Override
    public Object visitParExpr(GuavaParser.ParExprContext ctx) {
        return super.visitParExpr(ctx);
    }

    /** Expressions for constants and variables.*/
    @Override
    public Object visitConstExpr(GuavaParser.ConstExprContext ctx) {
        return super.visitConstExpr(ctx);
    }

    @Override
    public Object visitIdExpr(GuavaParser.IdExprContext ctx) {
        return super.visitIdExpr(ctx);
    }

    /** Body of the for statement. */
    @Override
    public Object visitForAssign(GuavaParser.ForAssignContext ctx) {
        return super.visitForAssign(ctx);
    }

    @Override
    public Object visitForVar(GuavaParser.ForVarContext ctx) {
        return super.visitForVar(ctx);
    }

    /** Increment and decrement a variable. */
    @Override
    public Object visitIncrVar(GuavaParser.IncrVarContext ctx) {
        return super.visitIncrVar(ctx);
    }

    @Override
    public Object visitDecrVar(GuavaParser.DecrVarContext ctx) {
        return super.visitDecrVar(ctx);
    }

    /** Variables and types. */
    @Override
    public Object visitVar(GuavaParser.VarContext ctx) {
        return super.visitVar(ctx);
    }

    @Override
    public Object visitType(GuavaParser.TypeContext ctx) {
        return super.visitType(ctx);
    }
}
