package com.academy.patterns.shared;

/**
 * Created by Kelheor on 07.06.2015.
 */
public class DefenceSystem extends AbstractSystem {

    @Override
    public void execute() {
        executeActions(Action.DEFENCE);
    }
}
