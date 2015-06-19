package com.academy.patterns.servant;

/**
 * Created by keos on 19.06.15.
 */
public class Malevalensis implements SuborbitalBomber {

    private int ammo;

    @Override
    public void addAmmo(int count) {
        ammo += count;
    }

    public void attack() {
        System.out.println("MALEVALENSIS DROP OUT " + ammo + " THERMONUCLEAR BOMBS!");
    }
}
