package com.academy.patterns.flux.action;

/**
 * Created by keos on 10.07.15.
 */
public enum  MenuItem {

    HOME("home"), PRODUCTS("products"), COMPANY("company");

    private String title;

    MenuItem(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
