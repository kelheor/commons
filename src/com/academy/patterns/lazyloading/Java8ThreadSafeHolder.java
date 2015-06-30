package com.academy.patterns.lazyloading;

import java.util.function.Supplier;

/**
 * Created by keos on 30.06.15.
 */
public class Java8ThreadSafeHolder {

    private Supplier<Heavy> heavy = () -> createAndCacheHeavy();

    public Heavy getHeavy() {
        return heavy.get();
    }

    private synchronized Heavy createAndCacheHeavy() {
        class HeavyFactory implements Supplier<Heavy> {
            private final Heavy heavyInstance = new Heavy();
            @Override
            public Heavy get() {
                return heavyInstance;
            }
        }
        if(!HeavyFactory.class.isInstance(heavy)) {
            heavy = new HeavyFactory();
        }
        return heavy.get();
    }
}
