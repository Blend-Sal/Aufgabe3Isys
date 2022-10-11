package echo.runnable;


import fpinjava.Result;
import inout.ConsoleReader;
import inout.ConsoleWriter;
import inout.Input;
import inout.Output;
import tuple.Tuple;

import static inout.ConsoleReader.stdin;
import static inout.ConsoleWriter.stdout;

public class Input2Output implements Runnable, Input, Output {
    private final Input input;
    private final Output output;


    public Input2Output(Input in, Output out) {
        input = in;
        output = out;
    }


    static Runnable input2output(Input in, Output out) {

        return () -> in.readLines().forEach(out::printLine);
    }


    @Override
    public void run() {
        System.out.println("Waiting for Input...");
        input.readLines().forEach(output::printLine); // das hört nie auf.
        shutdownInput(); // die beiden werden nicht erreicht
        shutdownOutput();
    }

    public static void main(String[] args) {
        ConsoleReader cReader = stdin();
        ConsoleWriter cWriter = stdout();
        Runnable i2o = input2output(cReader, cWriter);
        System.out.println("now running");
        i2o.run();
    }


    @Override
    public Result<Tuple<String, Input>> readLine() {
        return input.readLine();
    }

    @Override
    public void shutdownInput() {
        input.shutdownInput();
    }

    @Override
    public void print(String s) {
        output.print(s);
    }

    @Override
    public void shutdownOutput() {

    }
}
