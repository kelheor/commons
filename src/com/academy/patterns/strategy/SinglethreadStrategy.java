package com.academy.patterns.strategy;

/**
 * Created by keos on 05.06.15.
 */
public class SinglethreadStrategy implements Strategy {

    @Override
    public void execute() {
        System.out.println("Executing SinglethreadStrategy strategy");
    }
}
