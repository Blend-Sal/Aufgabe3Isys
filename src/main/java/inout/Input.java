package inout;

import fpinjava.Result;
import stream.Stream;
import tuple.Tuple;


import java.io.IOException;

import static tuple.Tuple.tuple;


public interface Input {

    Result<Tuple<String, Input>> readLine();

    default Result<Tuple<Integer, Input>> readInt() {

        return readLine().flatMap(tuple -> readIntMaybe(tuple.fst).map(a -> tuple(a, tuple.snd)));
    }

    static Result<Integer> readIntMaybe(String s) {
        return Result.of(() -> Integer.parseInt(s));
    }

    default Stream<String> readLines() {
        return Stream.<String, Input>unfold(this, Input::readLine);
    }

    default Stream<Integer> readInts() {
        return Stream.<Integer, Input>unfold(this, Input::readInt);
    }

    void shutdownInput() throws IOException;

}

// readIntMaybe = Es wird versucht, die Zahlen aus einem String als ein Integer zu lesen. Dazu wird der Result benutzt.
// Beim falschen Typ wird ein Failure ausgegeben.
