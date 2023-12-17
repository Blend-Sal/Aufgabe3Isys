package antlr4.aufgabenSet6;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.List;

public class RefPhase extends CymbolBaseListener {
    ParseTreeProperty<Scope> scopes;

    GlobalScope globals;

    Scope currentScope;

    FunctionSymbol currentFunction = null;

    ParseTreeProperty<ST> templateTree;

    STGroup stg;

    public RefPhase(GlobalScope globals, ParseTreeProperty<Scope> scopes) {
        this.scopes = scopes;
        this.templateTree = new ParseTreeProperty<>();
        this.globals = globals;
        this.stg = new STGroupFile("src/main/java/antlr4/aufgabenSet6/compiler.stg");
    }

    public void addTemplateChild(ParseTree ctx, ParseTree ctxChild) {
        templateTree.put(ctx, templateTree.get(ctxChild));
    }

    @Override
    public void enterFile(CymbolParser.FileContext ctx) {
        currentScope = globals;
    }

    @Override
    public void exitFile(CymbolParser.FileContext ctx) {
        ST t = stg.getInstanceOf("file").add("globals", globals.getSymbols());
        for (int i = 0; i < ctx.functionDecl().size(); i++)
            t.add("functionDecl", templateTree.get(ctx.functionDecl(i)));
        templateTree.put(ctx, t);
    }

    @Override
    public void enterFunctionDecl(CymbolParser.FunctionDeclContext ctx) {
        currentScope = scopes.get(ctx);
        currentFunction = (FunctionSymbol) scopes.get(ctx);
    }

    @Override
    public void exitFunctionDecl(CymbolParser.FunctionDeclContext ctx) {
        String name = ctx.ID().getSymbol().getText();
        FunctionSymbol fun = (FunctionSymbol) currentScope.resolve(name);
        templateTree.put(ctx, stg.getInstanceOf("functionDecl")
                .add("id", name)
                .add("args", fun.getOrderedArgs())
                .add("locals", fun.getLocalVars())
                .add("block", templateTree.get(ctx.block())));
        currentScope = currentScope.getEnclosingScope();
        currentFunction = null;
    }

    @Override
    public void exitStat(CymbolParser.StatContext ctx) {
        addTemplateChild(ctx, ctx.children.get(0));
    }

