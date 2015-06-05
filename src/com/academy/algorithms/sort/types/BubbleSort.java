package com.academy.algorithms.sort.types;

import com.academy.algorithms.sort.SortType;

/**
 * Created by rnazirov on 02.06.2015.
 */
public class BubbleSort extends SortType {

    @Override
    public void sort(Comparable[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length; j++) {
                if(less(array[i], array[j])) {
                    exchange(array, i, j);
                }
            }
        }
    }

}
