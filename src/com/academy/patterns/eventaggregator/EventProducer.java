package com.academy.patterns.eventaggregator;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by keos on 23.06.15.
 */
public abstract class EventProducer {

    private List<EventObserver> observers;

    public EventProducer() {
        observers = new LinkedList<>();
    }

    public EventProducer(EventObserver eventObserver) {
        this();
        registerObserver(eventObserver);
    }

    public void registerObserver(EventObserver eventObserver) {
        observers.add(eventObserver);
    }

    protected void notifyObservers(String event) {
        observers.forEach(eventObserver -> eventObserver.onEvent(event));
    }

    public abstract void spy();
}
