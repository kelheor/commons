package com.academy.patterns.interceptingfilter;

/**
 * Created by keos on 03.07.15.
 */
public interface Filter {

    String execute(Order order);

    void setNext(Filter filter);

    Filter getNext();

    Filter getLast();

}
