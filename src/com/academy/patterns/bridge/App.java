package com.academy.patterns.bridge;

/**
 * Created by keos on 09.06.15.
 */
public class App {

    public static void main(String[] args) {
        
        // Разделяет абстракцию от реализации

        DefenceModule defenceModule = new DefenceModule(new EnergeticalShield());

        defenceModule.getModule().activate();
        defenceModule.getModule().process();
    }
}
