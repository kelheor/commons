package com.academy.concurrency.cookbook.examples.collections.logTest;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by rnazirov on 27.04.2015.
 */
public class AddElementWithSizeTask implements Runnable {

    private ConcurrentLinkedDeque<String> list;

    public AddElementWithSizeTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                long startTime = System.nanoTime();
                list.add("Element");
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

