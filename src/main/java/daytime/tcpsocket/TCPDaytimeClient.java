package daytime.tcpsocket;

import inout.Input;
import inout.TCPReader;

public class TCPDaytimeClient {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: java TCPDayTimeClient <host> <port>");
            return;
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);
        Input in = TCPReader.connectTo(host, port).call();
        in.readLines().forEach(System.out::println);
        in.shutdownInput();
    }

}
