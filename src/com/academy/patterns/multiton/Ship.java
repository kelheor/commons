package com.academy.patterns.multiton;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by keos on 15.06.15.
 */
public class Ship {

    private static Map<String, Ship> ships;

    private String name;

    static {
        ships = new HashMap<>();
        ships.put("SELENDIS", new Ship("SELENDIS"));
        ships.put("AUVERGEN", new Ship("AUVERGEN"));
    }

    private Ship(String name) {
        this.name = name;
    }

    public static Ship getInstance(String name) {
        return ships.get(name);
    }

    public String getName() {
        return name;
    }
}
