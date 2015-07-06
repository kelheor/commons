package com.academy.patterns.specification;

import com.academy.patterns.shared.CyberBattleship;
import com.academy.patterns.shared.Weapon;

import java.util.function.Predicate;

/**
 * Created by keos on 06.07.15.
 */
public class RocketSelector implements Predicate<CyberBattleship> {

    @Override
    public boolean test(CyberBattleship cyberBattleship) {
        return cyberBattleship.getWeapon(Weapon.ROCKETS) != null;
    }
}
