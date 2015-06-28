package com.academy.patterns.chainofresponsibility;

/**
 * Created by Kelheor on 28.06.2015.
 */
public class NewDataHandler extends RequestHandler {

    public NewDataHandler(RequestHandler handler) {
        super(handler);
    }

    @Override
    public void handleRequest(Request req) {
        if (req.getAction().equals("NEW DATA")) {
            printHandling(req);
        } else {
            super.handleRequest(req);
        }
    }

    @Override
    public String toString() {
        return "New data handler";
    }

}