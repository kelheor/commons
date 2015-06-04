package com.academy.concurrency.batch;

import java.util.concurrent.atomic.AtomicInteger;

public class App {

    public static void main(String[] args) {
        try {

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 10; i++) {
                final AtomicInteger processed = new AtomicInteger(0);
                Thread[] threads = new Thread[1000];
                for(int j = 0; j < 1000; j++) {
                    threads[i] = new Thread(() -> {
                        try {
                            BatchInserter.INSTANCE.batchInsert("DATA");
                        } catch (Exception e) {

                        } finally {
                            processed.incrementAndGet();
                        }
                    });
                    threads[i].start();
                }
                boolean isProcessed = false;
                while(!isProcessed) {
                    for (int j = 0; j < 1000; j++) {
                        threads[i].join();
                        if(processed.get() == 1000) {
                            isProcessed = !isProcessed;
                            break;
                        }
                    }
                }
                System.out.println("ITERATION " + i);
                System.out.println("PROCESSED " + processed.get());
            }
            long endTime = System.currentTimeMillis();
            long allTime = endTime - startTime;
            System.out.println(allTime);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}