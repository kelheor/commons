package com.academy.concurrency.cookbook.examples.collections.navigableMap;

/**
 * Created by rnazirov on 27.04.2015.
 */
public class Contact {

    private String name;
    private String phone;
    public Contact(String name, String phone) {
        this.name=name;
        this.phone=phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
