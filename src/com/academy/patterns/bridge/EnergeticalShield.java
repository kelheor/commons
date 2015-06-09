package com.academy.patterns.bridge;

/**
 * Created by keos on 09.06.15.
 */
// Одна из реализаций
public class EnergeticalShield extends DefenceModuleImpl {

    @Override
    public void activate() {
        System.out.println("SHIELD ACTIVATED");
    }

    @Override
    public void process() {
        System.out.println("PROCESSING MODULE DATA...");
    }
}
