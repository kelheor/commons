package com.academy.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kelheor on 21.06.2015.
 */
public class Flyweight {

    private final Map<MissileType, Missile> missiles = new HashMap<>();

    Missile createMissile(MissileType missileType) {
        Missile missile = missiles.get(missileType);
        if(missile == null) {
            switch (missileType) {
                case CRUISE_MISSILE:
                    missile = new CruiseMissile();
                    missiles.put(missileType, missile);
                    break;
                case NUCLEAR_MISSILE:
                    missile = new NuclearMissile();
                    missiles.put(missileType, missile);
                    break;
                default:
                    break;
            }
        }
        return missile;
    }
}
