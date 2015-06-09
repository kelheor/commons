package com.academy.patterns.bridge;

/**
 * Created by keos on 09.06.15.
 */
public abstract class Module {

    protected ModuleImpl module;

    public Module(ModuleImpl module) {
        this.module = module;
    }

    public abstract void process();

    public ModuleImpl getModule() {
        return module;
    }
}
