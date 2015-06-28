package com.academy.patterns.chainofresponsibility;

/**
 * Created by Kelheor on 28.06.2015.
 */
public class App {

    public static void main(String[] args) {
        // Цепочка ответственности используется, когда на пути запроса есть несколько handler'ов
        RootDataHandler rootDataHandler = new RootDataHandler();
        rootDataHandler.makeRequest(new Request("NEW DATA"));
        rootDataHandler.makeRequest(new Request("OLD DATA"));
        
    }
}
