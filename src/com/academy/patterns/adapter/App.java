package com.academy.patterns.adapter;

/**
 * Created by Kelheor on 06.06.2015.
 */
public class App {

    public static void main(String[] args) {

        // Адаптер позволяет использовать объекты, которые мы НЕ можем использовать по умолчанию из-за различий в интерфейсе

        // We need to operate objects of AvailableInterface
        // We also need to execute method of RequiredEntity
        // So we create adapter, which gives us such a possibility
        AvailableInterface availableInterface = new Adapter(new RequiredEntity());
        availableInterface.execute();
    }
}
