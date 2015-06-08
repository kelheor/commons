package com.academy.patterns.abstractfactory;

/**
 * Created by keos on 08.06.15.
 */
public class App {

    public static void main(String[] args) {
        // Единый интерфейс создания фабрик с общими свойствами, которые в свою очередь создают разные объекты
        AbstractFactory abstractFactory = new AttackSystemFactory();
        abstractFactory.createSystem().execute();
        abstractFactory = new DefenceSystemFactory();
        abstractFactory.createSystem().execute();
    }
}
