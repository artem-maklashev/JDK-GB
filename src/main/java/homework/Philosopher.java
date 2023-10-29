package homework;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    public static final Random random = new Random();
    Fork leftFork;
    Fork rightFork;
    String name;
    Semaphore semaphore;

    public Philosopher(Fork leftFork, Fork rightFork, String name, Semaphore semaphore) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 3) {
            try {

                if (takeFork(leftFork, rightFork)) {
                    System.out.println(name + " взял вилки " + (count + 1) + " раз");
                    eat();
                    count++;
                    rest();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " поел " + count + " раз");
    }

    private void eat() {
        try {
            System.out.println(name + " ест");
            Thread.sleep(random.nextInt(200, 1000));
            putFork(leftFork, rightFork);
            System.out.println(name + " отдал вилки");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean takeFork(Fork leftFork, Fork rightFork) throws InterruptedException {
         semaphore.acquire();
            if (!leftFork.isInUse && !rightFork.isInUse) {
                leftFork.take();
                rightFork.take();
                semaphore.release();
                return true;
            }
            semaphore.release();
            return false;
        }


    private void putFork(Fork leftFork, Fork rightrtFork) throws InterruptedException {
        semaphore.acquire();
            leftFork.put();
            rightrtFork.put();
        semaphore.release();
    }

    public void rest() {
        try {
            System.out.println(name + " спит");
            Thread.sleep(random.nextInt(200, 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
