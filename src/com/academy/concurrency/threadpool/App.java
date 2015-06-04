package com.academy.concurrency.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by rnazirov on 03.06.2015.
 */
public class App {

    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {

        long startTime;
        long endTime;
        long resultTime;

        ThreadPool threadPool = new ThreadPool(100);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                count.incrementAndGet();
            }
        };

        startTime = System.nanoTime();
        for (int j = 0; j < 100; j++) {
            threadPool.submit(runnable);
        }
        threadPool.shutdown();
        System.out.println(count);
        endTime = System.nanoTime();
        resultTime = endTime - startTime;
        System.out.println("POOL EXECUTION TIME: " + resultTime + " ns");

        // ---------------------------------------------------------------------

        Thread[] threads = new Thread[100];
        for(int i = 0; i < 100; i++) {
            threads[i] = new Thread(runnable);
        }

        startTime = System.nanoTime();
        for(int i = 0; i < 100; i++) {
            threads[i].start();
        }

        for(int i = 0; i < 100; i++) {
            threads[i].join();
        }
        endTime = System.nanoTime();
        resultTime = endTime - startTime;
        System.out.println("NO POOL EXECUTION TIME: " + resultTime + " ns");
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        startTime = System.nanoTime();
        for (int j = 0; j < 100; j++) {
            executorService.submit(runnable);
        }
        executorService.shutdown();
        while (!executorService.isShutdown()) {

        }
        endTime = System.nanoTime();
        resultTime = endTime - startTime;
        System.out.println("FIXED THREAD POOL EXECUTION TIME: " + resultTime + " ns");


    }

}
