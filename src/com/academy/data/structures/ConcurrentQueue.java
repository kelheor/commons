package com.academy.data.structures;

import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Kelheor on 12.06.2015.
 */
public class ConcurrentQueue<Item> {

    private int N;
    private Node<Item> first;
    private Node<Item> last;
    private final ReentrantLock lock = new ReentrantLock();

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public ConcurrentQueue() {
        first = null;
        last  = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        lock.lock();
        try {
            return N;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Получаем первый элемент без удаления его из очереди
     * @return
     */
    public Item peek() {
        lock.lock();
        try {
            if (isEmpty()) throw new NoSuchElementException("Queue underflow");
            return first.item;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Помещаем элемент в конец очереди
     * @param item
     */
    public void enqueue(Item item) {
        lock.lock();
        try {
            Node<Item> oldlast = last;
            last = new Node<Item>();
            last.item = item;
            last.next = null;
            if (isEmpty()) first = last;
            else           oldlast.next = last;
            N++;
        } finally {
            lock.unlock();
        }
    }
    
    /**
     * Забираем первый элемент из очереди
     * @return
     */
    public Item dequeue() {
        lock.lock();
        try {
            if (isEmpty()) throw new NoSuchElementException("Queue underflow");
            Item item = first.item;
            first = first.next;
            N--;
            if (isEmpty()) last = null;   // to avoid loitering
            return item;
        } finally {
            lock.unlock();
        }
    }

}
