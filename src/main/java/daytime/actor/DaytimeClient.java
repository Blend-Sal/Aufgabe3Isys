package daytime.actor;

import actor.ActorSystem;
import actor.AskStream;
import actor.Writer;

import static java.lang.Integer.parseInt;

public class DaytimeClient {
    public static void main(String[] args) throws Exception {
        Writer w = ActorSystem.actorSelection(String.valueOf(args[0]), parseInt(args[1])).call();
        AskStream.ask(w, "", 500);
    }
}
