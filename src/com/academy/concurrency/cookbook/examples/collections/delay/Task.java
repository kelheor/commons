package com.academy.concurrency.cookbook.examples.collections.delay;

import java.util.Date;
import java.util.concurrent.DelayQueue;

/**
 * Created by rnazirov on 27.04.2015.
 */
public class Task implements Runnable {

    private int id;
    private DelayQueue<Event> queue;

    public Task(int id, DelayQueue<Event> queue) {
        this.id=id;
        this.queue=queue;
    }

    @Override
    public void run() {
        Date now=new Date();
        Date delay=new Date();
        delay.setTime(now.getTime()+(id*1000));
        System.out.printf("Thread %s: %s\n",id,delay);
        for (int i=0; i<100; i++) {
            Event event=new Event(delay);
            queue.add(event);
        }
    }
}
