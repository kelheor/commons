package com.academy.patterns.lazyloading;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by keos on 30.06.15.
 */
public class ThreadSafeHolder {

    private Heavy heavy;
    private ReentrantLock reentrantLock;

    public Heavy getHeavy() {
        if(heavy == null) {
            reentrantLock.lock();
            try {
                if (heavy == null) {
                    heavy = new Heavy();
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return heavy;
    }
}
