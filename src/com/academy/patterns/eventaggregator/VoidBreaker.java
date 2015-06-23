package com.academy.patterns.eventaggregator;

import com.academy.patterns.shared.CyberBattleship;

/**
 * Created by keos on 23.06.15.
 */
public class VoidBreaker extends CyberBattleship implements EventObserver {

    @Override
    public void onEvent(String event) {
        System.out.println("INTELLIGENCE CENTER DETECTED EVENT: " + event);
    }
}
