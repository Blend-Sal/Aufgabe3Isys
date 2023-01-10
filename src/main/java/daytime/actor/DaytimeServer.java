package daytime.actor;

import actor.Actor;

import static actor.ActorSystem.publish2multiple;
import static java.lang.Integer.parseInt;

public class DaytimeServer {
    public static void main(String[] args) throws Exception {
        publish2multiple(new Daytime("daytime", Actor.Type.SERIAL), parseInt(args[0])).run();
    }
}
