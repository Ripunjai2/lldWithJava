package org.ripunjai.lldwithjava.producerConsumerProblem;

import java.util.Queue;

public class Producer implements Runnable {

    Queue queue;
    int maxSize;
    String name;

    public Producer(Queue queue, int maxSize, String name) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.name = name;
    }

    public void run(){
        while(true) {
            if(queue.size() < maxSize) {
                queue.add(new Object());
                System.out.println(name + " produced an item. Queue size: " + queue.size());
            }
        }
    }
}
