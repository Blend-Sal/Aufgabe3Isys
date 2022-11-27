package inout;

import fpinjava.Callable;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPWriter extends AbstractWriter {
    private final Socket socket;


    public TCPWriter(Socket socket) throws IOException {
        super(new PrintWriter(socket.getOutputStream(), true));
        this.socket = socket;
    }


    @SuppressWarnings("resource")
    public static Callable<Output> accept(int localPort) {

        return () -> {
            Socket socket1 = new ServerSocket(localPort).accept();
            socket1.shutdownInput();
            return new TCPWriter(socket1);
        };
    }

    public static Callable<Output> connectTo(String remoteHost, int remotePort) {
        return () -> {
            Socket socket1 = new Socket(remoteHost, remotePort);
            socket1.shutdownInput();
            return new TCPWriter(socket1);
        };
    }

    public void close() throws IOException {
        socket.close();
    }

    @Override
    public void shutdownOutput() {
        try {
            socket.shutdownOutput(); // Das schließt auch nicht den Socket, sondern den Output - Stream.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
