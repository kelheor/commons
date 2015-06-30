package com.academy.patterns.lazyloading;

/**
 * Created by keos on 30.06.15.
 */
public class App {

    public static void main(String[] args) {
        // Lazy loading используется, чтобы предотвратить тяжелое и несвоевременное создание объектов
        NonThreadSafeHolder nonThreadSafeHolder = new NonThreadSafeHolder();
        System.out.println("heavy = " + nonThreadSafeHolder.getHeavy());

        ThreadSafeHolder threadSafeHolder = new ThreadSafeHolder();
        System.out.println("heavy 2 = " + threadSafeHolder);

        Java8ThreadSafeHolder java8ThreadSafeHolder = new Java8ThreadSafeHolder();
        System.out.println("heavy 3 = " + java8ThreadSafeHolder.getHeavy());

    }
}
