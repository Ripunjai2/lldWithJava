package org.ripunjai.lldwithjava.concurrency;

public class NumberPrinter implements Runnable {
    private final int number;

    public NumberPrinter(final int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("From NumberPrinter thread: " + Thread.currentThread().getName() + " - " + number);
    }
}
