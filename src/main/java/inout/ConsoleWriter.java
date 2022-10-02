package inout;

import java.io.PrintWriter;

public class ConsoleWriter extends AbstractWriter{
    public ConsoleWriter(PrintWriter w) {
        super(w);
    }

    public static ConsoleWriter stdout() {
        return new ConsoleWriter(new PrintWriter(System.out, true));
    } // AutoFlush anschalten, damit die Daten automatisch weiter fließen, ohne der Pflicht, manuell zu flushen.
}
