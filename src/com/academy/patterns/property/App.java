package com.academy.patterns.property;

import com.academy.patterns.shared.CyberBattleship;
import com.academy.patterns.shared.AttackSystem;
import com.academy.patterns.shared.Weapon;

/**
 * Created by keos on 08.06.15.
 */
public class App {
    public static void main(String[] args) {

        // Динамическое добавление свойств в объект
        // Кроме того, все сделано так, что свойства можно унаследовать в предках

        System.out.println("DEFAULT CYBER BATTLESHIP");
        CyberBattleship cyberBattleship = new CyberBattleship();
        cyberBattleship.setWeapon(Weapon.GAUSS_GUNS, 10);
        System.out.println("GAUSS GUNS: " + cyberBattleship.getWeapon(Weapon.GAUSS_GUNS));

        System.out.println();

        System.out.println("ETERNITY CYBER BATTLESHIP");
        CyberBattleship eternityBattleship = new CyberBattleship(cyberBattleship);
        System.out.println("GAUSS GUNS: " + eternityBattleship.getWeapon(Weapon.GAUSS_GUNS));
        eternityBattleship.getSystems().add(new AttackSystem());
        eternityBattleship.setWeapon(Weapon.ROCKETS, 100);
        System.out.println("ROCKETS: " + eternityBattleship.getWeapon(Weapon.ROCKETS));
    }
}
