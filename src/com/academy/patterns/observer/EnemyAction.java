package com.academy.patterns.observer;

/**
 * Created by keos on 11.06.15.
 */
public enum  EnemyAction {

    MOVE, ATTACK, DEFENSE;

    @Override
    public String toString() {
        return this.name();
    }
}
