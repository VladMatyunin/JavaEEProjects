package ru.vladmatyunin;

import ru.vladmatyunin.mergesort.MergeSorter;
import ru.vladmatyunin.mergesort.ParallelSortExecutor;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Write array size:");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        System.out.println("Generate?(y/n)");
        String generate = scanner.next();
        int[] array;
        if (generate.toLowerCase().equals("y")){
            array = MyArraysUtils.generate(size);

        }
        else {
            System.out.println("Write array:");
            array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }
        }
        executeSpeedUp(array);
    }
    private static void executeSpeedUp(int[] array){
        try {

            long timeParallel = executeSpeedUp(array, true);
            long time = executeSpeedUp(array, false);
            System.out.println("NOT PARALLEL: " + time);
            System.out.println("PARALLEL: " + timeParallel);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

    }
    private static long executeSpeedUp(int[] array, boolean parallel) throws InterruptedException {
        long timeStart = System.nanoTime();
        execute(array, parallel);
        long timeEnd = System.nanoTime();
        return timeEnd - timeStart;
    }
    private static void execute(int[] array, boolean parallel) throws InterruptedException {
        //System.out.println(Arrays.toString(array));
        int[] sortedArray = null;
        if (parallel){
            sortedArray = new ParallelSortExecutor().parallelSort(array);
        }
        else {
            MergeSorter mergeSorter = new MergeSorter();
            sortedArray = mergeSorter.sort(array);
        }
        //System.out.println(Arrays.toString(sortedArray));
    }
}
