package echo.actor;

import actor.Actor;

import static actor.ActorSystem.publish2multiple;
import static java.lang.Integer.parseInt;


public class EchoServer {
    public static void main(String[] args) throws Exception {
        publish2multiple(new EchoActor("eActor", Actor.Type.SERIAL), parseInt(args[1])).run();
    }
}