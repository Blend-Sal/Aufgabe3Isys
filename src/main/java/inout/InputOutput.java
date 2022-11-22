package inout;

import java.io.IOException;

public interface InputOutput extends Input, Output {
    default void close() throws IOException {
        shutdownInput();
        shutdownOutput();
    }
}
