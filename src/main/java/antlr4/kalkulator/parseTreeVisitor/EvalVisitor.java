package antlr4.kalkulator.parseTreeVisitor;
/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/

import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends LabeledExprBaseVisitor<Integer> {
    /** "memory" for our calculator; variable/value pairs go here */
    Map<String, Integer> memory = new HashMap<String, Integer>();

    /** ID '=' expr NEWLINE */

    /** expr NEWLINE */
    @Override
    public Integer visitPrintExpr(LabeledExprParser.PrintExprContext ctx) {
        Integer value = visit(ctx.expr()); // evaluate the expr child
        System.out.println(value);         // print the result
        return 0;                          // return dummy value
    }

    /** INT */
    @Override
    public Integer visitInt(LabeledExprParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    /** ID */

    /** expr op=('*'|'/') expr */
    @Override
    public Integer visitMulDiv(LabeledExprParser.MulDivContext ctx) {
        int left = visit(ctx.expr(0));  // get value of left subexpression
        int right = visit(ctx.expr(1)); // get value of right subexpression
        if ( ctx.op.getType() == LabeledExprParser.MUL ) return left * right;
        return left / right; // must be DIV
    }

    /** expr op=('+'|'-') expr */
    @Override
    public Integer visitAddSub(LabeledExprParser.AddSubContext ctx) {
        int left = visit(ctx.expr(0));  // get value of left subexpression
        int right = visit(ctx.expr(1)); // get value of right subexpression
        if ( ctx.op.getType() == LabeledExprParser.ADD ) return left + right;
        return left - right; // must be SUB
    }

    /** '(' expr ')' */
    @Override
    public Integer visitParens(LabeledExprParser.ParensContext ctx) {
        return visit(ctx.expr()); // return child expr's value
    }

    @Override
    public Integer visitExponentiation(LabeledExprParser.ExponentiationContext ctx) {
        int left = visit(ctx.expr(0)); // get value of left subexpression
        int right = visit(ctx.expr(1)); // get value of right subexpression
        return (int) Math.pow(left, right); // calculate the power
    }

    @Override
    public Integer visitCompare(LabeledExprParser.CompareContext ctx) {
        int left = visit(ctx.expr(0)); // get value of left subexpression
        int right = visit(ctx.expr(1)); // get value of right subexpression
        if (ctx.op.getType() == LabeledExprParser.EQUAL) return left == right ? 1 : 0;
        if (ctx.op.getType() == LabeledExprParser.LESS) return left < right ? 1 : 0;
        return left > right ? 1 : 0; // must be GREATER
    }

    @Override
    public Integer visitConditional(LabeledExprParser.ConditionalContext ctx) {
        int condition = visit(ctx.expr(0)); // get value of condition
        int trueCase = visit(ctx.expr(1)); // get value of true case
        int falseCase = visit(ctx.expr(2)); // get value of false case
        return condition != 0 ? trueCase : falseCase; // return true case if condition is true, else false case
    }

    @Override
    public Integer visitAssign(LabeledExprParser.AssignContext ctx) {
        String varName = ctx.ID().getText(); // get the variable name
        int value = visit(ctx.expr());       // get the value of the expression
        memory.put(varName, value);          // assign the value to the variable
        return value;
    }

    @Override
    public Integer visitIfElse(LabeledExprParser.IfElseContext ctx) {

        boolean condition = visit(ctx.expr()) > 0;
        boolean elseConExists = ctx.ELSE() != null;

        return condition ? visit(ctx.stat(0)) : !elseConExists ? 0 : visit(ctx.stat(1));
    }


}
