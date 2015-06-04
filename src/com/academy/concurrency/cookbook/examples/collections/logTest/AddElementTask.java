package com.academy.concurrency.cookbook.examples.collections.logTest;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by rnazirov on 27.04.2015.
 */
public class AddElementTask implements Runnable {

    private ConcurrentLinkedDeque<String> list;
    private AtomicBoolean storing;
    private Object monitor;

    public AddElementTask(ConcurrentLinkedDeque<String> list, AtomicBoolean storing, Object monitor) {
        this.list = list;
        this.storing = storing;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            while (true) {
                long startTime = System.nanoTime();
                if(storing.get()) {
                    synchronized (monitor) {
                        list.add("Element");
                    }
                } else {
                    list.add("Element");
                }

                long endTime = System.nanoTime();
                long executionTime = (endTime - startTime);
                System.out.println("NON BLOCKING ADD EXECUTION TIME: " + executionTime);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

