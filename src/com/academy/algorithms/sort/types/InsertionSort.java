package com.academy.algorithms.sort.types;

import com.academy.algorithms.sort.SortType;

/**
 * Created by rnazirov on 03.06.2015.
 */
public class InsertionSort extends SortType {

    @Override
    public void sort(Comparable[] array) {
        int N = array.length;
        for(int i = 1; i < N; i++) {
            for(int j = i; j > 0 && less(array[j], array[j-1]); j--) {
                exchange(array, j, j-1);
            }
        }
    }

    public void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exchange(a, j, j-1);
    }
}