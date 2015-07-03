package com.academy.patterns.interceptingfilter;

/**
 * Created by keos on 03.07.15.
 */
public class NameFilter extends AbstractFilter {

    @Override
    public String execute(Order order) {
        String result = super.execute(order);
        if(order.getName() == null || order.getName().isEmpty()) {
            return result + "Invalid name! ";
        } else return result;
    }
}
