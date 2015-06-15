package com.academy.patterns.multiton;

/**
 * Created by keos on 15.06.15.
 */
public class App {

    public static void main(String[] args) {
        // Паттерн мультитона предоставляет определенное число инстансов класса
        // Фактически примером в данном случае может служить класс SortService
        // Однако, если энумы не подходят, можно еще и так:

        System.out.println(Ship.getInstance("AUVERGEN").getName());
        System.out.println(Ship.getInstance("SELENDIS").getName());
    }
}
