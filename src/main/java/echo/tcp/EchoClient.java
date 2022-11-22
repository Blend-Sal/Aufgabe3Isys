package echo.tcp;


import java.io.*;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: java EchoClient <host> <port>");
            return;
        }

        String data = args[1];

        try (
                Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            out.println(data);
            String input;
            if ((input = in.readLine()) != null) {
                System.out.println(input);
            }
            socket.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}