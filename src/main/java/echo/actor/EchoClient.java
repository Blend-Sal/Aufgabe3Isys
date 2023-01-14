package echo.actor;

import actor.ActorSystem;
import actor.AskStream;
import actor.Writer;
import stream.Stream;

import static java.lang.Integer.parseInt;


public class EchoClient {

    public static void main(String[] args) throws Exception {
        Writer w = ActorSystem.actorSelection(String.valueOf(args[0]), parseInt(args[1])).call();
        Stream<String> askStream = AskStream.ask(w, "Hello.", 5000);
        Thread.sleep(2000);
        System.out.println(askStream.head());
        Stream<String> askStream2 = AskStream.ask(w, "World.", 5000);
        Thread.sleep(2000);
        System.out.println(askStream2.head());

    }
}