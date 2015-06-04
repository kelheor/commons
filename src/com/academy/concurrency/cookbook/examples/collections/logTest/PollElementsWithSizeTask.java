package com.academy.concurrency.cookbook.examples.collections.logTest;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by rnazirov on 27.04.2015.
 */
public class PollElementsWithSizeTask implements Runnable {
    private ConcurrentLinkedDeque<String> list;

    public PollElementsWithSizeTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                long startTime = System.nanoTime();
                while ((list.pollFirst()) != null) {
                    if(list.size() <= 1000) {
                    }
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
