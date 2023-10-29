package homework;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    public static final Random random = new Random();
    final Fork leftFork;
    final Fork rightFork;
    String name;


    public Philosopher(Fork leftFork, Fork rightFork, String name) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.name = name;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 3) {
            synchronized (leftFork) {
                System.out.println(name + " взял вилку " + leftFork.id);
                synchronized (rightFork) {
                    System.out.println(name + " взял вилку " + rightFork.id);
                    eat();
                    count++;
                    if (count == 3) {
                        System.out.println(name.toUpperCase() + " ПОЕЛ " + count + " РАЗ(А)");
                    }
                    System.out.println(name + " положил вилку " + rightFork.id);

                }
                System.out.println(name + " положил вилку " + leftFork.id);
            }

            rest();
        }
    }
        private void eat () {
            try {
                System.out.println(name + " ест");
                Thread.sleep(random.nextInt(200, 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void rest () {
            try {
                System.out.println(name + " думает");
                Thread.sleep(random.nextInt(200, 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
