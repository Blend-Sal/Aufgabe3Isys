// Generated from pTListener.g4 by ANTLR 4.13.1
package antlr4.kalkulator.parseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link pTListenerParser}.
 */
public interface pTListenerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link pTListenerParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(pTListenerParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link pTListenerParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(pTListenerParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link pTListenerParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(pTListenerParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link pTListenerParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(pTListenerParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idstate}
	 * labeled alternative in {@link pTListenerParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIdstate(pTListenerParser.IdstateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idstate}
	 * labeled alternative in {@link pTListenerParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIdstate(pTListenerParser.IdstateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code clear}
	 * labeled alternative in {@link pTListenerParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterClear(pTListenerParser.ClearContext ctx);
	/**
	 * Exit a parse tree produced by the {@code clear}
	 * labeled alternative in {@link pTListenerParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitClear(pTListenerParser.ClearContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link pTListenerParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlank(pTListenerParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link pTListenerParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlank(pTListenerParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link pTListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(pTListenerParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link pTListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(pTListenerParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compare}
	 * labeled alternative in {@link pTListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompare(pTListenerParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compare}
	 * labeled alternative in {@link pTListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompare(pTListenerParser.CompareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code potence}
	 * labeled alternative in {@link pTListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPotence(pTListenerParser.PotenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code potence}
	 * labeled alternative in {@link pTListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPotence(pTListenerParser.PotenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link pTListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(pTListenerParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link pTListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(pTListenerParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link pTListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(pTListenerParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link pTListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(pTListenerParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link pTListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(pTListenerParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link pTListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(pTListenerParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDiv}
	 * labeled alternative in {@link pTListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(pTListenerParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDiv}
	 * labeled alternative in {@link pTListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(pTListenerParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalExpr}
	 * labeled alternative in {@link pTListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpr(pTListenerParser.ConditionalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalExpr}
	 * labeled alternative in {@link pTListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpr(pTListenerParser.ConditionalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link pTListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign(pTListenerParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link pTListenerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign(pTListenerParser.AssignContext ctx);
}