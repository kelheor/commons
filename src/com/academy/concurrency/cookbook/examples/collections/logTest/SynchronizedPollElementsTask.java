package com.academy.concurrency.cookbook.examples.collections.logTest;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rnazirov on 27.04.2015.
 */
public class SynchronizedPollElementsTask implements Runnable {
    private List<String> list;
    private Object monitor;

    public SynchronizedPollElementsTask(List<String> list, Object monitor) {
        this.list = list;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            while (true) {
                long startTime = System.nanoTime();
                List<String> forStoring;
                synchronized (monitor) {
                    forStoring = list;
                    list = new LinkedList<String>();
                }
                for (String log: forStoring) {
                }
                long endTime = System.nanoTime();
                long executionTime = (endTime - startTime);
                System.out.println("NON BLOCKING POLL EXECUTION TIME: " + executionTime);
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
