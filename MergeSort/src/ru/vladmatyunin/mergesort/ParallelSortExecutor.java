package ru.vladmatyunin.mergesort;

import ru.vladmatyunin.MyArraysUtils;
import ru.vladmatyunin.mergesort.MergeSorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Executes merge sorting in parallel
 */
public class ParallelSortExecutor {

    private int[] initialArray;

    private List<Thread> workers;

    private List<int[]> arraysToSort;

    private MergeSorter mergeHelper;

    public ParallelSortExecutor(){
        workers = new ArrayList<>();
        arraysToSort = new ArrayList<>();
        mergeHelper = new MergeSorter();
    }

    public int[] parallelSort(int [] arrayToSort) throws InterruptedException {
        this.initialArray = arrayToSort;
        // get available processors for best performance
        int processorsCount = Runtime.getRuntime().availableProcessors();
        Integer stepCount = initialArray.length / processorsCount;
        Integer sizeCount = 0;
        for (Integer i = 0; i < processorsCount; i++){
            int[] array = i!=processorsCount-1?
                    MyArraysUtils.splitArray(initialArray, sizeCount, sizeCount+stepCount)
                    :MyArraysUtils.splitArray(initialArray, sizeCount,initialArray.length);
            sizeCount+=stepCount;
            startSortJob(array);
        }
        syncThreads();
        return mergeSortedArrays();
    }

    private void startSortJob(int[] array){
        arraysToSort.add(array);
        Runnable runnable = () -> new MergeSorter().sort(array);
        Thread worker = new Thread(runnable);
        workers.add(worker);
        worker.start();
    }


    private void syncThreads() throws InterruptedException {
        for (Thread worker: workers){
            worker.join();
        }
    }

    private int[] mergeSortedArrays(){
        while (arraysToSort.size()!=1) {
            List<int[]> joinedSortedArrays = new ArrayList<>();
            for (int j = 0, i = 2*j; i <= arraysToSort.size()-2; j++, i = 2*j) {
                int[] leftArray = arraysToSort.get(i);
                int[] rightArray = arraysToSort.get(i+1);
                int middle = leftArray.length-1;
                int totalSize = leftArray.length+rightArray.length;
                int[] joinedArray = MyArraysUtils.joinArrays(leftArray,rightArray);
                mergeHelper.merge(joinedArray,0,middle,totalSize-1, true);
                arraysToSort.set(i, null);
                arraysToSort.set(i+1, null);
                joinedSortedArrays.add(joinedArray);
            }
            MyArraysUtils.mergeArrays(arraysToSort, joinedSortedArrays);
        }
        return arraysToSort.get(0);
    }


}
