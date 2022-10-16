package echo.actor;

import actor.AbstractActor;
import actor.Actor;
import actor.MessageProcessor;
import fpinjava.Result;
import inout.ConsoleReader;

public class EchoActor<T> extends AbstractActor<T> implements Actor<T> {

    public EchoActor(String id, Type type) {
        super(id, type);
    }

    @Override
    public void onReceive(T message, Result<Actor<T>> sender) {
        //sender.successValue().tell(message, this);
        sender.forEachOrFail(m -> sender.successValue().tell(message, m));
    }

    public static void main(String[] args) {
        ConsoleReader cr = ConsoleReader.stdin();


    }

}


