package com.academy.algorithms.sort.types;

import com.academy.algorithms.sort.SortType;

/**
 * Created by rnazirov on 03.06.2015.
 */
public class InsertionSort extends SortType {

    @Override
    public void sort(Comparable[] array) {
        long startTime = System.nanoTime();
        int N = array.length;
        for(int i = 1; i < N; i++) {
            for(int j = i; j > 0 && less(array[j], array[j-1]); j--) {
                exchange(array, j, j-1);
            }
        }
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime);
        System.out.println("INSERTION SORT EXECUTION TIME: " + executionTime);
    }
}