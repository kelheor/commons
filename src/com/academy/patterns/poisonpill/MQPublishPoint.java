package com.academy.patterns.poisonpill;

/**
 * Created by keos on 29.06.15.
 */
public interface MQPublishPoint {

    void put(Message message) throws InterruptedException;
}
