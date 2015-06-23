package com.academy.patterns.eventaggregator;

/**
 * Created by keos on 23.06.15.
 */
public class SpySatellite extends EventProducer {

    public SpySatellite() {
        super();
    }

    public SpySatellite(EventObserver eventObserver) {
        super(eventObserver);
    }

    @Override
    public void spy() {
        notifyObservers("Spy satellite detected nuclear missile launch");
    }
}
