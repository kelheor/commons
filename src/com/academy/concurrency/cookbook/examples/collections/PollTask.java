package com.academy.concurrency.cookbook.examples.collections;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by rnazirov on 27.04.2015.
 */
public class PollTask implements Runnable {
    private ConcurrentLinkedDeque<String> list;

    public PollTask(ConcurrentLinkedDeque<String> list) {
        this.list=list;
    }

    @Override
    public void run() {
        for (int i=0; i<5000; i++) {
            list.pollFirst();
        }
    }
}
