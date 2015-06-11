package com.academy.patterns.observer;

/**
 * Created by keos on 11.06.15.
 */
public class OrbitalSatellite implements SpaceObserver {


    @Override
    public void update(Enemy subject, EnemyAction argument) {
        System.out.println("ORBITAL SATTELITE DETECTS ENEMY ACTION: " + argument);
    }
}