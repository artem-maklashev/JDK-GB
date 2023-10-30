package homework.variant2;

import java.util.Random;

public class Philosopher implements Runnable {
    private static final Random random = new Random();
    private final Fork leftFork;
    private int id;
    private final Fork rightFork;
    private int eatCount;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.eatCount = 0;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (eatCount < 3) {
                think();
                if (leftFork.getSemaphore().tryAcquire()) {
                    System.out.println("Философ " + id + " взял вилку " + leftFork.id);
                    if (rightFork.getSemaphore().tryAcquire()) {
                        System.out.println("Философ " + id + " взял вилку " + rightFork.id);
                        eat();
                        rightFork.putDown();
                        System.out.println("Философ " + id + " положил вилку " + rightFork.id);
                    }
                    leftFork.putDown();
                    System.out.println("Философ " + id + " положил вилку " + leftFork.id);
                }
            }
            System.out.println("Философ " + id + " закончил прием пищи.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }



    private void eat() throws InterruptedException {
        System.out.println("Философ " + id + " ест " + (eatCount + 1) + " раз");
        Thread.sleep( random.nextInt(100, 500));
        eatCount++;
    }

    private void think() throws InterruptedException {
        System.out.println("Философ " + id + " размышляет.");
        Thread.sleep(random.nextInt(100, 500));
    }
}