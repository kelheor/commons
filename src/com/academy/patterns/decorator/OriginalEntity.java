package com.academy.patterns.decorator;

/**
 * Created by Kelheor on 07.06.2015.
 */
public class OriginalEntity implements Entity {

    @Override
    public void execute() {
        System.out.println("ORIGINAL ENTITY FUNCTIONALITY");
    }
}
