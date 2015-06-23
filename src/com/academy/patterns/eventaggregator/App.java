package com.academy.patterns.eventaggregator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by keos on 23.06.15.
 */
public class App {

    public static void main(String[] args) {
        // Event aggregator позволяет получить события со множества источников и передать их слушателям
        VoidBreaker voidBreaker = new VoidBreaker();
        IntelligenceCenter intelligenceCenter = new IntelligenceCenter(voidBreaker);
        List<EventProducer> eventProducers = new ArrayList<>();
        eventProducers.add(intelligenceCenter);
        eventProducers.add(new SpySatellite(intelligenceCenter));
        eventProducers.add(new SecretAgent(intelligenceCenter));

        // Разведывательный центр получает информацию со спутника шпиона и от секретного агента и передает его на корабль
        eventProducers.forEach(eventProducer -> eventProducer.spy());

    }
}
