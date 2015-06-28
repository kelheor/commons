package com.academy.patterns.chainofresponsibility;

/**
 * Created by Kelheor on 28.06.2015.
 */
public class RootDataHandler {

    RequestHandler chain;

    public RootDataHandler() {
        buildChain();
    }

    private void buildChain() {
        chain = new NewDataHandler(new OldDataHandler(null));
    }

    public void makeRequest(Request req) {
        chain.handleRequest(req);
    }
}
