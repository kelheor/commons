package com.academy.algorithms.sort.types;

import com.academy.algorithms.sort.SortService;
import com.academy.algorithms.sort.SortType;

/**
 * Created by keos on 09.06.15.
 * Работает быстрее, чем обычная реализация сортировки с трехчастным разбиением
 * Использовать, когда есть много одинаковых элементов
 * Сложнее для понимания
 */
public class AdvancedQuick3WaySort extends SortType {

    private void sort(Comparable[] a, int lo, int hi) {
        int N = hi - lo + 1;

        if (hi <= lo + 15) {
            ((InsertionSort) SortService.INSERTION_SORT.getSortType()).sort(a, lo, hi);
            return;
        }

        // use median-of-3 as partitioning element
        else if (N <= 40) {
            int m = median3(a, lo, lo + N/2, hi);
            exchange(a, m, lo);
        }

        // use Tukey ninther as partitioning element
        else  {
            int eps = N/8;
            int mid = lo + N/2;
            int m1 = median3(a, lo, lo + eps, lo + eps + eps);
            int m2 = median3(a, mid - eps, mid, mid + eps);
            int m3 = median3(a, hi - eps - eps, hi - eps, hi);
            int ninther = median3(a, m1, m2, m3);
            exchange(a, ninther, lo);
        }

        // Bentley-McIlroy 3-way partitioning
        int i = lo, j = hi+1;
        int p = lo, q = hi+1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v))
                if (i == hi) break;
            while (less(v, a[--j]))
                if (j == lo) break;

            // pointers cross
            if (i == j && equal(a[i], v))
                exchange(a, ++p, i);
            if (i >= j) break;

            exchange(a, i, j);
            if (equal(a[i], v)) exchange(a, ++p, i);
            if (equal(a[j], v)) exchange(a, --q, j);
        }


        i = j + 1;
        for (int k = lo; k <= p; k++) exchange(a, k, j--);
        for (int k = hi; k >= q; k--) exchange(a, k, i++);

        sort(a, lo, j);
        sort(a, i, hi);
    }

    // return the index of the median element among a[i], a[j], and a[k]
    private int median3(Comparable[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ?
                (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
                (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
    }

    @Override
    public void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

}
