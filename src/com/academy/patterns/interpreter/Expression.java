package com.academy.patterns.interpreter;

/**
 * Created by keos on 26.06.15.
 */
public abstract class Expression {

    public abstract int interpret();

    @Override
    public abstract String toString();
}
