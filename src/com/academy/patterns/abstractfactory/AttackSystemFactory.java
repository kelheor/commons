package com.academy.patterns.abstractfactory;

import com.academy.patterns.shared.AbstractSystem;
import com.academy.patterns.shared.AttackSystem;

/**
 * Created by keos on 08.06.15.
 */
public class AttackSystemFactory implements AbstractFactory {

    @Override
    public AbstractSystem createSystem() {
        return new AttackSystem();
    }
}
