package com.academy.patterns.proxy;

import com.academy.patterns.proxy.entity.Proxy;

/**
 * Created by keos on 08.06.15.
 */
public class App {

    public static void main(String[] args) {

        // Прокси к оригинальному объекту. Нужен, чтобы к примеру изменить способ доступа к полям объекта
        // Чем-то похож на декоратор, хотя по идее прокси - модифицированная версия ссылки на объект
        // Прокси может создать объект по необходимости, а декоратор декорирует существующий объект
        Proxy proxy = new Proxy();

        // ERROR
        System.out.println(proxy.getSecuredData("NaN"));

        // GET DATA
        System.out.println(proxy.getSecuredData("12345678"));

    }
}
