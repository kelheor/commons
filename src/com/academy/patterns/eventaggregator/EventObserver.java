package com.academy.patterns.eventaggregator;

/**
 * Created by keos on 23.06.15.
 */
public interface EventObserver {

    void onEvent(String event);
}
