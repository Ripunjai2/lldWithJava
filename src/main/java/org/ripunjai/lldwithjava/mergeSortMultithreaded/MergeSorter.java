package org.ripunjai.lldwithjava.mergeSortMultithreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {

    private final List<Integer> numbers;
    private ExecutorService executorService;
    public MergeSorter(List<Integer> numbers, ExecutorService executorService) {
        this.numbers = numbers;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {

        int size = numbers.size();
        if(size<=1){
            return numbers; // If the list has 0 or 1 elements, it's already sorted
        }
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (i < size/2) {
                leftList.add(numbers.get(i));
            } else {
                rightList.add(numbers.get(i));
            }
        }

        MergeSorter leftSorter = new MergeSorter(leftList, executorService);
        MergeSorter rightSorter = new MergeSorter(rightList,executorService);

        // Submit the left and right halves to the executor service for sorting
        Future<List<Integer>> sortedLeft = executorService.submit(leftSorter);
        Future<List<Integer>> sortedRight = executorService.submit(rightSorter);

        // Wait for the left and right halves to be sorted
        List<Integer> leftSorted = sortedLeft.get();
        List<Integer> rightSorted = sortedRight.get();

        //the above two lines can be replaced with the below line if we want to use the executor service
        //List<Integer> sortedLeft = executorService.submit(leftSorter).get();

        // Merge the sorted halves
        int i=0;
        int j=0;

        List<Integer> sortedlist = new ArrayList<>();
        while(i<leftSorted.size() && j<rightSorted.size()){
          if(leftSorted.get(i) < rightSorted.get(j)){
              sortedlist.add(leftSorted.get(i));
                i++;
            } else {
              sortedlist.add(rightSorted.get(j));
                j++;
            }
        }
        while(i<leftSorted.size()){
            sortedlist.add(leftSorted.get(i));
            i++;
        }
        while(j<rightSorted.size()){
            sortedlist.add(rightSorted.get(j));
            j++;
        }
        return sortedlist;
    }
}
