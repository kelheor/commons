package com.academy.algorithms.sort.types;

import com.academy.algorithms.sort.SortType;

/**
 * Created by rnazirov on 02.06.2015.
 */
public class ShellSort extends SortType {

    @Override
    public void sort(Comparable[] array) {
        long startTime = System.nanoTime();

        int N = array.length;
        int h = 1;
        while (h<N/3) {
            h = 3*h + 1;
        }
        while (h>=1) {
            for(int i = h; i<N; i++) {
                for(int j = i; j>=h && less(array[j], array[j-h]); j -= h) {
                    exchange(array, j, j-h);
                }
            }
            h = h/3;
        }

        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime);
        System.out.println("SHELL SORT EXECUTION TIME: " + executionTime);
    }
}
