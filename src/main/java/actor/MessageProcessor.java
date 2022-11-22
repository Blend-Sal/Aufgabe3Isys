package actor;

import fpinjava.Result;

import java.io.IOException;

public interface MessageProcessor<T> {
    void process(T t, Result<Actor<T>> sender) throws IOException;
}
