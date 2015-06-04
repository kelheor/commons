package com.academy.algorithms.sort.types;

import com.academy.algorithms.sort.SortType;

import java.util.Arrays;

/**
 * Created by rnazirov on 02.06.2015.
 */
public class JavaArraySort extends SortType {

    @Override
    public void sort(Comparable[] array) {
        long startTime = System.nanoTime();
        Arrays.sort(array);
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime);
        System.out.println("JAVA ARRAY SORT EXECUTION TIME: " + executionTime);
    }
}
