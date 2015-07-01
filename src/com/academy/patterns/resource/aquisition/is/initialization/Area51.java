package com.academy.patterns.resource.aquisition.is.initialization;

import java.io.Closeable;

/**
 * Created by keos on 01.07.15.
 */
public class Area51 implements Closeable {

    public Area51() {
        System.out.println("ENTERING AREA 51");
    }

    @Override
    public void close() {
        System.out.println("LEAVING AREA 51");
    }
}
