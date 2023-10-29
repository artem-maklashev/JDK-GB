package homework;

import java.util.concurrent.Semaphore;

public class Fork {
    boolean inUse = false;
    int id;

    public Fork(int id){
        this.id = id;
    }

    public  synchronized void take(){
        inUse = true;
    }
    public synchronized void put(){
        inUse = false;
    }
    public boolean isInUse(){
        return inUse;
    }

}
