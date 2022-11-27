package echo.tcpsocket;

import inout.InputOutput;
import inout.TCPReaderWriter;

public class TCPEchoClient {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: java TCPEchoClient <host> <port>");
            return;
        }
        String host = args[0];
        int port = Integer.parseInt(args[1]);


        InputOutput inout = TCPReaderWriter.connectTo(host, port).call();
        inout.readLines().forEach(inout::print);

    }

}
