package org.ripunjai.lldwithjava.adderSubtractorSynchronizedMethod;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(final String[] args) {
        Count count = new Count();
        Thread adderThread = new Thread(new Adder(count));
        Thread subtractorThread = new Thread(new Subtractor(count));

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
