package com.academy.patterns.servicelocator;

/**
 * Created by keos on 22.06.15.
 */
public class ServiceImpl implements Service {

    private String name;
    private int id;

    public ServiceImpl(String name) {
        this.name = name;
        id = (int) Math.floor(Math.random() * 1000) + 1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void execute() {
        System.out.println(name + ":" + id + " executed");
    }
}
