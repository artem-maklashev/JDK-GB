package homework;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread{
    int id;
    static Random random = new Random();
//    int leftForkIndex;
//    int rightForkIndex;
    Fork left;
    Fork right;
    CountDownLatch cdl;
    static final  Service service = new Service(5);
//    Philosopher(int id, int leftForkIndex, int rightForkIndex, CountDownLatch cdl, Service service ){
//        this.id = id;
//        this.leftForkIndex = leftForkIndex;
//        this.rightForkIndex = rightForkIndex;
//        this.cdl = cdl;
//        this.service = service;
//    }

    public Philosopher(int id, Fork left, Fork right, CountDownLatch cdl) {
        this.id = id;
        this.left = left;
        this.right = right;
        this.cdl = cdl;
    }

    public void run(){
        for (int i = 0; i < 3; i++) {
        try {
                eat();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void eat() throws InterruptedException {
        synchronized (left){
            synchronized (right){
                System.out.println("Philosopher " + id + " is eating");
                sleep(random.nextInt(1,4) * 100L);
                System.out.println("Philosopher " + id + " is done eating");
            }
        }
//


    }

}
