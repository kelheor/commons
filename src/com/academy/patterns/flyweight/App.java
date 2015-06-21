package com.academy.patterns.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kelheor on 21.06.2015.
 */
public class App {

    public static void main(String[] args) {
        // Flyweight шарит инстансы объектов, уменьшая затраты на ресурсы. Нужно использовать, когда много объектов.
        // По сути его можно представить как Lazy-multiton, где объекты создаются один раз и по требованию
        // Но при этом это lazy-multiton в рамках фабрики, которая его создает. В нашем случае это flyweight
        Flyweight flyweight = new Flyweight();
        List<Missile> missiles = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            if(i%2 == 0) {
                missiles.add(flyweight.createMissile(MissileType.CRUISE_MISSILE));
            } else {
                missiles.add(flyweight.createMissile(MissileType.NUCLEAR_MISSILE));
            }
        }

        for(Missile missile : missiles) {
            missile.info();
        }

    }
}
