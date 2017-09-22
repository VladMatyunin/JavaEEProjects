package ru.vladmatyunin;

import java.util.List;
import java.util.Scanner;

/**
 * Task Description:
 * We have an array of different Items with weight (supposed they are integers)
 * We also have two different containers, let it be bags
 * The task is to find the best combinations of Items in bags, so that the
 * weight difference between bags is the most minimal
 *
 * NOTE: no recursion to use
 */
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

        List<BagContainer> containers = BagIterator.execute(array);
        BagContainer finalResult = BagIterator.getBestResult(containers);
        System.out.print(finalResult.toString());
    }

}