    @Override
    public void enterBlock(CymbolParser.BlockContext ctx) {
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitBlock(CymbolParser.BlockContext ctx) {
        currentScope = currentScope.getEnclosingScope();
        ST t = stg.getInstanceOf("block");
        for (int i = 0; i < ctx.stat().size(); i++)
            t.add("stat", templateTree.get(ctx.stat(i)));
        templateTree.put(ctx, t);
    }

    @Override
    public void exitAssignStat(CymbolParser.AssignStatContext ctx) {
        ST t;
        if (currentScope.resolve(ctx.ID().getText()).isGlobal()) t = stg.getInstanceOf("assign");
        else t = stg.getInstanceOf("localVar");
        templateTree.put(ctx, t
                .add("var", currentScope.resolve(ctx.ID().getText()))
                .add("expr", templateTree.get(ctx.expr())));
    }

    @Override
    public void exitIfStat(CymbolParser.IfStatContext ctx) {
        addTemplateChild(ctx, ctx.children.get(0));
    }

    @Override
    public void exitIfSingle(CymbolParser.IfSingleContext ctx) {
        templateTree.put(ctx, stg.getInstanceOf("ifSingle")
                .add("bexpr", templateTree.get(ctx.bexpr()))
                .add("stat", templateTree.get(ctx.stat())));
    }

    @Override
    public void exitIfElse(CymbolParser.IfElseContext ctx) {
        templateTree.put(ctx, stg.getInstanceOf("ifElse")
                .add("bexpr", templateTree.get(ctx.bexpr()))
                .add("next", globals.nextLabel())
                .add("statTrue", templateTree.get(ctx.stat(0)))
                .add("statFalse", templateTree.get(ctx.stat(1))));
    }

    @Override
    public void exitForStat(CymbolParser.ForStatContext ctx) {
        templateTree.put(ctx, stg.getInstanceOf("for")
                .add("bexpr", templateTree.get(ctx.bexpr()))
                .add("begin", globals.nextLabel())
                .add("assignInit", templateTree.get(ctx.assignStat(0)))
                .add("assignNext", templateTree.get(ctx.assignStat(1)))
                .add("stat", templateTree.get(ctx.stat())));
    }

    @Override
    public void exitWhileStat(CymbolParser.WhileStatContext ctx) {
        templateTree.put(ctx, stg.getInstanceOf("while")
                .add("bexpr", templateTree.get(ctx.bexpr()))
                .add("begin", globals.nextLabel())
                .add("stat", templateTree.get(ctx.stat())));
    }

    @Override
    public void exitReturnStat(CymbolParser.ReturnStatContext ctx) {
        templateTree.put(ctx, stg.getInstanceOf("return")
                .add("expr", templateTree.get(ctx.expr()))
                .add("index", 0));
    }

    @Override
    public void exitArgs(CymbolParser.ArgsContext ctx) {
        addTemplateChild(ctx, ctx.children.get(0));
    }

    @Override
    public void exitArgsNone(CymbolParser.ArgsNoneContext ctx) {
        templateTree.put(ctx, stg.getInstanceOf("argsNone")
                .add("addr", new VariableSymbol("ret", Symbol.Type.tINT, 0)));
    }

    @Override
    public void exitArgsSingle(CymbolParser.ArgsSingleContext ctx) {
        ST t = templateTree.get(ctx.expr());
        templateTree.put(ctx, stg.getInstanceOf("argsSingle")
                .add("expr", t)
                .add("addr", t.getAttribute("addr")));
    }

    @Override
    public void exitArgsMul(CymbolParser.ArgsMulContext ctx) {
        List<CymbolParser.ExprContext> list = ctx.expr();
        VariableSymbol tempo = currentFunction.newTempoVar();
        ST t = stg.getInstanceOf("args")
                .add("expr", templateTree.get(list.get(0)))
                .add("tempo", tempo)
                .add("addr", tempo);
        for (int i = 1; i < list.size(); i++) {
            t.add("expr", templateTree.get(list.get(i))).add("tempo", currentFunction.newTempoVar());
        }
        templateTree.put(ctx, t);
    }

    @Override
    public void exitPrintStat(CymbolParser.PrintStatContext ctx) {
        templateTree.put(ctx, stg.getInstanceOf("print")
                .add("expr", templateTree.get(ctx.expr())));
    }

    @Override
    public void exitMinus(CymbolParser.MinusContext ctx) {
        ST t = stg.getInstanceOf("int")
                .add("intValue", 0)
                .add("addr", currentFunction.newTempoVar());
        templateTree.put(ctx, stg.getInstanceOf("sub")
                .add("lexpr", t)
                .add("rexpr", templateTree.get(ctx.expr()))
                .add("addr", currentFunction.newTempoVar()));
    }

    @Override
    public void exitMulDiv(CymbolParser.MulDivContext ctx) {
        ST e1 = templateTree.get(ctx.expr(0));
        ST e2 = templateTree.get(ctx.expr(1));
        templateTree.put(ctx, stg.getInstanceOf("mulDiv")
                .add("lexpr", e1)
                .add("rexpr", e2)
                .add("addr", currentFunction.newTempoVar()));
    }

    @Override
    public void exitAddSub(CymbolParser.AddSubContext ctx) {
        ST e1 = templateTree.get(ctx.expr(0));
        ST e2 = templateTree.get(ctx.expr(1));
        if (ctx.op.getText().equals("+")) templateTree.put(ctx, stg.getInstanceOf("add")
                .add("lexpr", e1)
                .add("rexpr", e2)
                .add("addr", currentFunction.newTempoVar()));
        else templateTree.put(ctx, stg.getInstanceOf("sub")
                .add("lexpr", e1)
                .add("rexpr", e2)
                .add("addr", currentFunction.newTempoVar()));
    }

    @Override
    public void exitVarRef(CymbolParser.VarRefContext ctx) {
        String name = ctx.ID().getSymbol().getText();
        Symbol var = currentScope.resolve(name);
        if (var == null) {
            CymbolCompiler.error(ctx.ID().getSymbol(), "no such variable: " + name);
        } else {
            if (var.isGlobal()) templateTree.put(ctx, stg.getInstanceOf("varRef")
                    .add("var", var)
                    .add("addr", currentFunction.newTempoVar()));
            else templateTree.put(ctx, stg.getInstanceOf("localVarRef")
                    .add("var", var)
                    .add("addr", var));
        }
        if (var instanceof FunctionSymbol) {
            CymbolCompiler.error(ctx.ID().getSymbol(), name + " is not a variable");
        }
    }

    @Override
    public void exitInt(CymbolParser.IntContext ctx) {
        templateTree.put(ctx, stg.getInstanceOf("int")
                .add("intValue", ctx.INT().getText())
                .add("addr", currentFunction.newTempoVar()));
    }

    @Override
    public void exitParentheses(CymbolParser.ParenthesesContext ctx) {
        addTemplateChild(ctx, ctx.expr());
    }

    @Override
    public void exitFunctionCall(CymbolParser.FunctionCallContext ctx) {
        String funcName = ctx.ID().getText();
        Symbol meth = currentScope.resolve(funcName);
        templateTree.put(ctx, stg.getInstanceOf("functionCall")
                .add("function", meth)
                .add("args", templateTree.get(ctx.args()))
                .add("addr", currentFunction.newTempoVar()));
        if (meth == null) {
            CymbolCompiler.error(ctx.ID().getSymbol(), "no such function: " + funcName);
        }
        if (meth instanceof VariableSymbol) {
            CymbolCompiler.error(ctx.ID().getSymbol(), funcName + " is not a function");
        }
    }

    @Override
    public void exitNot(CymbolParser.NotContext ctx) {
        templateTree.put(ctx, stg.getInstanceOf("not")
                .add("bexpr", templateTree.get(ctx.bexpr()))
                .add("trueLabel", templateTree.get(ctx.bexpr()).getAttribute("falseLabel"))
                .add("falseLabel", templateTree.get(ctx.bexpr()).getAttribute("trueLabel")));
    }

    @Override
    public void exitRelOp(CymbolParser.RelOpContext ctx) {
        switch (ctx.op.getText()) {
            case "==" -> templateTree.put(ctx, stg.getInstanceOf("equals")
                    .add("lexpr", templateTree.get(ctx.expr(0)))
                    .add("rexpr", templateTree.get(ctx.expr(1)))
                    .add("trueLabel", globals.nextLabel())
                    .add("falseLabel", globals.nextLabel())
                    .add("addr", currentFunction.newTempoVar()));
            case "!=" -> templateTree.put(ctx, stg.getInstanceOf("notEquals")
                    .add("lexpr", templateTree.get(ctx.expr(0)))
                    .add("rexpr", templateTree.get(ctx.expr(1)))
                    .add("trueLabel", globals.nextLabel())
                    .add("falseLabel", globals.nextLabel())
                    .add("addr", currentFunction.newTempoVar()));
            case "<" -> templateTree.put(ctx, stg.getInstanceOf("less")
                    .add("lexpr", templateTree.get(ctx.expr(0)))
                    .add("rexpr", templateTree.get(ctx.expr(1)))
                    .add("trueLabel", globals.nextLabel())
                    .add("falseLabel", globals.nextLabel())
                    .add("addr", currentFunction.newTempoVar()));
            default -> templateTree.put(ctx, stg.getInstanceOf("greater")
                    .add("lexpr", templateTree.get(ctx.expr(0)))
                    .add("rexpr", templateTree.get(ctx.expr(1)))
                    .add("trueLabel", globals.nextLabel())
                    .add("falseLabel", globals.nextLabel())
                    .add("addr", currentFunction.newTempoVar()));
        }
    }

    @Override
    public void exitTrue(CymbolParser.TrueContext ctx) {
        templateTree.put(ctx, stg.getInstanceOf("trueBoolean")
                .add("trueLabel", globals.nextLabel())
                .add("falseLabel", globals.nextLabel()));
    }

    @Override
    public void exitFalse(CymbolParser.FalseContext ctx) {
        templateTree.put(ctx, stg.getInstanceOf("falseBoolean")
                .add("trueLabel", globals.nextLabel())
                .add("falseLabel", globals.nextLabel()));
    }

    @Override
    public void exitParentheses_Bool(CymbolParser.Parentheses_BoolContext ctx) {
        addTemplateChild(ctx, ctx.bexpr());
    }

    public ParseTreeProperty<ST> getTemplateTree() {
        return templateTree;
    }
}

