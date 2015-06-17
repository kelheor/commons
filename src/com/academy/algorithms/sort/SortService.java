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
    JAVA_ARRAY_SORT(new JavaArraySort()),
    MERGE_SORT(new MergeSort()),
    MERGE_BOTTOM_UP_SORT(new MergeBottomUpSort()),
    HEAP_SORT(new HeapSort()),
    SHELL_SORT(new ShellSort()),
    QUICK_SORT(new QuickSort()),
    QUICK_3_WAY_SORT(new Quick3WaySort()),
    ADVANCED_3_WAY_SORT(new AdvancedQuick3WaySort());

    private SortType sortType;

    SortService(SortType sortType) {
        this.sortType = sortType;
    }

    public SortType getSortType() {
        return sortType;
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
        sortType.execute(array);
        //show(array);
        System.out.println();
        assert isSorted(array);
    }



}
