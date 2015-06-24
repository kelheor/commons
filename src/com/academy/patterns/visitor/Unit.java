package com.academy.patterns.visitor;

/**
 * Created by keos on 24.06.15.
 */
public abstract class Unit {

    private Unit[] children;

    public Unit(Unit... children) {
        this.children = children;
    }

    public void accept(Visitor visitor) {
        for(Unit unit : children) {
            unit.accept(visitor);
        }
    }
}
