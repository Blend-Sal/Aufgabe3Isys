package antlr4.dslModel;

public class FsmlInterpreter {
    public static Boolean run(Fsm fsm, String[] input) {
        String state = fsm.getInitial();
        for (String event : input) {
            try {
                state = fsm.makeTransition(state, event);
            } catch (FsmlInfeasibleEventException e) {
                return false;
            }
        }
        return fsm.accept(state);
    }
}