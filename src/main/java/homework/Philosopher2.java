package homework;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosopher2 extends Thread{
    private static final Random random = new Random();
    final Fork leftFork;
    final Fork rightFork;

    Semaphore semaphore;
    String name;

    public Philosopher2(String name, Fork leftFork, Fork rightFork, Semaphore semaphore) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.semaphore = semaphore;
        this.name = name;
    }

    public void eat() throws InterruptedException {
        int count = 0;
        while (count < 3) {
            if (!leftFork.isInUse() && !rightFork.isInUse()) {
//                semaphore.acquire();
                synchronized (leftFork) {
                    leftFork.take();
                }
                synchronized (rightFork) {
                    rightFork.take();
                }
//                semaphore.release();
                System.out.println(name + " ест");
                Thread.sleep(random.nextInt(200, 1000));
                count++;
                rest();
            }

        }
        System.out.println(name + " поел " + count + " раз");

    }

    private void rest() {
        synchronized (leftFork) {
            leftFork.put();
        }
        synchronized (rightFork) {
            rightFork.put();
        }
        System.out.println(name + " думает");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                eat();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
