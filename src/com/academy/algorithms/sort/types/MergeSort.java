package com.academy.algorithms.sort.types;

import com.academy.algorithms.sort.SortType;

/**
 * Created by keos on 05.06.15.
 */
public class MergeSort extends SortType {

    private void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exchange(a, j, j - 1);
    }

    public void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {
        if (hi <= lo + 6) {
            insertionSort(dst, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(dst, src, lo, mid);
        sort(dst, src, mid+1, hi);

        // using System.arraycopy() is a bit faster than the above loop
        if (!less(src[mid+1], src[mid])) {
            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }

        merge(src, dst, lo, mid, hi);
    }

    private void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              dst[k] = src[j++];
            else if (j > hi)               dst[k] = src[i++];
            else if (less(src[j], src[i])) dst[k] = src[j++];   // to ensure stability
            else                           dst[k] = src[i++];
        }
    }

    @Override
    public void sort(Comparable[] array) {
        Comparable[] aux = array.clone();
        sort(aux, array, 0, array.length - 1);
    }
}