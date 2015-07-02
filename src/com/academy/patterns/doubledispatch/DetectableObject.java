package com.academy.patterns.doubledispatch;

/**
 * Created by keos on 02.07.15.
 */
public abstract class DetectableObject {

    public abstract void detect(DetectableObject detectableObject);

    protected abstract void detectObject(Car car);

    protected abstract void detectObject(Train train);
}
