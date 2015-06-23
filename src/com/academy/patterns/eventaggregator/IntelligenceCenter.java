package com.academy.patterns.eventaggregator;

/**
 * Created by keos on 23.06.15.
 *
 * В данном случае центр разведки является Event Aggregator'ом
 */
public class IntelligenceCenter extends EventProducer implements EventObserver {

    public IntelligenceCenter() {
        super();
    }

    public IntelligenceCenter(EventObserver eventObserver) {
        super(eventObserver);
    }

    @Override
    public void onEvent(String event) {
        notifyObservers(event);
    }

    @Override
    public void spy() {

    }
}
