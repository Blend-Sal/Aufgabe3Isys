package inout;

import list.List;

import static list.List.*;


public class ScriptWriter implements Output {

    List<String> out;

    public ScriptWriter() {
        super();
        out = list();
    }

    @Override
    public void print(String s) {
        out = out.cons(s);
    }

    @Override
    public void printLine(String s) {
        print(s);
    }

    public List<String> toList() {
        return out;
    }

    @Override
    public void shutdownOutput() {

    }
}