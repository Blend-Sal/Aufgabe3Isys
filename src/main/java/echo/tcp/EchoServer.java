package echo.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port>");
            return;
        }
        try (
                ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
                Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            System.
                    out.println("Verbindung hergestellt");
            while (in.readLine() != null) {
                out.println(in.readLine());
            }
            socket.shutdownInput();
            System.
                    out.println("Verbindung beendet");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}