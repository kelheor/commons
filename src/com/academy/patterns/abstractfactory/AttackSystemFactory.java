package com.academy.patterns.abstractfactory;

import com.academy.patterns.facade.AbstractSystem;
import com.academy.patterns.facade.AttackSystem;

/**
 * Created by keos on 08.06.15.
 */
public class AttackSystemFactory implements AbstractFactory {

    @Override
    public AbstractSystem createSystem() {
        return new AttackSystem();
    }
}
