package ru.vladmatyunin.mergesort;

/**
 * Created by Vlad on 26.09.2017.
 */
public class MergeSorter {
    private int[] array;
    private int[] buffer;

    public int[] sort(int[] array){
        this.array = array;
        buffer = new int[array.length];
        sortMerge(0, array.length-1);
        return array;
    }
    private void sortMerge(int start, int end){
        // the only element to sort -> exit
        if (start<end) {
            int middle = start+(end-start) / 2;
            sortMerge(start, middle);
            sortMerge(middle+1, end);
            merge(array, start, middle, end, false);
        }
    }
    void merge(int[] array, int start, int middle, int end, boolean helper){
        if (helper) buffer = new int[array.length];
        for (int i = start; i <= end; i++) {
            buffer[i] = array[i];
        }

        int i = start;
        int j = middle + 1;
        int k = start;

        while (i <= middle && j <= end) {
            if (buffer[i] <= buffer[j]) {
                array[k] = buffer[i];
                i++;
            } else {
                array[k] = buffer[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = buffer[i];
            k++;
            i++;
        }
    }
}
