package com.academy.patterns.bridge;

/**
 * Created by keos on 09.06.15.
 */
// Абстракция
public class DefenceModule extends Module {

    public DefenceModule(DefenceModuleImpl defenceModule) {
        super(defenceModule);
    }

    public DefenceModuleImpl getModule() {
        return (DefenceModuleImpl) module;
    }

    @Override
    public void process() {
        getModule().process();
    }
}
