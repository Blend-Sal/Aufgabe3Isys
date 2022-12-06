package inout;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessReader extends AbstractReader implements Input {

    protected ProcessReader(Process process) {
        super(new BufferedReader(new InputStreamReader(process.getInputStream())));
    }

    public static Input processReader(Process process) {
        return new ProcessReader(process);
    }

}
