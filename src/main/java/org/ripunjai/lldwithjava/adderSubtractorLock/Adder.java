package org.ripunjai.lldwithjava.adderSubtractorLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Adder implements Runnable {

    Count count;
    Lock lock;
    public Adder(final Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10000; i++) {
            lock.lock();
            count.value++;
            lock.unlock();
        }
    }
}
