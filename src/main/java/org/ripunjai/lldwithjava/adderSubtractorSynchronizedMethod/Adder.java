package org.ripunjai.lldwithjava.adderSubtractorSynchronizedMethod;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {

    Count count;
    public Adder(final Count count) {
        this.count = count;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10000; i++) {
            count.increment(i);
        }
    }
}
