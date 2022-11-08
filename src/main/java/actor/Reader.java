package actor;

import fpinjava.Result;
import inout.Input;


public class Reader extends AbstractActor<String> {
    private final Input input;
    private final Writer writer;


    private Reader(String id, Writer writer, Input input) {
        super(id, Type.SERIAL);
        this.input = input;
        this.writer = writer;
    }

    public static Reader reader(String id, Writer writer, Input input) {
        return new Reader(id, writer, input);
    }


    @Override
    public void onReceive(String message, Result<Actor<String>> sender) {
        //input.readLines().forEach(line -> sender.forEach(actor -> actor.tell(line + "\u0004", writer)));
        input.readLines().forEach(line -> {
            sender.forEach(c -> c.tell(line, writer));
        });
    }
}

