package Lab2B;


import java.net.*;
import java.io.*;

public class Z {
    public static void main(String... args) {
        
        try(ServerSocket server = new ServerSocket(1083)) {
            while(true) {
                System.out.println("Waiting for a client: ");
                Socket socket = server.accept();
                PrintHandler reqP = new PrintHandler(socket);
                Thread thread = new Thread(reqP);
                thread.start();
            }

        }catch(Exception ex) {
            System.err.println(ex);
        }
    }
    
}
