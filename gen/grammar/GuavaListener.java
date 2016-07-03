// Generated from C:/Users/Jens/IdeaProjects/Guava/src/main/java/grammar\Guava.g4 by ANTLR 4.5.3
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GuavaParser}.
 */
public interface GuavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GuavaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GuavaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GuavaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GuavaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GuavaParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(GuavaParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GuavaParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(GuavaParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code globalDecl}
	 * labeled alternative in {@link GuavaParser#global}.
	 * @param ctx the parse tree
	 */
	void enterGlobalDecl(GuavaParser.GlobalDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code globalDecl}
	 * labeled alternative in {@link GuavaParser#global}.
	 * @param ctx the parse tree
	 */
	void exitGlobalDecl(GuavaParser.GlobalDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDeclStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclStat(GuavaParser.VarDeclStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDeclStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclStat(GuavaParser.VarDeclStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayDeclStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclStat(GuavaParser.ArrayDeclStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayDeclStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclStat(GuavaParser.ArrayDeclStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(GuavaParser.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(GuavaParser.AssignStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignArrayStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssignArrayStat(GuavaParser.AssignArrayStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignArrayStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssignArrayStat(GuavaParser.AssignArrayStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(GuavaParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(GuavaParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(GuavaParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(GuavaParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(GuavaParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(GuavaParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterForStat(GuavaParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitForStat(GuavaParser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code branchStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBranchStat(GuavaParser.BranchStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code branchStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBranchStat(GuavaParser.BranchStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lockStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterLockStat(GuavaParser.LockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lockStat}
	 * labeled alternative in {@link GuavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitLockStat(GuavaParser.LockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code getArrayExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGetArrayExpr(GuavaParser.GetArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code getArrayExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGetArrayExpr(GuavaParser.GetArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(GuavaParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(GuavaParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(GuavaParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(GuavaParser.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(GuavaParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(GuavaParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prfExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPrfExpr(GuavaParser.PrfExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prfExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPrfExpr(GuavaParser.PrfExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(GuavaParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(GuavaParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(GuavaParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(GuavaParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlusExpr(GuavaParser.PlusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlusExpr(GuavaParser.PlusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstExpr(GuavaParser.ConstExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstExpr(GuavaParser.ConstExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(GuavaParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link GuavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(GuavaParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forDecl}
	 * labeled alternative in {@link GuavaParser#forAss}.
	 * @param ctx the parse tree
	 */
	void enterForDecl(GuavaParser.ForDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forDecl}
	 * labeled alternative in {@link GuavaParser#forAss}.
	 * @param ctx the parse tree
	 */
	void exitForDecl(GuavaParser.ForDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forExisting}
	 * labeled alternative in {@link GuavaParser#forAss}.
	 * @param ctx the parse tree
	 */
	void enterForExisting(GuavaParser.ForExistingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forExisting}
	 * labeled alternative in {@link GuavaParser#forAss}.
	 * @param ctx the parse tree
	 */
	void exitForExisting(GuavaParser.ForExistingContext ctx);
	/**
	 * Enter a parse tree produced by {@link GuavaParser#prfOp}.
	 * @param ctx the parse tree
	 */
	void enterPrfOp(GuavaParser.PrfOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link GuavaParser#prfOp}.
	 * @param ctx the parse tree
	 */
	void exitPrfOp(GuavaParser.PrfOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link GuavaParser#multOp}.
	 * @param ctx the parse tree
	 */
	void enterMultOp(GuavaParser.MultOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link GuavaParser#multOp}.
	 * @param ctx the parse tree
	 */
	void exitMultOp(GuavaParser.MultOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link GuavaParser#plusOp}.
	 * @param ctx the parse tree
	 */
	void enterPlusOp(GuavaParser.PlusOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link GuavaParser#plusOp}.
	 * @param ctx the parse tree
	 */
	void exitPlusOp(GuavaParser.PlusOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link GuavaParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void enterBoolOp(GuavaParser.BoolOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link GuavaParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void exitBoolOp(GuavaParser.BoolOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link GuavaParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(GuavaParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link GuavaParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(GuavaParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link GuavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntType(GuavaParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link GuavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntType(GuavaParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link GuavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(GuavaParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link GuavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(GuavaParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charType}
	 * labeled alternative in {@link GuavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterCharType(GuavaParser.CharTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charType}
	 * labeled alternative in {@link GuavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitCharType(GuavaParser.CharTypeContext ctx);
}