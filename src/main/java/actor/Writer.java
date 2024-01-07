package actor;

import fpinjava.Result;
import inout.Input;
import inout.Output;

import java.io.IOException;

import static actor.Reader.reader;

public class Writer extends AbstractActor<String> {
    private final Reader reader;
    private final Output output;
    private Input in;
    private boolean transceiver = false;

    private Writer(String id, Input input, Output output) {
        super(id, Type.SERIAL);

        in = input;
        this.output = output;
        reader = reader("reader", this, input);
    }

    private Writer(String id, Type type, Input input, Output output) {
        super(id, type.SERIAL);

        this.reader = reader(id, this, input);
        this.output = output;
        in = input;

    }

    private Writer(String id, Type type, Input input, Output output, boolean transceiver) {
        super(id, type.SERIAL);

        this.reader = reader(id, this, input);
        this.output = output;
        in = input;
        this.transceiver = transceiver;

    }


    @Override
    public void onReceive(String message, Result<Actor<String>> sender) throws IOException {
        if (message.equals("\u0004")) {
            if (!transceiver) {
                output.printLine(message);
            }
            this.output.shutdownOutput();
        } else {
            this.output.printLine(message);
        }
    }

    public void start() {
        this.reader.tell("", this);
    }

    public void start(Result<Actor<String>> consumer) {
        consumer.forEach(actor -> this.reader.tell("", actor));
    }

    public static Writer writer(String id, Input input, Output output) {
        return new Writer(id, input, output);
    }

    public static Writer writer(String id, Input input, Type type, Output output) {
        return new Writer(id, type, input, output);
    }

    public static Writer writer(String id, Input input, Output output, Type type, boolean transceiver) {
        return new Writer(id, type, input, output, transceiver);
    }

}