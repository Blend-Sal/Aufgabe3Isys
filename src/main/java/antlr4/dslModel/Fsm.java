package antlr4.dslModel;

public interface Fsm {
    Fsm addState(String state, Boolean accept) throws FsmlDistinctIdsException;

    Fsm addTransition(String event, String target);

    String getInitial();

    String makeTransition(String state, String event);

    Boolean accept(String state);
}