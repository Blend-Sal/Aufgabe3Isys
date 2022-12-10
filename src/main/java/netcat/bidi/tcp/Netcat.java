package netcat.bidi.tcp;
import actor.Actor;
import actor.Writer;
import fpinjava.Result;
import inout.InputOutput;

import static actor.Writer.writer;
import static inout.ConsoleReader.stdin;
import static inout.ConsoleWriter.stdout;
import static inout.TCPReaderWriter.tcpReaderWriter;

public final class Netcat {

    private Netcat(int port) throws Exception {
        InputOutput socketReaderWriter = tcpReaderWriter(port);
        Writer serverSocketWriter = writer("server",socketReaderWriter, Actor.Type.SERIAL, socketReaderWriter);
        Writer serverConsoleWriter = writer("serverconsole", stdin(), Actor.Type.SERIAL, stdout());
        serverSocketWriter.start(Result.success(serverConsoleWriter));
        serverConsoleWriter.start(Result.success(serverSocketWriter));
        Thread.sleep(60);
    }

    private Netcat(String adr, int port) throws Exception {
        InputOutput socketReaderWriter = tcpReaderWriter(adr, port);
        Writer clientSocketWriter = writer("client", socketReaderWriter, Actor.Type.SERIAL, socketReaderWriter);
        Writer clientConsoleWriter = writer("clientconsole", stdin(), Actor.Type.SERIAL, stdout());
        clientSocketWriter.start(Result.success(clientConsoleWriter));
        clientConsoleWriter.start(Result.success(clientSocketWriter));
        Thread.sleep(60);
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: java Netcat -l lokalport | java Netcat zielserver zielport ");

        } else if (args[0].equals("-l")) {
            new Netcat(Integer.parseInt(args[1]));
        } else {
            new Netcat(args[0], Integer.parseInt(args[1]));
        }
    }
}