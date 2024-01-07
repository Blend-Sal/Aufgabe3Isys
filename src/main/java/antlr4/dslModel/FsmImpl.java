package antlr4.dslModel;// BEGIN ...
import antlr4.dslModel.Fsm;

import java.util.HashMap;
// END ...
public class FsmImpl implements Fsm {
    private String initial; // the initial state
    private String current; // the "current" state
    // A cascaded map for maintaining states and transitions
    private HashMap<String, HashMap<String, String>> fsm =
            new HashMap<>();

    private final HashMap<String, Boolean> accept = new HashMap<>();
    private FsmImpl() { }
    // Construct FSM object
    public static Fsm fsm() { return new FsmImpl(); }
    // Add state and set it as current state

    public Fsm addState(String id, Boolean accept) throws FsmlException {
        // First state is initial state
        if (initial == null) initial = id;
        // Remember state for subsequent transitions
        this.current = id;
        if (fsm.containsKey(id)) throw new FsmlDistinctIdsException();
        fsm.put(id, new HashMap<String, String>());
        this.accept.put(id, accept);
        return this;
    }
    // Add transition for current state
    public Fsm addTransition(String event, String target) {
        if (fsm.get(current).containsKey(event)) throw new FsmlDeterministismException();
        fsm.get(current).put(event, target);
        return this;
    }
    // Getter for initial state
    public String getInitial() {
        return initial;
    }
    // Make transition
    public String makeTransition(String state, String event) {
        if (!fsm.containsKey(state)) throw new FsmlResolutionException();
        if (!fsm.get(state).containsKey(event)) throw new FsmlInfeasibleEventException();
        return fsm.get(state).get(event);
    }

    @Override
    public Boolean accept(String state) {
        return accept.get(state);
    }
}