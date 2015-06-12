package com.academy.patterns.state;

/**
 * Created by Kelheor on 12.06.2015.
 */
public class ActiveState implements State {

    @Override
    public void observe() {
        System.out.println("SYSTEM IN ACTIVE STATE");
    }
}
