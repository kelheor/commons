package com.academy.patterns.singleton;

import java.io.Serializable;

/**
 * Created by keos on 17.06.15.
 * Сериализуемая версия синглтона
 */
public class InitializingOnDemandHolderIdiom implements Serializable {

    private static final long serialVersionUID = 1L;

    private static class HelperHolder {
        public static final InitializingOnDemandHolderIdiom INSTANCE = new InitializingOnDemandHolderIdiom();
    }

    private InitializingOnDemandHolderIdiom() {}

    public static InitializingOnDemandHolderIdiom getInstance() {
        return HelperHolder.INSTANCE;
    }

    protected Object readResolve() { return getInstance(); }
}
