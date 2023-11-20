package antlr4.kalkulator.parseTreeListener;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

import static antlr4.kalkulator.parseTreeListener.pTListenerParser.*;


public class EvalListener extends pTListenerBaseListener {

    private final ParseTreeProperty<Integer> values = new ParseTreeProperty<>();
    private final Map<String, Integer> memory = new HashMap<String, Integer>();

    public void setValue(ParseTree node, int value) {
        values.put(node, value);
    }
    public int getValue(ParseTree node) {
        return values.get(node);
    }

    @Override
    public void exitPrintExpr(pTListenerParser.PrintExprContext ctx) {
        Integer value = values.get(ctx.expr());
        if (value != null) {
            System.out.println(value);
        }
    }


    @Override
    public void exitIdstate(pTListenerParser.IdstateContext ctx) {
        String id = ctx.ID().getText();
        Integer value = memory.get(id);
        if (value != null) {
            values.put(ctx, value);
        }
    }


    @Override
    public void exitClear(pTListenerParser.ClearContext ctx) {
        memory.clear();
    }


    @Override
    public void exitParens(pTListenerParser.ParensContext ctx) {
        int value = values.get(ctx.expr());
        values.put(ctx, value);
    }


    @Override
    public void exitCompare(pTListenerParser.CompareContext ctx) {
        int left = values.get(ctx.expr(0));
        int right = values.get(ctx.expr(1));
        int value = switch (ctx.op.getType()) {
            case LESSTHAN -> left < right ? 0 : 1;
            case GREATERTHAN -> left > right ? 0 : 1;
            case EQUALS -> left == right ? 1 : 0;
            // Add more cases for other comparison operators if needed

            default -> throw new UnsupportedOperationException("Unsupported comparison operator: " + ctx.op.getText());
        };

        values.put(ctx, value);
    }


    @Override
    public void exitPotence(pTListenerParser.PotenceContext ctx) {
        int base = values.get(ctx.expr(0));
        int exponent = values.get(ctx.expr(1));
        int value = (int) Math.pow(base, exponent);
        values.put(ctx, value);
    }


    @Override
    public void exitConditionalExpr(pTListenerParser.ConditionalExprContext ctx) {
        int condition = values.get(ctx.expr(0));
        int trueExpr = values.get(ctx.expr(1));
        int falseExpr = values.get(ctx.expr(2));
        int value = (condition != 0) ? trueExpr : falseExpr;
        values.put(ctx, value);
    }

    @Override
    public void exitMulDiv(pTListenerParser.MulDivContext ctx) {
        int left = values.get(ctx.expr(0));
        int right = values.get(ctx.expr(1));
        int value;
        if (ctx.op.getType() == MUL) {
            value = left * right;
        } else {
            value = left / right;
        }
        values.put(ctx, value);
    }


    @Override
    public void exitAddSub(pTListenerParser.AddSubContext ctx) {
        int left = values.get(ctx.expr(0));
        int right = values.get(ctx.expr(1));
        int value;
        if (ctx.op.getType() == ADD) {
            value = left + right;
        } else {
            value = left - right;
        }
        values.put(ctx, value);
    }


    @Override
    public void exitId(pTListenerParser.IdContext ctx) {
        String id = ctx.ID().getText();
        int value = memory.getOrDefault(id, 0);
        values.put(ctx, value);
    }


    @Override
    public void exitInt(pTListenerParser.IntContext ctx) {
        int value = Integer.parseInt(ctx.INT().getText());
        values.put(ctx, value);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
    }

    @Override
    public void visitTerminal(TerminalNode node) {
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        throw new RuntimeException("Fehler beim Parsen: " + node.getText());
    }

}