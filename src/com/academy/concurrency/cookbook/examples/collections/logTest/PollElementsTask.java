package com.academy.concurrency.cookbook.examples.collections.logTest;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by rnazirov on 27.04.2015.
 */
public class PollElementsTask implements Runnable {
    private ConcurrentLinkedDeque<String> list;
    private AtomicBoolean storing;
    private Object monitor;

    public PollElementsTask(ConcurrentLinkedDeque<String> list, AtomicBoolean storing, Object monitor) {
        this.list = list;
        this.storing = storing;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            while (true) {
                long startTime = System.nanoTime();

                ConcurrentLinkedDeque<String> forStoring;
                storing.set(true);
                synchronized (monitor) {
                    forStoring = list;
                    list = new ConcurrentLinkedDeque<>();
                }
                storing.set(false);

                int needToRemove = 5000 - forStoring.size();
                if(needToRemove < 0) {
                    needToRemove = -needToRemove;
                    for(int i = 0; i < needToRemove; i++) {
                        forStoring.pollFirst();
                    }
                }
                while ((forStoring.pollFirst()) != null) {

                }
                long endTime = System.nanoTime();
                long executionTime = (endTime - startTime);
                System.out.println("NON BLOCKING POLL EXECUTION TIME: " + executionTime);
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
