package netcat.uni.tcp;

import actor.Actor;

import static actor.Writer.writer;
import static inout.ConsoleReader.stdin;
import static inout.ConsoleWriter.stdout;
import static inout.TCPReader.accept;
import static inout.TCPWriter.connectTo;

public final class Netcat {
    private Netcat(int port) throws Exception {

        writer("server", accept(port).call(), Actor.Type.SERIAL, stdout()).start();
        Thread.sleep(100000);
    }

    private Netcat(String adr, int port) throws Exception {
        writer("client", stdin(), Actor.Type.SERIAL, connectTo(adr, port).call()).start();
        Thread.sleep(100000);
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: java Netcat -l lokalport | java Netcat zielserver zielport");
        } else if (args[0].equals("-l")) {
            new Netcat(Integer.parseInt(args[1]));
        } else {
            new Netcat(args[0], Integer.parseInt(args[1]));
        }
    }
}