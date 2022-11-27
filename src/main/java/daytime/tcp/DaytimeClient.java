package daytime.tcp;

import java.io.InputStream;
import java.net.Socket;
import java.util.Date;

public class DaytimeClient {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java DaytimeClient <host> <port>");
            return;
        }
        try (Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
             InputStream in = socket.getInputStream()
        ) {
            System.out.println(new Date());

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}