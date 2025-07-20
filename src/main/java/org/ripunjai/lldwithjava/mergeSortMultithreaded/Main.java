package org.ripunjai.lldwithjava.mergeSortMultithreaded;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// what is wrong with this code? why not printing the sorted list?
public class Main {
    public static void main(final String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Hello from main thread: " + Thread.currentThread().getName());

//        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Integer> numbers = List.of(5, 3, 8, 6, 2, 7, 4, 1);
        MergeSorter mergeSorter = new MergeSorter(numbers, executorService);

        Future<List<Integer>> sortedList = executorService.submit(mergeSorter);
        List<Integer> sortedListResult = sortedList.get();
        System.out.println("Hello " + sortedListResult);
//        executorService.shutdown();

//        for (int i = 0; i < 100; i++) {
//            final int taskNumber = i;
//            executorService.submit(() -> {
//                System.out.println("Hello from thread: " + Thread.currentThread().getName() + " - Task number: " + taskNumber);
//                try {
//                    Thread.sleep(1000); // Simulating some work
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                    System.err.println("Thread was interrupted: " + e.getMessage());
//                }
//            });
//        }
//    }
    }
}
