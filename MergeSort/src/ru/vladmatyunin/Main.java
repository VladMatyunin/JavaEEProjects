package ru.vladmatyunin;

import ru.vladmatyunin.mergesort.MergeSorter;
import ru.vladmatyunin.mergesort.ParallelSortExecutor;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Write array size:");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        System.out.println("Write array:");
        int[] array = new int[size];
        for (int i = 0; i < size; i++){
            array[i] = scanner.nextInt();
        }
        //MergeSorter mergeSorter = new MergeSorter();
        //int[] sortedArray = mergeSorter.sort(array);
        int[] sortedArray = new ParallelSortExecutor().parallelSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
