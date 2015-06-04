package com.academy.algorithms.sort;

import com.academy.algorithms.sort.types.*;

/**
 * Created by rnazirov on 02.06.2015.
 */
public enum SortService {

    BUBBLE_SORT(new BubbleSort()),
    COCKTAIL_SORT(new CocktailSort()),
    SELECTION_SORT(new SelectionSort()),
    INSERTION_SORT(new InsertionSort()),
    SHELL_SORT(new ShellSort()),
    JAVA_ARRAY_SORT(new JavaArraySort());

    private SortType sortType;

    SortService(SortType sortType) {
        this.sortType = sortType;
    }

    public void show(Comparable[] array) {
        for(Comparable comparable : array) {
            System.out.print(comparable + " ");
        }
        System.out.println();
    }

    public boolean isSorted(Comparable[] array) {
        for(int i = 1; i < array.length; i++) {
            if(sortType.less(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public void sort(Comparable[] array) {
        sortType.sort(array);
        //show(array);
        System.out.println();
        assert isSorted(array);
    }



}
