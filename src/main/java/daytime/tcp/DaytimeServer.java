package daytime.tcp;


import actor.Actor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Integer.parseInt;


public class DaytimeServer {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java DaytimeServer port");
            return;
        }
        int port = parseInt(args[0]);

        try (

                Socket socket = new ServerSocket(port).accept();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream())
        ) {
            System.out.println("Verbindung hergestellt");
            out.println(java.time.LocalDateTime.now() + "");
            System.out.println("Verbindung beendet");
            socket.close();

        } catch (IOException e) {
            System.err.println(e);
        }

    }
}