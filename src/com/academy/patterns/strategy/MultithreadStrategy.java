package com.academy.patterns.strategy;

/**
 * Created by keos on 05.06.15.
 */
public class MultithreadStrategy implements Strategy {

    @Override
    public synchronized void execute() {
        System.out.println("Executing MultithreadStrategy strategy");
    }
}
