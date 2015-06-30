package com.academy.patterns.lazyloading;

/**
 * Created by keos on 30.06.15.
 */
public class NonThreadSafeHolder {

    private Heavy heavy;

    public Heavy getHeavy() {
        if(heavy == null) {
            heavy = new Heavy();
        }
        return heavy;
    }
}
