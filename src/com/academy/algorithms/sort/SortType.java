package com.academy.algorithms.sort;

/**
 * Created by rnazirov on 02.06.2015.
 */
public abstract class SortType {

    public abstract void sort(Comparable[] array);

    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    public boolean equal(Comparable v, Comparable w) {
        return v.compareTo(w) == 0;
    }

    public void exchange(Comparable[] array, int i, int j) {
        Comparable cache = array[i];
        array[i] = array[j];
        array[j] = cache;
    }
}
