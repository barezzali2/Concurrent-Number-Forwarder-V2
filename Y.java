package Lab2B;


import java.net.*;
import java.io.*;

public class Y {
    public static void main(String... args) {
        try (ServerSocket server = new ServerSocket(1082)) {
            while (true) {
                System.out.println("Waiting for a client: ");
                Socket connection = server.accept();
                RequestHandler reqH = new RequestHandler(connection);
                Thread thread = new Thread(reqH);
                thread.start();
                
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
