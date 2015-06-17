package com.academy.patterns.singleton;

/**
 * Created by keos on 17.06.15.
 */
public class App {

    public static void main(String[] args) {
        // Различные вариации синглтонов
        StaticEagerSingleton staticEagerSingleton = StaticEagerSingleton.getInstance();
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        InitializingOnDemandHolderIdiom initializingOnDemandHolderIdiom = InitializingOnDemandHolderIdiom.getInstance();
        ThreadSafeDoubleCheckLocking threadSafeDoubleCheckLocking = ThreadSafeDoubleCheckLocking.getInstance();
        ThreadSafeLazyLoadedSingleton threadSafeLazyLoadedSingleton = ThreadSafeLazyLoadedSingleton.getInstance();

    }
}
