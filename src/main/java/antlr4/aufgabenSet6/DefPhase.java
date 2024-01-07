package antlr4.aufgabenSet6;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class DefPhase extends CymbolBaseListener {
    ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();

    GlobalScope globals;

    Scope currentScope; // define symbols in this scope

    FunctionSymbol currentFunction = null;

    public void enterFile(CymbolParser.FileContext ctx) {
        globals = new GlobalScope();
        currentScope = globals;
    }

    public void exitFile(CymbolParser.FileContext ctx) {
    }

    public void enterFunctionDecl(CymbolParser.FunctionDeclContext ctx) {
        String name = ctx.ID().getText();
        int typeTokenType = ctx.type().start.getType();
        Symbol.Type type = CymbolCompiler.getType(typeTokenType);

        // push new scope by making new one that points to enclosing scope
        FunctionSymbol function = new FunctionSymbol(name, type, currentScope);
        currentScope.define(function);  // Define function in current scope
        saveScope(ctx, function);       // Push: set function's parent to current
        currentScope = function;        // Current scope is now function scope
        currentFunction = function;
    }

    void saveScope(ParserRuleContext ctx, Scope s) { scopes.put(ctx, s); }

    public void exitFunctionDecl(CymbolParser.FunctionDeclContext ctx) {
        currentScope = currentScope.getEnclosingScope(); // pop scope
        currentFunction = null;
    }

    public void enterBlock(CymbolParser.BlockContext ctx) {
        // push new local scope
        currentScope = new LocalScope(currentScope);
        saveScope(ctx, currentScope);
    }

    public void exitBlock(CymbolParser.BlockContext ctx) {
        currentScope = currentScope.getEnclosingScope(); // pop scope
    }

    public void exitFormalParameter(CymbolParser.FormalParameterContext ctx) {
        defineVar(ctx.type(), ctx.ID().getSymbol());
    }

    public void exitVarDecl(CymbolParser.VarDeclContext ctx) {
        defineVar(ctx.type(), ctx.ID().getSymbol());
    }

    void defineVar(CymbolParser.TypeContext typeCtx, Token nameToken) {
        int typeTokenType = typeCtx.start.getType();
        Symbol.Type type = CymbolCompiler.getType(typeTokenType);
        VariableSymbol var;
        if (currentFunction == null) {
            var = new VariableSymbol(nameToken.getText(), type, globals.nextVarIndex());
        } else {
            var = new VariableSymbol(nameToken.getText(), type, currentFunction.nextVarIndex());
        }
        currentScope.define(var); // Define symbol in current scope
    }
}