package com.academy.patterns.doubledispatch;

/**
 * Created by keos on 02.07.15.
 */
public class Train extends DetectableObject {

    @Override
    public void detect(DetectableObject detectableObject) {
        detectableObject.detectObject(this);
    }

    @Override
    protected void detectObject(Car car) {
        System.out.println(String.format("%s detected %s", car.getClass().getSimpleName(), this.getClass().getSimpleName()));
    }

    @Override
    protected void detectObject(Train train) {
        System.out.println(String.format("%s detected %s", train.getClass().getSimpleName(), this.getClass().getSimpleName()));
    }
}