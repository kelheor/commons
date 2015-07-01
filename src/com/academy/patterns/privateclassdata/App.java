package com.academy.patterns.privateclassdata;

/**
 * Created by keos on 01.07.15.
 */
public class App {

    public static void main(String[] args) {
        // Ограничивает видимость полей и методов класса, путем выноса их в отдельный класс, через которй можно взаимодействовать
        // через геттеры. Таким образом методы класса не обращаются напрямую к полям класса, а делают это через объект-посредник

        ImmutableEntity immutableEntity = new ImmutableEntity("123456");
        immutableEntity.checkPassword("123456");
        immutableEntity.checkPassword("12345678");
    }
}
