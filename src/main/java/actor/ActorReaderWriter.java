package actor;

import fpinjava.Result;
import inout.Input;
import inout.InputOutput;
import tuple.Tuple;

public class ActorReaderWriter extends AbstractActor<String> implements InputOutput {

    private final ActorReader reader;
    private final Actor<String> actor;


    public static ActorReaderWriter actorReaderWriter(String id, Actor<String> actor, long timeout) {
        return new ActorReaderWriter(id, actor, timeout);
    }

    public ActorReaderWriter(String id, Actor<String> actor, long timeout) {
        super(id, Type.SERIAL);
        this.actor = actor;
        this.reader = new ActorReader(id, timeout);
    }

    @Override
    public void onReceive(String message, Result<Actor<String>> sender) {
        reader.tell(message, sender);
    }

    @Override
    public Result<Tuple<String, Input>> readLine() {
        return reader.readLine();
    }

    @Override
    public void print(String message) {
        actor.tell(message, this);
    }


    public void shutdownInput() {

    }


    public void shutdownOutput() {

    }
}
