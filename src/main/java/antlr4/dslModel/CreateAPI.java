package antlr4.dslModel;

public class CreateAPI {

    public static Fsm first = FsmImpl.fsm()
            .addState("deny", false)
            .addTransition("Iltam", "accept")
            .addTransition("Sumra", "deny")
            .addState("accept", true)
            .addTransition("Iltam", "accept")
            .addTransition("Sumra", "accept");

    public static Fsm second = FsmImpl.fsm()
            .addState("blocked", false)
            .addTransition("Key", "first")
            .addState("first", false)
            .addTransition("Code", "second")
            .addState("second", false)
            .addTransition("Hammer", "unexpected")
            .addState("unexpected", true);

    public static Fsm third = FsmImpl.fsm().addState("RedLight", false)
            .addTransition("greenCar", "green")
            .addState("green", false)
            .addTransition("yellowCar", "yellow")
            .addState("yellow", false)
            .addTransition("redCar", "red")
            .addState("red", true);


}
