package com.academy.patterns.resource.aquisition.is.initialization;

/**
 * Created by keos on 01.07.15.
 */
public class SecretPolygon implements AutoCloseable {

    public SecretPolygon() {
        System.out.println("ENTERING SECRET POLYGON");
    }

    @Override
    public void close() throws Exception {
        System.out.println("LEAVING SECRET POLYGON");
    }
}
