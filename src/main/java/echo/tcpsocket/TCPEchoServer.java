package echo.tcpsocket;

import fpinjava.Callable;
import inout.InputOutput;
import inout.TCPReaderWriter;

public class TCPEchoServer {


    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java TCPEchoServer <Port>");
            return;
        }
        int port = Integer.parseInt(args[0]);


        Callable<InputOutput> inout = TCPReaderWriter.accept(port);
        System.out.println("Verbindung hergestellt.");
        InputOutput inputOutput = inout.call();
        inputOutput.readLines().forEach(inputOutput::printLine);
        System.out.println("Verbindung beendet.");
        inputOutput.shutdownInput();

    }

}
