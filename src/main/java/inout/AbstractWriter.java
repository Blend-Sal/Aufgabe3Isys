package inout;

import java.io.PrintWriter;

public class AbstractWriter implements Output {

    private final PrintWriter writer;

    public AbstractWriter(PrintWriter w) {
        this.writer = w;
    }


    @Override
    public void print(String s) {
        writer.print(s);
        writer.flush();

    }

    public void println(String s) {
        writer.println(s);
    }

    @Override
    public void shutdownOutput() {
        writer.close();
    }


}

