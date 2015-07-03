package com.academy.patterns.interceptingfilter;

/**
 * Created by keos on 03.07.15.
 */
public class App {
    public static void main(String[] args) {
        // Фильтр-перехватчик используется, когда нужна пред и пост процессорная обработка.

        FilterManager filterManager = new FilterManager();
        filterManager.addFilter(new NameFilter());
        filterManager.addFilter(new OrderFilter());

        Order order = new Order();
        System.out.println(filterManager.filterRequest(order));
        order.setName("123");
        System.out.println(filterManager.filterRequest(order));
        order.setOrder("123");
        System.out.println(filterManager.filterRequest(order));
    }
}
