package daytime.tcp;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class DaytimeServer {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java DaytimeServer port");
            return;
        }
        int port = Integer.parseInt(args[0]);

        try (
                ServerSocket serverSocket = new ServerSocket(port);
                Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
        ){
            System.out.println("Verbindung hergestellt");
            out.println(java.time.LocalDateTime.now()+ "");
            System.out.println("Verbindung beenden");
            socket.close();

        } catch (IOException e) {
            System.err.println(e);
        }

    }
}