package antlr4.aufgabenSet6;
public interface Scope {

    String getScopeName();

    Scope getEnclosingScope();

    void define(Symbol sym);

    Symbol resolve(String name);

}
