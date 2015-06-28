package com.academy.patterns.chainofresponsibility;

/**
 * Created by Kelheor on 28.06.2015.
 */
public class OldDataHandler extends RequestHandler {

    public OldDataHandler(RequestHandler handler) {
        super(handler);
    }

    @Override
    public void handleRequest(Request req) {
        if (req.getAction().equals("OLD DATA")) {
            printHandling(req);
        } else {
            super.handleRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Old data handler";
    }

}
