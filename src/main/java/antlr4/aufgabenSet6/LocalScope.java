package antlr4.aufgabenSet6;
public class LocalScope extends BaseScope {

    public LocalScope(Scope parent) {
        super(parent);
    }

    public String getScopeName() {
        return "local";
    }


}

