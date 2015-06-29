package com.academy.patterns.poisonpill;

/**
 * Created by keos on 29.06.15.
 */
public interface MQSubscribePoint {
    Message take() throws InterruptedException;
}
