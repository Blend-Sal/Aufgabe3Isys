package antlr4.antlrInput;

import fpinjava.Result;
import inout.Input;
import stream.Stream;
import tuple.Tuple;

public interface AntlrInput<T> extends Input {

    default Stream<T> stream() {
        return Stream.<T, AntlrInput<T>>unfold(this, AntlrInput::read);
    }
    Result<Tuple<T, AntlrInput<T>>> read();



}
