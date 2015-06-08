package com.academy.patterns.proxy.entity;

/**
 * Created by keos on 08.06.15.
 */
public class Entity {

    private String securedData = "SECURED DATA";

    protected String getSecuredData() {
        return securedData;
    }
}
