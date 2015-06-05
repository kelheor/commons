package com.academy.algorithms.sort.types;

import com.academy.algorithms.sort.SortType;

/**
 * Created by keos on 05.06.15.
 */
public class MergeSort extends SortType {

    private Comparable[] aux;

    public void sort(Comparable[] array, int lo, int hi) {
        if(hi <= lo) {
            return;
        }
        int mid = lo + (hi-lo)/2;
        sort(array, lo, mid);
        merge(array, lo, mid, hi);
    }

    private void merge(Comparable[] array, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        for(int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }

        for(int k = lo; k<=hi; k++) {
            if(i>mid) {
                array[k] = aux[j++];
            } else if(j>hi) {
                array[k] = aux[i++];
            } else if(less(aux[j], aux[i])) {
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }
    }

    @Override
    public void sort(Comparable[] array) {
        aux = new Comparable[array.length];
        sort(array, 0, array.length - 1);
    }
}