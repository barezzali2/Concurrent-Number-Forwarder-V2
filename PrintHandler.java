package Lab2B;


import java.net.*; 
import java.io.*;

public class PrintHandler implements Runnable{
    private Socket socket;

    public PrintHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            NumberService request = (NumberService) ois.readObject();
            int logicalClock = request.getLogicalClock() + 1;
            System.out.println("The number " + request.number + " is received" + " with timestamp (Logical Clock): " + logicalClock);

        } catch (Exception ex) {
            System.err.println(ex);
        }


    }
}
