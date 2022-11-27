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
        Output out = TCPWriter.accept(Integer.parseInt(args[0])).call();
        System.out.println("Verbindung aufgebaut.");


        out.printLine(new Date().toString());
        out.shutdownOutput();
        System.out.println("Verbindung beendet.");

    }
}
