package com.academy.patterns.property;

/**
 * Created by keos on 08.06.15.
 */
public interface WeaponPrototype {
    Integer getWeapon(Weapon weapon);
    boolean hasWeapon(Weapon weapon);
    void  setWeapon(Weapon weapon, Integer value);
    void removeWeapon(Weapon weapon);
}
