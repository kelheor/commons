package com.academy.concurrency.cookbook.examples.collections;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by rnazirov on 27.04.2015.
 */
public class AddTask implements Runnable {

    private ConcurrentLinkedDeque<String> list;

    public AddTask(ConcurrentLinkedDeque<String> list) {
        this.list=list;
    }

    @Override
    public void run() {
        String name=Thread.currentThread().getName();
        for (int i=0; i<10000; i++){
            list.add(name+": Element "+i);
        }
    }
}

