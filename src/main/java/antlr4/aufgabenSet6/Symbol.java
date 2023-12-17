package antlr4.aufgabenSet6;

public class Symbol {
    String name;

    Type type;

    public Scope scope;

    public Symbol(String name) {
        this.name = name;
    }

    public Symbol(String name, Type type) {
        this(name);
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Scope getScope() {
        return scope;
    }
    @Override
    public String toString() {
        if (type != null) return '<' + getName() + ":" + type + '>';
        return getName();
    }

    public boolean isGlobal() {
        return scope.getEnclosingScope() == null;
    }

    public enum Type {
        tVOID, tINT, tFLOAT, tINVALID
    }
}