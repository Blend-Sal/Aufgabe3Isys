package actor;

import fpinjava.Callable;
import fpinjava.Result;
import inout.InputOutput;
import inout.TCPReaderWriter;

import java.net.ServerSocket;
import java.net.Socket;

import static actor.Writer.*;

public class ActorSystem {
    public static Runnable publish2one(Actor<String> actor, int port) throws Exception {
        InputOutput socketReaderWriter = TCPReaderWriter.accept(port).call();
        Writer writer = writer("server", socketReaderWriter, socketReaderWriter, Type.SERIAL, true);
        return () -> {
            try {
                writer.start(Result.success(actor));
                Thread.sleep(100);
            } catch (Exception e) {
                Result.failure(e);
            }
        };
    }

    public static Callable<Writer> actorSelection(String host, int port) throws Exception {
        return () -> {
            InputOutput socketReaderWriter = TCPReaderWriter.connectTo(host, port).call();
            return writer("client", socketReaderWriter, socketReaderWriter, Type.SERIAL, true);
        };
    }

    public static Runnable publish2multiple(Actor<String> actor, int port) throws Exception {
        return () -> {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                while (true) {
                    Socket socket = serverSocket.accept();
                    TCPReaderWriter socketReaderWriter = new TCPReaderWriter(socket);
                    Writer transceiver = writer("server", socketReaderWriter, socketReaderWriter, Type.SERIAL, true);
                    transceiver.start(Result.success(actor));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }


}



