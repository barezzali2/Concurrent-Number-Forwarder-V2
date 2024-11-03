package Lab2B;


import java.io.Serializable;

public class NumberService implements Serializable {
    public int number;
    public int logicalClock;

    public NumberService() {

    }

    public NumberService(int number, int logicalClock) {
        this.number = number;
        this.logicalClock = logicalClock;
    }

    public int getLogicalClock() {
        return logicalClock;
    }
}

