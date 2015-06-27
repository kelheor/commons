package com.academy.patterns.command;

import com.academy.patterns.shared.Weapon;

import java.beans.Visibility;

/**
 * Created by Kelheor on 27.06.2015.
 */
public abstract class Target {

    private DamageLevel damageLevel;

    public DamageLevel getDamageLevel() {
        return damageLevel;
    }

    public void setDamageLevel(DamageLevel damageLevel) {
        this.damageLevel = damageLevel;
    }

    @Override
    public abstract String toString();

    public void printStatus() {
        System.out.println(String.format("%s, [damageLevel=%s]", this,
                getDamageLevel()));
        System.out.println();
    }
}
