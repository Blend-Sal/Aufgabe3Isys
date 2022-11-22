package inout;

import java.io.IOException;

public interface Output {

    void print(String s);

    default void printLine(String s){
        print(s+"\n");
    }

    void shutdownOutput() throws IOException;
}
