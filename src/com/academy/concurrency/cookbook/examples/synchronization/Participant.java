package com.academy.concurrency.cookbook.examples.synchronization;

import java.util.concurrent.TimeUnit;

/**
 * Created by rnazirov on 22.04.2015.
 */
public class Participant implements Runnable {

    private VideoConference videoConference;
    private String name;

    public Participant(VideoConference conference, String name) {
        this.videoConference=conference;
        this.name=name;
    }

    @Override
    public void run() {
        long duration=(long)(Math.random()*10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        videoConference.arrive(name);
    }
}
