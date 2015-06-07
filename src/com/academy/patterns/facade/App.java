package com.academy.patterns.facade;

/**
 * Created by Kelheor on 07.06.2015.
 */
public class App {

    public static void main(String[] args) {

        // Фасад предоставляет единый интерфейс управления подсистемами
        SystemsFacade systemsFacade = new SystemsFacade();
        systemsFacade.executeFireSystem();
        systemsFacade.executeDefenceSystem();
        systemsFacade.executeAll();
    }
}
