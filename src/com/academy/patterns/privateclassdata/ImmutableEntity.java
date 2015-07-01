package com.academy.patterns.privateclassdata;

/**
 * Created by keos on 01.07.15.
 */
public class ImmutableEntity {

    private PrivateData privateData;

    public ImmutableEntity(String password) {
       privateData = new PrivateData(password);
    }

    public void checkPassword(String password) {
        if(password.equals(privateData.getPassword())) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAIL");
        }
    }
}
