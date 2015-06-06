package com.academy.algorithms.sort.types;

/**
 * Created by Kelheor on 06.06.2015.
 */
public class MergeBottomUpSort extends MergeSort {

    @Override
    public void sort(Comparable[] array) {
        int N = array.length;
        Comparable[] aux = new Comparable[N];
        for (int n = 1; n < N; n = n+n) {
            for (int i = 0; i < N-n; i += n+n) {
                int lo = i;
                int mid  = i+n-1;
                int hi = Math.min(i+n+n-1, N-1);
                merge(array, aux, lo, mid, hi);
            }
        }
    }
}
