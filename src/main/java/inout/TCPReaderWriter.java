package inout;

import fpinjava.Callable;
import fpinjava.Result;
import tuple.Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPReaderWriter implements InputOutput {
    private final Socket socket;
    private final AbstractReader abstractReader;
    private final AbstractWriter abstractWriter;

    private TCPReaderWriter(int port) throws IOException {
        this.socket = new ServerSocket(port).accept();
        this.abstractReader = new AbstractReader(new BufferedReader(new InputStreamReader(socket.getInputStream())));
        this.abstractWriter = new AbstractWriter(new PrintWriter(socket.getOutputStream(), true));
    }

    public TCPReaderWriter(Socket socket) throws IOException {
        this.socket = socket;
        this.abstractReader = new AbstractReader(new BufferedReader(new InputStreamReader(socket.getInputStream())));
        this.abstractWriter = new AbstractWriter(new PrintWriter(socket.getOutputStream(), true));
    }


    private TCPReaderWriter(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        this.abstractWriter = new AbstractWriter(new PrintWriter(socket.getOutputStream(), true));
        this.abstractReader = new AbstractReader((new BufferedReader(new InputStreamReader(socket.getInputStream()))));
    }

    public static TCPReaderWriter tcpReaderWriter(int port) throws IOException {
        return new TCPReaderWriter(port);
    }

    public static TCPReaderWriter tcpReaderWriter(String host, int port) throws IOException {
        return new TCPReaderWriter(host, port);
    }

    public static Callable<InputOutput> accept(int localPort) {
        return () -> {
            ServerSocket serverSocket = new ServerSocket(localPort);
            Socket socket = serverSocket.accept();
            return new TCPReaderWriter(socket);
        };
    }

    public static Callable<InputOutput> connectTo(String remoteHost, int remotePort) throws IOException {
        Socket socket = new Socket(remoteHost, remotePort);
        return () -> new TCPReaderWriter(remoteHost, remotePort);
    }

    @Override
    public Result<Tuple<String, Input>> readLine() {
        return abstractReader.readLine();
    }

    @Override
    public void shutdownInput() throws IOException {
        socket.shutdownInput();
    }

    @Override
    public void print(String s) {
        abstractWriter.print(s);
    }

    @Override
    public void shutdownOutput() throws IOException {
        socket.shutdownOutput();
    }
}
