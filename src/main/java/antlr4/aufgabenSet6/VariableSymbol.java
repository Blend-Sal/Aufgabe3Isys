package antlr4.aufgabenSet6;

public class VariableSymbol extends Symbol {
    public final int index;

    public VariableSymbol(String name, Type type, int index) {
        super(name, type);
        this.index = index;
    }
}
