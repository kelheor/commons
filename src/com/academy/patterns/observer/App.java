package com.academy.patterns.observer;

/**
 * Created by keos on 11.06.15.
 */
public class App {
    public static void main(String[] args) {
        Enemy enemy = new Enemy();
        OrbitalSatellite orbitalSatellite = new OrbitalSatellite();
        enemy.addObserver(orbitalSatellite);
        enemy.executeAction(EnemyAction.MOVE);
        enemy.executeAction(EnemyAction.ATTACK);
        enemy.executeAction(EnemyAction.DEFENSE);
    }
}
