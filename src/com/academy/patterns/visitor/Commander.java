package com.academy.patterns.visitor;

/**
 * Created by keos on 24.06.15.
 */
public class Commander extends Unit {

    public Commander(Unit... children) {
        super(children);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCommander();
        super.accept(visitor);
    }
}
