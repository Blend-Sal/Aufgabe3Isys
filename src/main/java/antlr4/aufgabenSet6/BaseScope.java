package antlr4.aufgabenSet6;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseScope implements Scope {

    private Scope enclosingScope;
    Map<String, Symbol> symbols = new LinkedHashMap<>();

    BaseScope(Scope enclosingScope) { this.enclosingScope = enclosingScope;	}

    public Symbol resolve(String name) {
        Symbol s = symbols.get(name);
        if (s != null) return s;
        if (enclosingScope != null) return enclosingScope.resolve(name);
        return null;
    }

    public void define(Symbol sym) {
        symbols.put(sym.name, sym);
        sym.scope = this;
    }

    public Scope getEnclosingScope() {
        return enclosingScope;
    }

    public String toString() {
        return symbols.keySet().toString();
    }
}