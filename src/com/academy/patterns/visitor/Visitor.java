package com.academy.patterns.visitor;

/**
 * Created by keos on 24.06.15.
 */
public interface Visitor {

    void visitCommander();

    void visitArtillery();

    void visitInfantry();
}
