package com.academy.patterns.proxy.entity;

/**
 * Created by keos on 08.06.15.
 */
public class Proxy extends Entity {

    private String password = "12345678";

    public String getSecuredData(String password) {
        if(password.equals(this.password)) {
            return getSecuredData();
        } else {
            return "AUTH ERROR";
        }
    }


}
