package com.academy.patterns.chainofresponsibility;

/**
 * Created by Kelheor on 28.06.2015.
 */
public class Request {

    private String action;

    public Request(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return getAction();
    }
}
