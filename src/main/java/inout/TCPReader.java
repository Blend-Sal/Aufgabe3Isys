package inout;

import fpinjava.Callable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPReader extends AbstractReader {

    private final Socket socket;

    public TCPReader(Socket socket) throws IOException {
        super(new BufferedReader(new InputStreamReader(socket.getInputStream())));
        this.socket = socket;
        socket.shutdownOutput();
    }


    @SuppressWarnings("resource")
    public static Callable<Input> accept(int localPort) {
        return () -> new TCPReader(new ServerSocket(localPort).accept());
    }

    public static Callable<Input> connectTo(String remoteHost, int remotePort) {
        return () -> new TCPReader(new Socket(remoteHost, remotePort));
    }

    @Override
    public void shutdownInput() {
        try {
            socket.shutdownInput(); // Dies schließt nicht den Socket, sondern dessen Input, indem es den Input - Stream auf "End of Stream" umstellt.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() throws Exception {
        socket.close();
    }
}
