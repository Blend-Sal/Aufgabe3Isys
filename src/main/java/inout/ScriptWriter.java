package inout;

import list.List;

import static list.List.*;


public class ScriptWriter implements Output{

    List<String> out;

    public ScriptWriter() {
        super();
        out = list();
    }

    @Override
    public void print(String s) {
        out = append(out, list(s));
    }

    public List<String> toList() {
        return out;
    }

    @Override
    public void shutdownOutput() {

    }
}
