package org.ripunjai.lldwithjava.producerConsumerProblem;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class main {

    public static void main(String []args){
        Queue<Objects> queue = new ArrayDeque();
//        Queue<Objects> queue = new ConcurrentLinkedDeque<>();

        Producer p1 = new Producer(queue, 6, "Producer1");
        Producer p2 = new Producer(queue, 6, "Producer2");
        Producer p3 = new Producer(queue, 6, "Producer3");
        Producer p4 = new Producer(queue, 6, "Producer4");
        Producer p5 = new Producer(queue, 6, "Producer5");


        Consumer c1 = new Consumer(queue, 6, "Consumer1");
        Consumer c2 = new Consumer(queue, 6, "Consumer2");
        Consumer c3 = new Consumer(queue, 6, "Consumer3");
        Consumer c4 = new Consumer(queue, 6, "Consumer4");

//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.submit(p1);
//        executorService.submit(p2);
//        executorService.submit(p3);
//        executorService.submit(p4);
//        executorService.submit(p5);
//
//        executorService.submit(c1);
//        executorService.submit(c2);
//        executorService.submit(c3);

        Thread t1 = new Thread(p1);
        t1.start();
        Thread t2 = new Thread(p2);
        t2.start();
        Thread t3 = new Thread(p3);
        t3.start();
        Thread t4 = new Thread(p4);
        t4.start();
        Thread t5 = new Thread(p5);
        t5.start();
        Thread t6 = new Thread(c1);
        t6.start();
        Thread t7 = new Thread(c2);
        t7.start();
        Thread t8 = new Thread(c3);
        t8.start();
        Thread t9 = new Thread(c4);
        t9.start();
    }
}
