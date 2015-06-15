package com.academy.data.structures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;

/**
 * Created by keos on 15.06.15.
 * Binary heap
 * Бинарная куча
 *
 * Позволяет реализовать очередь с приоритетами
 *
 * Нужно учесть, что ключи при этом не должны менятся извне, иначе это нарушит пирамидальность
 *
 * Чтобы изменить на minPQ нужно заменить функции less на greater!
 */
public class BinaryHeap<Key extends Comparable<Key>> implements Iterable<Key> {

    private Key[] heap;   // heap[0] не используется
    private int N;
    private boolean isMinHeap; // На вершине расположен минимальный элемент? По умолчанию false.

    public BinaryHeap(int initCapacity, boolean isMinHeap) {
        heap = (Key[]) new Comparable[initCapacity + 1];
        N = 0;
        this.isMinHeap = isMinHeap;
    }

    public BinaryHeap(int initCapacity) {
        this(initCapacity, false);
    }

    public BinaryHeap(boolean isMinHeap) {
        this(1, isMinHeap);
    }

    public BinaryHeap() {
        this(1,false);
    }


    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * Вставка элемента в нужную позицию пирамиды в зависимости от параметра isMinHeap
     * @param v Вставляемый элемент
     */
    public void insert(Key v) {
        if (N >= heap.length - 1) resize(2 * heap.length);
        heap[++N] = v;
        swim(N);
    }

    /**
     * Получение максимального или минимального элемента в зависимости от настроек isMinHeap
     * @return Key Максимальный или минимальный элемент
     */
    public Key poll() {
        Key value = heap[1];
        exch(1, N--); // Обмен с последним элементом, чтобы не было праздных ссылок
        sink(1);
        if ((N > 0) && (N == (heap.length - 1) / 4)) resize(heap.length / 2);
        return value;
    }

    private boolean less(int i, int j) {
            return ((Comparable<Key>) heap[i]).compareTo(heap[j]) < 0;
    }

    private boolean greater(int i, int j) {
            return ((Comparable<Key>) heap[i]).compareTo(heap[j]) > 0;
    }


    private void exch(int i, int j) {
        Key swap = heap[i];
        heap[i] = heap[j];
        heap[j] = swap;
    }

    private void swim(int k) {
        if(!isMinHeap) {
            while (k > 1 && less(k / 2, k)) {
                exch(k / 2, k);
                k = k / 2;
            }
        } else {
            while (k > 1 && greater(k / 2, k)) {
                exch(k / 2, k);
                k = k / 2;
            }
        }
    }

    private void sink(int k) {
        if(!isMinHeap) {
            while (2 * k <= N) {
                int j = 2 * k;
                if (j < N && less(j, j + 1)) {
                    j++;
                }
                if (!less(k, j)) break;
                exch(k, j);
                k = j;
            }
        } else {
            while (2 * k <= N) {
                int j = 2 * k;
                if (j < N && greater(j, j + 1)) {
                    j++;
                }
                if (!greater(k, j)) break;
                exch(k, j);
                k = j;
            }
        }
    }

    private void resize(int capacity) {
        if(capacity < N) {
            throw new IllegalArgumentException("NEW CAPACITY MUST BE MORE THAN CURRENT COUNT OF ELEMENTS");
        }
        Key[] temp = (Key[]) new Comparable[capacity];
        for (int i = 1; i <= N; i++) {temp[i] = heap[i];}
        heap = temp;
    }


    public Iterator<Key> iterator() { return new HeapIterator(); }

    private class HeapIterator implements Iterator<Key> {

        // create a new heap
        private BinaryHeap<Key> copy;

        // add all items to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            copy = new BinaryHeap<Key>(size());
            for (int i = 1; i <= N; i++)
                copy.insert(heap[i]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.poll();
        }
    }

}
