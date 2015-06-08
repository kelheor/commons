package com.academy.patterns.facade;

import com.academy.patterns.shared.AbstractSystem;
import com.academy.patterns.shared.AttackSystem;
import com.academy.patterns.shared.DefenceSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kelheor on 07.06.2015.
 */
public class SystemsFacade {

    private final List<AbstractSystem> systems;

    public SystemsFacade() {
        systems = new ArrayList<>();
        systems.add(new AttackSystem());
        systems.add(new DefenceSystem());
    }

    public void executeAll() {
        systems.stream().parallel().forEach(AbstractSystem::execute);
    }

    public void executeFireSystem() {
        systems.get(0).execute();
    }

    public void executeDefenceSystem() {
        systems.get(1).execute();
    }

}
