package com.academy.algorithms.sort.types;

import com.academy.algorithms.sort.SortService;
import com.academy.algorithms.sort.SortType;

import java.util.Random;

/**
 * Created by Kelheor on 07.06.2015.
 */
public class QuickSort extends SortType {

    private Random random = new Random();

    @Override
    public void sort(Comparable[] array) {
        shuffle(array);
        sort(array, 0, array.length -1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo + 15) {
            ((InsertionSort) SortService.INSERTION_SORT.getSortType()).sort(a, lo, hi);
            return;
        }
        int j = partition(a,lo,hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        // Берем опорную точку и сортируем массив так, чтобы слева от нее были элементы меньше, а справа больше
        // При этом в конце этого метода опорная точка встает в ту позицию, чтобы выполнялось условие: a[lo..j-1] <= a[j] <= a[j+1..hi]
        // Далее делим массив от опорной точки на два подмассива и там выполняем подобную процедуру
        int i = lo;
        int j = hi+1;
        Comparable v = a[lo];
        while (true) {
            // Вычисляем элемент, который будет больше V. Начинаем пробег по массиву слева. I всегда больше lo как минимум на 1.
            while(less(a[++i], v)) {
                if(i == hi) {
                    break;
                }
            }
            // Вычисляем элемент, который будет меньше V. Начинаем пробег по массиву справа.
            while (less(v, a[--j])) {
                if(j == lo) {
                    break;
                }
            }
            if(i >= j) {
                break;
            }
            exchange(a, i, j);
        }
        // Помещение v = a[j] на место так, что a[lo..j-1] <= a[j] <= a[j+1..hi]
        // Меняем a[lo] на a[j]
        exchange(a, lo, j);
        return j;
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
