package com.academy.patterns.adapter;

/**
 * Created by Kelheor on 06.06.2015.
 */
public class Adapter implements AvailableInterface {

    private RequiredEntity requiredEntity;

    public Adapter(RequiredEntity requiredEntity) {
        this.requiredEntity = requiredEntity;
    }

    @Override
    public void execute() {
        System.out.println("ADAPTER ENTITY EXECUTED");
        requiredEntity.execute();
    }
}
