package com.academy.algorithms.sort.types;

import com.academy.algorithms.sort.SortType;

/**
 * Created by keos on 17.06.15.
 */
public class HeapSort extends SortType {

    @Override
    public void sort(Comparable[] array) {
        int N = array.length;
        // Создаем из массива бинарную пирамиду
        for (int k = N/2; k >= 1; k--)
            sink(array, k, N);
        // Повторяем, пока не пройдем по всем элементам и не получим отсортированный массив
        while (N > 1) {
            // Меняем первый самый большой элемент на самый последний, так что на самом низу теперь будет максимальный элемент
            // При этом уменьшаем N, чтобы потом этот перемещенный элемент не обрабатывать
            exch(array, 1, N--);
            // Используя первый элемент, восстанавливаем пирамидальность, чтобы в корне снова был самый максимальный элемент
            sink(array, 1, N);
        }
    }

    private static void sink(Comparable[] pq, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

}
