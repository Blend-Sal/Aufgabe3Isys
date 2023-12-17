package antlr4.aufgabenSet6;

import java.util.*;

public class FunctionSymbol extends Symbol implements Scope {
    Map<String, Symbol> orderedArgs = new LinkedHashMap<String, Symbol>();

    Scope enclosingScope;

    private int varIndex = 0;

    public FunctionSymbol(String name, Type retType, Scope enclosingScope) {
        super(name, retType);
        this.enclosingScope = enclosingScope;
    }

    @Override
    public Symbol resolve(String name) {
        Symbol s = orderedArgs.get(name);
        if (s != null) return s;
        if (getEnclosingScope() != null) {
            return getEnclosingScope().resolve(name);
        }
        return null;
    }

    @Override
    public void define(Symbol sym) {
        orderedArgs.put(sym.name, sym);
        sym.scope = this;
    }

    @Override
    public String getScopeName() {
        return this.enclosingScope.getScopeName();
    }

    @Override
    public Scope getEnclosingScope() {
        return enclosingScope;
    }

    @Override
    public String toString() {
        return "method" + super.toString() + ":" + orderedArgs.values();
    }

    public int getLocalVars() {
        return varIndex;
    }

    public int getOrderedArgs() {
        return orderedArgs.size();
    }

    public int nextVarIndex() {
        varIndex++;
        return varIndex;
    }

    public VariableSymbol newTempoVar() {
        return new VariableSymbol("temp", Type.tINT, nextVarIndex());
    }
}
