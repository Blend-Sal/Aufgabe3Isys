package antlr4.aufgabenSet6;
public class GlobalScope extends BaseScope {
    private int varIndex = 0;

    private int nextLabel = 0;

    public GlobalScope() {
        super(null);
    }

    public int nextVarIndex() {
        varIndex++;
        return varIndex;
    }

    public String nextLabel() {
        nextLabel++;
        return "l" + nextLabel;
    }

    public int getSymbols() {
        return symbols.size();
    }

    @Override
    public String getScopeName() {
        return "";
    }
}

