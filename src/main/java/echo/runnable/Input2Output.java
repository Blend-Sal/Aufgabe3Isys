package echo.runnable;

import inout.ConsoleReader;
import inout.ConsoleWriter;
import inout.Input;
import inout.Output;


import static inout.ConsoleReader.stdin;
import static inout.ConsoleWriter.stdout;

public class Input2Output {
    private final Input input;
    private final Output output;


    public Input2Output(Input in, Output out) {
        input = in;
        output = out;

        out.shutdownOutput();
    }


    static Runnable input2output(Input in, Output out) {

        return () -> in.readLines().forEach(out::printLine);
    }



    public void run() {
        System.out.println("Waiting for Input...");
        input.readLines().forEach(output::printLine); // das hört nie auf.
    }

    public static void main(String[] args) {
        ConsoleReader cReader = stdin();
        ConsoleWriter cWriter = stdout();
        Runnable i2o = input2output(cReader, cWriter);
        System.out.println("now running");
        i2o.run();
    }


}
