package actor;

import fpinjava.Result;
import inout.Input;


public class Reader extends AbstractActor<String> {
    private final Input input;
    private final Writer writer;
    private boolean transceiver = false;

    private Reader(String id, Writer writer, Input input) {
        super(id, Type.SERIAL);
        this.input = input;
        this.writer = writer;
    }

    private Reader(String id, Writer writer, Input input, boolean transceiver) {
        super(id, Type.SERIAL);
        this.input = input;
        this.writer = writer;
        this.transceiver = transceiver;
    }

    public static Reader reader(String id, Writer writer, Input input) {
        return new Reader(id, writer, input);
    }

    public static Reader reader(String id, Writer writer, Input input, boolean transceiver) {
        return new Reader(id, writer, input, transceiver);
    }


    @Override
    public void onReceive(String message, Result<Actor<String>> sender) {
        if (!transceiver) {
            input.readLines().forEach(line -> {
                sender.forEach(c -> c.tell(line, writer));
            });
        } else {
            input.readLines().forEach(line -> {
                sender.forEach(c -> c.tell(line, writer));
                sender.forEach(actor -> actor.tell("\u0004", writer));
            });
        }
    }
}

