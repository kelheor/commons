package com.academy.patterns.interceptingfilter;

/**
 * Created by keos on 03.07.15.
 */
public class FilterManager {
    private FilterChain filterChain;

    public FilterManager() {
        filterChain = new FilterChain();
    }

    public void addFilter(Filter filter) {
        filterChain.addFilter(filter);
    }

    public String filterRequest(Order order) {
        return filterChain.execute(order);
    }
}
