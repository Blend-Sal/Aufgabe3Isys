package daytime.tcpsocket;
import java.util.Date;
import inout.Output;
import inout.TCPWriter;

public class TCPDaytimeServer {

    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            System.err.println("Usage: java TCPDaytimeServer <port>");
            return;
        }
        int port = Integer.parseInt(args[0]);
        String date = new Date().toString();
        Output out = TCPWriter.accept(port).call();
        System.out.println("Verbindung aufgebaut.");
        out.printLine(date);
        System.out.println("Verbindung beendet.");

    }
}
