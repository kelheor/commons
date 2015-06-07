package com.academy.patterns.decorator;

/**
 * Created by Kelheor on 07.06.2015.
 */
public class App {

    public static void main(String[] args) {

        // Декоратор позволяет добавлять новую функциональность в уже существующие объекты

        Entity originalEntity = new OriginalEntity();
        originalEntity.execute();
        System.out.println();
        Entity decorator = new Decorator(originalEntity);
        decorator.execute();
    }
}
