package org.ripunjai.lldwithjava.adderSubtractorLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(final String[] args) {
        Count count = new Count();
        Lock lock = new ReentrantLock();
        Thread adderThread = new Thread(new Adder(count, lock));
        Thread subtractorThread = new Thread(new Subtractor(count, lock));

        adderThread.start();
        subtractorThread.start();

        try {
            adderThread.join();
            subtractorThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final count value: " + count.value);
    }
}
