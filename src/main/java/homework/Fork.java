package homework;

import java.util.concurrent.CountDownLatch;

public class Fork {
    boolean isInUse;
    int id;

    public Fork(int id) {
        this.id = id;
    }

    public void take() {
        isInUse = true;
    }


    public void put() {
        isInUse = false;

    }

    public boolean isInUse() {
        return isInUse;
    }
}
