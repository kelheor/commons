package com.academy.patterns.interceptingfilter;

/**
 * Created by keos on 03.07.15.
 */
public abstract class AbstractFilter implements Filter {

    private Filter next;

    public AbstractFilter() {}

    public AbstractFilter(Filter next) {
        this.next = next;
    }

    @Override
    public void setNext(Filter filter) {
        this.next = filter;
    }

    @Override
    public Filter getNext() {
        return next;
    }

    @Override
    public String execute(Order order) {
        if(getNext() != null) {
            return getNext().execute(order);
        } else return "";
    }

    @Override
    public Filter getLast() {
        Filter last = this;
        while (last.getNext() != null) {
            last = last.getNext();
        }
        return last;
    }
}
