package com.academy.patterns.objectpool;

import java.util.HashSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rnazirov on 03.06.2015.
 */
public abstract class ObjectPool<T> {

    private HashSet<T> available = new HashSet<>();
    private HashSet<T> inUse = new HashSet<>();
    private Lock lock = new ReentrantLock();

    protected abstract T create();

    public T checkout() {
        lock.lock();
        try {
            if(available.size() <= 0) {
                available.add(create());
            }
            T instance = available.iterator().next();
            available.remove(instance);
            inUse.add(instance);
            return instance;
        } finally {
            lock.unlock();
        }
    }

    public void checkin(T instance) {
        lock.lock();
        try {
            inUse.remove(instance);
            available.add(instance);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "ObjectPool{" +
                "available=" + available.size() +
                ", inUse=" + inUse.size() +
                '}';
    }
}
