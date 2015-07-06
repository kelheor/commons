package com.academy.patterns.specification;

import com.academy.patterns.shared.AttackSystem;
import com.academy.patterns.shared.CyberBattleship;
import com.academy.patterns.shared.DefenceSystem;
import com.academy.patterns.shared.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by keos on 06.07.15.
 */
public class App {
    public static void main(String[] args) {
        // Спецификация разделяет методы выборки кандидата от кандидата, которого нужно сопоставить с кем-то.
        // Используется, когда нам нужно найти что-то по определенным критериям
        CyberBattleship atlantis = new CyberBattleship("atlantis");
        atlantis.getSystems().add(new AttackSystem());
        atlantis.setWeapon(Weapon.GAUSS_GUNS, 100);

        CyberBattleship selendis = new CyberBattleship(atlantis, "selendis");
        selendis.getSystems().add(new DefenceSystem());
        selendis.setWeapon(Weapon.LASERS, 1000);

        CyberBattleship eternity = new CyberBattleship(selendis, "eternity");
        eternity.getSystems().add(new AttackSystem());
        eternity.setWeapon(Weapon.ROCKETS, 10000);

        List<CyberBattleship> cyberBattleships = new ArrayList<>();
        cyberBattleships.add(atlantis);
        cyberBattleships.add(selendis);
        cyberBattleships.add(eternity);

        System.out.println("FIND ROCKET WEAPONS");
        List<CyberBattleship> rocketCB = cyberBattleships.stream().filter(new RocketSelector()).collect(Collectors.toList());
        rocketCB.stream().forEach(System.out::println);
    }
}
