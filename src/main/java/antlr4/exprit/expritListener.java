package antlr4.exprit;

// Generated from exprit.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link expritParser}.
 */
public interface expritListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link expritParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(expritParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link expritParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(expritParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link expritParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(expritParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link expritParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(expritParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link expritParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(expritParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link expritParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(expritParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link expritParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(expritParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link expritParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(expritParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link expritParser#fact}.
	 * @param ctx the parse tree
	 */
	void enterFact(expritParser.FactContext ctx);
	/**
	 * Exit a parse tree produced by {@link expritParser#fact}.
	 * @param ctx the parse tree
	 */
	void exitFact(expritParser.FactContext ctx);
}