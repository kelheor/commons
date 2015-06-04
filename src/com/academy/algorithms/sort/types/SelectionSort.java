package com.academy.algorithms.sort.types;

import com.academy.algorithms.sort.SortType;

/**
 * Created by rnazirov on 02.06.2015.
 */
public class SelectionSort extends SortType {

    @Override
    public void sort(Comparable[] array) {
        long startTime = System.nanoTime();
        int N = array.length;
        for(int i = 0; i < N; i++) {
            int min = i;
            for(int j = i+1; j <  N; j++) {
                if(less(array[j], array[min])) {
                    min = j;
                }
            }
            exchange(array, i, min);
        }
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime);
        System.out.println("SELECTION SORT EXECUTION TIME: " + executionTime);
    }
}
