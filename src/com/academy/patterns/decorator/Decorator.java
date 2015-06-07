package com.academy.patterns.decorator;

/**
 * Created by Kelheor on 07.06.2015.
 */
public class Decorator implements Entity {

    private Entity entity;

    public Decorator(Entity entity) {
        this.entity = entity;
    }

    @Override
    public void execute() {
        System.out.println("DECORATOR FUNCTIONALITY");
        entity.execute();
    }
}
