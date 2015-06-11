package com.academy.patterns.observer;

/**
 * Created by keos on 11.06.15.
 */
public class Enemy extends Observable<Enemy, SpaceObserver, EnemyAction> {

    private EnemyAction action;

    public Enemy() {
        action = EnemyAction.DEFENSE;
    }

    public void executeAction(EnemyAction enemyAction) {
        action = enemyAction;
        notifyObservers(action);
    }
}
