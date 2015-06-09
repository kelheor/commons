package com.academy.algorithms.sort.types;

import com.academy.algorithms.sort.SortService;
import com.academy.algorithms.sort.SortType;

import java.util.Random;

/**
 * Created by keos on 09.06.15.
 * Применять, если планируется большое количество одинаковых элементов!
 * Тогда будет работать быстрее, чем обычная быстрая сортировка
 */
public class Quick3WaySort extends SortType {

    private Random random = new Random();

    @Override
    public void sort(Comparable[] array) {
        shuffle(array);
        sort(array, 0, array.length -1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo + 15) {
            ((InsertionSort)SortService.INSERTION_SORT.getSortType()).sort(a, lo, hi);
            return;
        }

        // Пробегаемся по массиву вперед
        // После пробега в центре будут равные элементы, слева - меньшие, справа - большие
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if      (cmp < 0) exchange(a, lt++, i++);
            else if (cmp > 0) exchange(a, i, gt--);
            else              i++;
        }

        // Далее сортируем левую и правую часть, оставив в середине равные элементы
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }


    /**
     * Rearrange the elements of an array in random order.
     */
    public void shuffle(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + uniform(N-i);     // between i and N-1
            Comparable temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public int uniform(int N) {
        if (N <= 0) throw new IllegalArgumentException("Parameter N must be positive");
        return random.nextInt(N);
    }
}
