package com.academy.patterns.command;

/**
 * Created by Kelheor on 27.06.2015.
 */
public enum DamageLevel {

    NONE, LOW, MEDIUM, HIGH;

    public static DamageLevel getIncreasedDamageLevel(DamageLevel damageLevel) {
        switch (damageLevel) {
            case NONE: return LOW;
            case LOW: return MEDIUM;
            case MEDIUM: return HIGH;
            default: return null;
        }
    }
}
