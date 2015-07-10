package com.academy.patterns.flux.action;

/**
 * Created by keos on 10.07.15.
 */
public enum  Content {

    PRODUCTS("Products page"), COMPANY("Company page");

    private String title;

    Content(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
