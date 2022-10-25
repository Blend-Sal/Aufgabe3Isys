package actor;

import fpinjava.Result;
import inout.Input;
import tuple.Tuple;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static tuple.Tuple.tuple;

public class ActorReader extends AbstractActor<String> implements Input {

    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    private final long timeout;

    public ActorReader(String id, long timeout) {
        super(id, Type.SERIAL);
        this.timeout = timeout;
    }

    @Override
    public void onReceive(String message, Result<Actor<String>> sender) {
        queue.offer(message);
    }

    @Override
    public Result<Tuple<String, Input>> readLine() {
        return Result.of(() -> tuple(queue.poll(timeout, TimeUnit.MILLISECONDS), this));
    }

    static Input actorReader(String id, long timeout) {

        return new ActorReader(id, timeout);
    }

    public void shutdownInput() {

    }
}

