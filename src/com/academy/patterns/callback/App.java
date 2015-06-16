package com.academy.patterns.callback;

/**
 * Created by keos on 16.06.15.
 */
public class App {

    public static void main(String[] args) {
        // Паттерн колбэка
        Task task = new SimpleTask();
        Callback callback = () -> {
            System.out.println("CALLBACK EXECUTED");
        };
        task.executeWith(callback);
    }
}
