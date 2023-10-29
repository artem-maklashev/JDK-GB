package homework;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
//        CountDownLatch cdl = new CountDownLatch(5);
//        Service service = new Service(5);
//
//        Philosopher p1 = new Philosopher(1, service.getFork(1), service.getFork(2), cdl);
//        Philosopher p2 = new Philosopher(2, service.getFork(2), service.getFork(3), cdl);
//        Philosopher p3 = new Philosopher(3, service.getFork(3), service.getFork(4), cdl);
//        Philosopher p4 = new Philosopher(4, service.getFork(4), service.getFork(5), cdl);
//        Philosopher p5 = new Philosopher(5, service.getFork(5), service.getFork(1),  cdl);
//        Philosopher p2 = new Philosopher(2, 2, 3, cdl );
//        Philosopher p3 = new Philosopher(3, 3, 4, cdl );
//        Philosopher p4 = new Philosopher(4, 4, 5, cdl );
//        Philosopher p5 = new Philosopher(5, 5, 1, cdl );

        Semaphore semaphore = new Semaphore(1);
        Fork f1 = new Fork(1);
        Fork f2 = new Fork(2);
        Fork f3 = new Fork(3);
        Fork f4 = new Fork(4);
        Fork f5 = new Fork(5);
        Philosopher2 p1 = new Philosopher2("1", f1, f2, semaphore);
        Philosopher2 p2 = new Philosopher2("2", f2, f3, semaphore);
        Philosopher2 p3 = new Philosopher2("3", f3, f4, semaphore);
        Philosopher2 p4 = new Philosopher2("4", f4, f5, semaphore);
        Philosopher2 p5 = new Philosopher2("5", f5, f1, semaphore);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
    }
}
