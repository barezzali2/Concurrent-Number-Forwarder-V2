package Lab2B;


import java.net.*;
import java.io.*;
import java.util.Random;

public class B {

    private static int logicalClock = 0;

    public static void main(String... args) {
        Random rand = new Random();
        try {
            while(true) {

                int number = rand.nextInt(100);

                logicalClock++;
                System.out.println("Process B generated: " + number + " with logical clock " + logicalClock);
                
               
                try (Socket socket = new Socket("localhost", 1081)) {
                    logicalClock++;
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    NumberService num = new NumberService(number, logicalClock);
                    out.writeObject(num);
                    System.out.println("Number sent to port 1081: Node X"+ " logical clock " + logicalClock);
                } catch (Exception ex) {
                    System.err.println(ex);
                }

                
               
                try (Socket socket = new Socket("localhost", 1082)) {
                    logicalClock++;
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    NumberService num = new NumberService(number, logicalClock);
                    System.out.println("Number sent to port 1082: Node Y"+ " logical clock " + logicalClock);
                    out.writeObject(num);
                } catch (Exception ex) {
                    System.err.println(ex);
                }
                
                
                Thread.sleep(2000); // Generate every second
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
