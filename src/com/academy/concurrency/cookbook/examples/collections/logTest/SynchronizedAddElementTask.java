package com.academy.concurrency.cookbook.examples.collections.logTest;

import java.util.List;

/**
 * Created by rnazirov on 27.04.2015.
 */
public class SynchronizedAddElementTask implements Runnable {

    private List<String> list;
    private Object monitor;

    public SynchronizedAddElementTask(List<String> list, Object monitor) {
        this.list = list;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            while (true) {
                long startTime = System.nanoTime();
                synchronized (monitor) {
                    list.add("Element");
                    while (list.size() > 1000) {
                        list.remove(0);
                    }
                }
                long endTime = System.nanoTime();
                long executionTime = (endTime - startTime);
                System.out.println("SYNCHRONIZED ADD EXECUTION TIME: " + executionTime);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

