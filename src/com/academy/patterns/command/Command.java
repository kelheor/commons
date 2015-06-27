package com.academy.patterns.command;

/**
 * Created by Kelheor on 27.06.2015.
 */
public abstract class Command {

    public abstract void execute(Target target);

    public abstract void undo();

    public abstract void redo();

    @Override
    public abstract String toString();

}
