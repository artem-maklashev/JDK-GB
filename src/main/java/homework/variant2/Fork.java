package homework.variant2;


import java.util.concurrent.Semaphore;

public class Fork {
    final Semaphore forkSemaphore;
    int id;

    public Fork(int id, Semaphore semaphore) {
        forkSemaphore = semaphore;
        this.id = id;
    }

    public void pickUp() throws InterruptedException {
        forkSemaphore.acquire();
    }

    public void putDown() {
        forkSemaphore.release();
    }

    public Semaphore getSemaphore() {
        return forkSemaphore;

    }
}
