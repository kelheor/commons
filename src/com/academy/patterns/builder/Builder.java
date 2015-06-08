package com.academy.patterns.builder;

import com.academy.patterns.facade.AbstractSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by keos on 08.06.15.
 */
public class Builder {

    private List<AbstractSystem> abstractSystems = new ArrayList<>();

    public Builder addSystem(AbstractSystem abstractSystem) {
        abstractSystems.add(abstractSystem);
        return this;
    }

    public CyberBattleship build() {
        return new CyberBattleship(this);
    }

    public List<AbstractSystem> getAbstractSystems() {
        return abstractSystems;
    }
}
