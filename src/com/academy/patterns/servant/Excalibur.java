package com.academy.patterns.servant;

/**
 * Created by keos on 19.06.15.
 */
public class Excalibur implements SuborbitalBomber {

    private int ammo;

    @Override
    public void addAmmo(int count) {
        ammo += count;
    }

    public void attack() {
        System.out.println("EXCALIBUR DROP OUT " + ammo + " PHOTON BOMBS!");
    }
}
