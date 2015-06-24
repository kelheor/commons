package com.academy.patterns.visitor;

/**
 * Created by keos on 24.06.15.
 */
public class ArtillerySquad extends Unit {

    public ArtillerySquad(Unit... children) {
        super(children);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitArtillery();
        super.accept(visitor);
    }
}
