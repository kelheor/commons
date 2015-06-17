package com.academy.patterns.singleton;

/**
 * Created by keos on 17.06.15.
 */
public class ThreadSafeLazyLoadedSingleton {
    private static ThreadSafeLazyLoadedSingleton instance = null;

    private ThreadSafeLazyLoadedSingleton() {

    }

    public synchronized static ThreadSafeLazyLoadedSingleton getInstance() {
        if(instance == null) {
            instance = new ThreadSafeLazyLoadedSingleton();
        }
        return instance;
    }
}
