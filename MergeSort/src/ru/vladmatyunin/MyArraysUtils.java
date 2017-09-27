package ru.vladmatyunin;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Helper class
 */
public class MyArraysUtils {
    /**
     * Create new instance from 2 arrays, representing concat of both
     */
    public static int[] joinArrays(int[] array1, int[] array2){
        int[] joinedArray = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, joinedArray, 0, array1.length);
        System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
        return joinedArray;
    }

    /**
     * Merge both Lists to first one, removing null elements
     * @param arraysToSort - the list to update (remove null and put values from joinedArrays)
     * @param joinedArrays - list to put to the first argument
     * @return concat list, pointer is the same as arraysToSort
     */
    public static List<int[]> mergeArrays(List<int[]> arraysToSort, List<int[]> joinedArrays){
        arraysToSort.removeAll(Collections.singleton(null));
        arraysToSort.addAll(joinedArrays);
        return arraysToSort;
    }

    /**
     * copy from array argument values from 'from' to 'to'
     * creates new instance
     * @param array from which to copy
     * @param from - position, Integer -> reference is passed and updated globally
     * @param to - the same as 'from', the end position to copy
     * @return - copied array
     */
    public static int[] splitArray(int[] array, Integer from, Integer to) {
        int[] result = Arrays.copyOfRange(array, from, to);
        from = to;
        return result;
    }

    /**
     * @param size - array size
     * @return random array with size 'size' of ints from 10 to 10+'size'
     */
    public static int[] generate(int size) {
        Random random = new Random();
        return random.ints(size,10,10+size).toArray();
    }
}
