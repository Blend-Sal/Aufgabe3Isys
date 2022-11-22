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
        socket.shutdownInput();
    }


    @SuppressWarnings("resource")
    public static Callable<Output> accept(int localPort) {
        return () -> new TCPWriter(new ServerSocket(localPort).accept());
    }

    public static Callable<Output> connectTo(String remoteHost, int remotePort) {
        return () -> new TCPWriter(new Socket(remoteHost, remotePort));
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
