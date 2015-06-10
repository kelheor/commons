package com.academy.patterns.composite;

/**
 * Created by keos on 10.06.15.
 */
public class App {

    public static void main(String[] args) {
        // Компоновщик объединяет объекты в древовидную структуру
        // При этом без разницы для клиента, использует ли он примитив или группу примитивов таким образом(то есть дерево)
        Component component = new Component("AUXILIARY ENERGY CORE");
        component.getChildren().add(new Part("POWER CONDENCATOR"));
        component.getChildren().add(new Component("CONTROL UNIT"));
    }
}