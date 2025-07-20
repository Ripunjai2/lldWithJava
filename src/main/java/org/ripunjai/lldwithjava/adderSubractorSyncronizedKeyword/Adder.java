package org.ripunjai.lldwithjava.adderSubractorSyncronizedKeyword;


public class Adder implements Runnable {

    Count count;
    public Adder(final Count count) {
        this.count = count;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10000; i++) {
            synchronized(count) {
                count.value += i;
            }
        }
    }
}
