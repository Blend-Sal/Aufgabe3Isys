package echo.actor;

import actor.Actor;

import static actor.ActorSystem.publish2one;
import static java.lang.Integer.parseInt;


public class EchoServer {
    public static void main(String[] args) throws Exception {
        publish2one(new EchoActor("eActor", Actor.Type.SERIAL), parseInt(args[1])).run();
    }
}