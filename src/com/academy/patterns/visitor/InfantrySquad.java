package com.academy.patterns.visitor;

/**
 * Created by keos on 24.06.15.
 */
public class InfantrySquad extends Unit {

    public InfantrySquad(Unit... children) {
        super(children);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitInfantry();
        super.accept(visitor);
    }
}
