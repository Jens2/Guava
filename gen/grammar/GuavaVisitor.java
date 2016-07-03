// Generated from C:/Users/Jens/IdeaProjects/Guava/src/main/java/grammar\Guava.g4 by ANTLR 4.5.3
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GuavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GuavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GuavaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GuavaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GuavaParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(GuavaParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code globalDecl}
	 * labeled alternative in {@link GuavaParser#global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalDecl(GuavaParser.GlobalDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclStat(GuavaParser.VarDeclStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayDeclStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclStat(GuavaParser.ArrayDeclStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStat(GuavaParser.AssignStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignArrayStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignArrayStat(GuavaParser.AssignArrayStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(GuavaParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStat(GuavaParser.BlockStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(GuavaParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStat(GuavaParser.ForStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code branchStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchStat(GuavaParser.BranchStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lockStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockStat(GuavaParser.LockStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code getArrayExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetArrayExpr(GuavaParser.GetArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(GuavaParser.ParExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(GuavaParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpr(GuavaParser.CompExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prfExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrfExpr(GuavaParser.PrfExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(GuavaParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(GuavaParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExpr(GuavaParser.PlusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExpr(GuavaParser.ConstExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(GuavaParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forDecl}
	 * labeled alternative in {@link GuavaParser#forAss}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForDecl(GuavaParser.ForDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forExisting}
	 * labeled alternative in {@link GuavaParser#forAss}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForExisting(GuavaParser.ForExistingContext ctx);
	/**
	 * Visit a parse tree produced by {@link GuavaParser#prfOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrfOp(GuavaParser.PrfOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link GuavaParser#multOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultOp(GuavaParser.MultOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link GuavaParser#plusOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusOp(GuavaParser.PlusOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link GuavaParser#boolOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOp(GuavaParser.BoolOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link GuavaParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(GuavaParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link GuavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(GuavaParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link GuavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(GuavaParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charType}
	 * labeled alternative in {@link GuavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharType(GuavaParser.CharTypeContext ctx);
}