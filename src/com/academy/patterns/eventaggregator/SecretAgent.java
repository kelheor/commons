package com.academy.patterns.eventaggregator;

/**
 * Created by keos on 23.06.15.
 */
public class SecretAgent extends EventProducer {

    public SecretAgent() {
        super();
    }

    public SecretAgent(EventObserver eventObserver) {
        super(eventObserver);
    }

    @Override
    public void spy() {
        notifyObservers("Secret agent detected warship");
    }
}
