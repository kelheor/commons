package com.academy.patterns.command;

/**
 * Created by Kelheor on 27.06.2015.
 */
public class EnemyCruiser extends Target {

    public EnemyCruiser() {
        setDamageLevel(DamageLevel.NONE);
    }

    @Override
    public String toString() {
        return "Enemy Cruiser";
    }
}
