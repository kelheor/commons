package com.academy.patterns.prototype;

import com.academy.patterns.builder.CyberBattleship;
import com.academy.patterns.property.Weapon;

/**
 * Created by keos on 08.06.15.
 */
public class App {
    public static void main(String[] args) {

        // Создаем прототип и на основе него клонируем объекты

        CyberBattleship prototype = new CyberBattleship();
        prototype.setWeapon(Weapon.ARTILLERY, 1);

        CyberBattleship cyberBattleship = prototype.clone();
        System.out.println("ARTILLERY: " + cyberBattleship.getWeapon(Weapon.ARTILLERY));
    }
}
