package inout;

import fpinjava.Result;
import tuple.Tuple;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ConsoleReader extends AbstractReader {
    protected ConsoleReader(BufferedReader reader) {
        super(reader);
    }

    public Result<Tuple<String, Input>> readString(String message) {
        System.out.print(message + " ");
        return readLine();
    }

    public Result<Tuple<Integer, Input>> readInt(String message) {
        System.out.print(message + " ");
        return readInt();
    }
    public static ConsoleReader stdin() {
        return new ConsoleReader(new BufferedReader(
                new InputStreamReader(System.in)));
    }
}