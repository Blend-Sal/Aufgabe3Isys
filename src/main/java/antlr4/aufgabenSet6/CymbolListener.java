package antlr4.aufgabenSet6;
// Generated from Cymbol.g4 by ANTLR 4.13.1


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CymbolParser}.
 */
public interface CymbolListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CymbolParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(CymbolParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(CymbolParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#include}.
	 * @param ctx the parse tree
	 */
	void enterInclude(CymbolParser.IncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#include}.
	 * @param ctx the parse tree
	 */
	void exitInclude(CymbolParser.IncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(CymbolParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(CymbolParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(CymbolParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(CymbolParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(CymbolParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(CymbolParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(CymbolParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(CymbolParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CymbolParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CymbolParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#assignStat}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(CymbolParser.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#assignStat}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(CymbolParser.AssignStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(CymbolParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(CymbolParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#ifSingle}.
	 * @param ctx the parse tree
	 */
	void enterIfSingle(CymbolParser.IfSingleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#ifSingle}.
	 * @param ctx the parse tree
	 */
	void exitIfSingle(CymbolParser.IfSingleContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#ifElse}.
	 * @param ctx the parse tree
	 */
	void enterIfElse(CymbolParser.IfElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#ifElse}.
	 * @param ctx the parse tree
	 */
	void exitIfElse(CymbolParser.IfElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#forStat}.
	 * @param ctx the parse tree
	 */
	void enterForStat(CymbolParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#forStat}.
	 * @param ctx the parse tree
	 */
	void exitForStat(CymbolParser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(CymbolParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(CymbolParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(CymbolParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(CymbolParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(CymbolParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(CymbolParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#argsNone}.
	 * @param ctx the parse tree
	 */
	void enterArgsNone(CymbolParser.ArgsNoneContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#argsNone}.
	 * @param ctx the parse tree
	 */
	void exitArgsNone(CymbolParser.ArgsNoneContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#argsSingle}.
	 * @param ctx the parse tree
	 */
	void enterArgsSingle(CymbolParser.ArgsSingleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#argsSingle}.
	 * @param ctx the parse tree
	 */
	void exitArgsSingle(CymbolParser.ArgsSingleContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#argsMul}.
	 * @param ctx the parse tree
	 */
	void enterArgsMul(CymbolParser.ArgsMulContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#argsMul}.
	 * @param ctx the parse tree
	 */
	void exitArgsMul(CymbolParser.ArgsMulContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#printStat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(CymbolParser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#printStat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(CymbolParser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(CymbolParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(CymbolParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CymbolParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CymbolParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CymbolParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CymbolParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link CymbolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarRef(CymbolParser.VarRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link CymbolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarRef(CymbolParser.VarRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link CymbolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(CymbolParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link CymbolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(CymbolParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link CymbolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(CymbolParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link CymbolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(CymbolParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link CymbolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(CymbolParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link CymbolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(CymbolParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link CymbolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMinus(CymbolParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link CymbolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMinus(CymbolParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link CymbolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(CymbolParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link CymbolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(CymbolParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link CymbolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(CymbolParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link CymbolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(CymbolParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link CymbolParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void enterNot(CymbolParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link CymbolParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void exitNot(CymbolParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelOp}
	 * labeled alternative in {@link CymbolParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void enterRelOp(CymbolParser.RelOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelOp}
	 * labeled alternative in {@link CymbolParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void exitRelOp(CymbolParser.RelOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code True}
	 * labeled alternative in {@link CymbolParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void enterTrue(CymbolParser.TrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code True}
	 * labeled alternative in {@link CymbolParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void exitTrue(CymbolParser.TrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code False}
	 * labeled alternative in {@link CymbolParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void enterFalse(CymbolParser.FalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code False}
	 * labeled alternative in {@link CymbolParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void exitFalse(CymbolParser.FalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parentheses_Bool}
	 * labeled alternative in {@link CymbolParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void enterParentheses_Bool(CymbolParser.Parentheses_BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parentheses_Bool}
	 * labeled alternative in {@link CymbolParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void exitParentheses_Bool(CymbolParser.Parentheses_BoolContext ctx);
}