package org.ripunjai.lldwithjava.adderSubtractorSynchronizedMethod;

public class Count {
    int value=0;

    public synchronized void increment(int i) {
        value = value + i;
    }
    public synchronized void decrement(int i) {
        value = value - i;
    }
}
