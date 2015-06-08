package com.academy.patterns.builder;

import com.academy.patterns.facade.AttackSystem;
import com.academy.patterns.facade.DefenceSystem;

/**
 * Created by keos on 08.06.15.
 */
public class App {
    public static void main(String[] args) {
        // Создание объекта с помощью builder'а
        CyberBattleship cyberBattleship = new Builder().addSystem(new DefenceSystem()).addSystem(new AttackSystem()).build();
        cyberBattleship.invokeAllSystems();
    }
}
