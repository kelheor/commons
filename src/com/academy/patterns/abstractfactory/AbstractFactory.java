package com.academy.patterns.abstractfactory;

import com.academy.patterns.shared.AbstractSystem;

/**
 * Created by keos on 08.06.15.
 */
public interface AbstractFactory {

    public AbstractSystem createSystem();
}
