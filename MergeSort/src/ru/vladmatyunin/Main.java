package ru.vladmatyunin;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Write array size:");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        System.out.println("Write array:");
        int[] array = new int[size];
        for (int i = 0; i < size; i++){
            array[i] = scanner.nextInt();
        }
        MergeSorter mergeSorter = new MergeSorter();
        int[] sortedArray = mergeSorter.sort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
