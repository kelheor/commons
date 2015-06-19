package com.academy.patterns.servant;

/**
 * Created by keos on 19.06.15.
 */
public class Servant {

    public void provideAmmo(SuborbitalBomber suborbitalBomber) {
        suborbitalBomber.addAmmo(100);
    }
}
