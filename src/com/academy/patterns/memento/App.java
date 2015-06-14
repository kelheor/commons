package com.academy.patterns.memento;

/**
 * Created by Kelheor on 14.06.2015.
 */
public class App {

    // Паттерн memento позволяет сделать снимок состояния объекта, чтобы в будущем его как-то использовать(восстановление, вывод, ...)

    public static void main(String[] args) {
        Monster monster = new Monster();
        monster.setName("OGRE");
        Memento memento = monster.getMemento();
        monster.setName("GOBLIN");
        monster.setMemento(memento);
        System.out.println(monster.getName());
    }
}
