package com.academy.algorithms.sort.types;

import com.academy.algorithms.sort.SortType;

/**
 * Created by rnazirov on 02.06.2015.
 */
public class CocktailSort extends SortType {

    @Override
    public void sort(Comparable[] array) {
        long startTime = System.nanoTime();
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            for(int i = left; i < right; i++) {
                if(greater(array[i], array[i+1])) {
                    exchange(array, i,i+1);
                }
            }
            right--;

            for(int i = right; i>left; i--) {
                if(less(array[i], array[i-1])) {
                    exchange(array, i, i-1);
                }
            }
            left++;
        }
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime);
        System.out.println("COCKTAIL SORT EXECUTION TIME: " + executionTime);
    }
}
