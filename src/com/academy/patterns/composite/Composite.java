package com.academy.patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by keos on 10.06.15.
 */
public class Composite {

    protected String name;

    private List<Composite> children = new ArrayList<>();

    public Composite() {
    }

    public Composite(String name) {
        this.name = name;
    }

    public List<Composite> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
