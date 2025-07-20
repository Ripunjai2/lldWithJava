package org.ripunjai.lldwithjava.concurrency;

public class Client {
    public static void main(final String[] args) {
        System.out.println("Starting the application..." + Thread.currentThread().getName());

//        HelloWorldDisplay helloWorldDisplay = new HelloWorldDisplay("Ripunjai");
//        Thread thread = new Thread(helloWorldDisplay);
//        thread.start();
//
//        Thread thread1 = new Thread(helloWorldDisplay);
//        thread1.start();
//
//        Thread thread2 = new Thread(helloWorldDisplay);
//        thread2.start();

        for (int i = 0; i < 100; i++) {
            NumberPrinter numberPrinter = new NumberPrinter(i);
            Thread thread = new Thread(numberPrinter);
            thread.start();
        }

        System.out.println("Ending the application..." + Thread.currentThread().getName());
        }
    }

/*
Task : Print Hello World from a new thread.

1. Create a Task.
    -> Create a Task class.
    -> Make this class implement Runnable interface.
    -> Implement the run() method.
2. Create a Thread.
    -> Create thread object.
3. Assign the task to the thread.
    -> Pass task object inside the constructor of thread class.
4. Start the thread.
    -> thread.start();


 */