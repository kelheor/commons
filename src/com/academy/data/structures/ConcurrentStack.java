package com.academy.data.structures;

import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentStack<Item> {
    private int N;
    private Node<Item> first;
    private final ReentrantLock lock = new ReentrantLock();

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public ConcurrentStack() {
        first = null;
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

    public void push(Item item) {
        lock.lock();
        try {
            Node<Item> oldfirst = first;
            first = new Node<Item>();
            first.item = item;
            first.next = oldfirst;
            N++;
        } finally {
            lock.unlock();
        }
    }

    public Item pop() {
        lock.lock();
        try {
            if (isEmpty()) throw new NoSuchElementException("Stack underflow");
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        } finally {
            lock.unlock();
        }
    }

    public Item peek() {
        lock.lock();
        try {
            if (isEmpty()) throw new NoSuchElementException("Stack underflow");
            return first.item;
        } finally {
            lock.unlock();
        }
    }


}
