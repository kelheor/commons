package com.academy.patterns.interceptingfilter;

/**
 * Created by keos on 03.07.15.
 */
public class OrderFilter extends AbstractFilter {

    @Override
    public String execute(Order order) {
        String result = super.execute(order);
        if(order.getOrder() == null || order.getOrder().isEmpty()) {
            return result + "Invalid order! ";
        } else return result;
    }
}
