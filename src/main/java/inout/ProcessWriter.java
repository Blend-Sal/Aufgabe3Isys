package inout;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ProcessWriter extends AbstractWriter implements Output {
    public ProcessWriter(Process process) {
        super(new PrintWriter(new OutputStreamWriter(process.getOutputStream())));
    }

   public static Output processWriter(Process process) {
        return new ProcessWriter(process);
    }
}
