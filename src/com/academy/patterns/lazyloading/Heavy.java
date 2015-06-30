package com.academy.patterns.lazyloading;

/**
 * Created by keos on 30.06.15.
 */
public class Heavy {

    public Heavy() {
        System.out.println("Initialization started...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Initialization ended.");
    }
}
