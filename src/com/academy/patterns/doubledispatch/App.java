package com.academy.patterns.doubledispatch;

/**
 * Created by keos on 02.07.15.
 */
public class App {

    public static void main(String[] args) {
        /**
         * Используем, когда поведение должно зависить не только от получателя, но и от самого типа передаваемого параметра
         * То есть мы передаем объект на получатель, а далее в зависимости от типа используем один из перегруженных параметров
         * к примеру переданного объекта, куда мы передадим в качестве параметра объект-получатель.
         * То есть мы делаем двойную маршрутизацию, что быстрее чем вызов Instanceof
         */
        Car car = new Car();
        Train train = new Train();
        train.detect(car);
        car.detect(train);
    }
}
