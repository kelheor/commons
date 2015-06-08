package com.academy.patterns.abstractfactory;

import com.academy.patterns.facade.AbstractSystem;
import com.academy.patterns.facade.DefenceSystem;

/**
 * Created by keos on 08.06.15.
 */
public class DefenceSystemFactory implements AbstractFactory {
    @Override
    public AbstractSystem createSystem() {
        return new DefenceSystem();
    }
}
