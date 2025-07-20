package org.ripunjai.lldwithjava.producerConsumerProblem;

import java.util.Queue;

public class Consumer implements Runnable {

    Queue queue;
    int maxSize;
    String name;

    public Consumer(Queue queue, int maxSize, String name) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run(){
        while(true) {
            if(!queue.isEmpty()) {
                queue.remove();
                System.out.println(name + " consumed an item. Queue size: " + queue.size());
            }
        }
    }
}
