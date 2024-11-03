package Lab2B;

import java.net.*; 
import java.io.*;
import java.util.Random;


public class RequestHandler implements Runnable {

    private Socket socket;
    // private static int logicalClock = 0;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
            // logicalClock++;
            NumberService request = (NumberService) ois.readObject();
            int logicalClock = request.getLogicalClock() + 1;
            System.out.println("The number " + request.number + " is received with updated timestamp: " + logicalClock);


            logicalClock++;
            System.out.println("The number " + request.number + " with timestamps " + logicalClock + " will be forwarded to port 1083: Node Z");
            Socket socket = new Socket("localhost", 1083);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            NumberService number = new NumberService(request.number, logicalClock);
            oos.writeObject(number);


            // Random delay
            Thread.sleep(new Random().nextInt(500) + 500);
            

        } catch (Exception ex) {
            System.err.println(ex);
        }

    }
    
}