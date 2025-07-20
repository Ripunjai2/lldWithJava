package org.ripunjai.lldwithjava.concurrency;

public class HelloWorldDisplay implements Runnable {
    private final String message;

    public HelloWorldDisplay(final String message) {
        this.message = message;
    }
    @Override
    public void run() {
        System.out.println("From Hello world Display thread: " + Thread.currentThread().getName() + "888" +message);
    }
}
