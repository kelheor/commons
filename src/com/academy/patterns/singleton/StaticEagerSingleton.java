package com.academy.patterns.singleton;

/**
 * Created by keos on 17.06.15.
 */
public class StaticEagerSingleton {

    private static StaticEagerSingleton instance = new StaticEagerSingleton();

    private StaticEagerSingleton() {

    }

    public static StaticEagerSingleton getInstance() {
        return instance;
    }

}
