package com.academy.concurrency.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rnazirov on 03.06.2015.
 */
public class ThreadPool {

    private LinkedBlockingDeque<Thread> available = new LinkedBlockingDeque<>();
    private LinkedBlockingDeque<Thread> inUse = new LinkedBlockingDeque<>();
    private int poolSize = 0;
    private LinkedBlockingDeque<Runnable> blockingQueue = new LinkedBlockingDeque<>();
    private boolean isShutdown = false;
    private Lock lock = new ReentrantLock();

    public ThreadPool(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }

        poolSize = size;
    }

    public void checkoutThread() {
        lock.lock();
        try {
            if(available.size() <= 0 && (available.size() + inUse.size() < poolSize)) {
                Thread thread = new Thread(new Executor());
                available.add(thread);
                thread.start();
            }
        } finally {
            lock.unlock();
        }
    }

    public void submit(Runnable runnable) throws InterruptedException {
        if(runnable == null) {
            throw new IllegalArgumentException();
        }
        checkoutThread();
        blockingQueue.put(runnable);
    }

    public void shutdown() {
        try {
            while (blockingQueue.size() > 0) {
                // WAITING FOR COMPLETION
            }
            isShutdown = true;
            for (Thread thread : available) {
                thread.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class Executor implements Runnable {
        @Override
        public void run() {
            while (!isShutdown) {
                if (blockingQueue.size() > 0) {
                    Runnable runnable = blockingQueue.poll();
                    if (runnable == null) {
                        continue;
                    }
                    available.remove(Thread.currentThread());
                    inUse.add(Thread.currentThread());
                    runnable.run();
                    inUse.remove(Thread.currentThread());
                    available.add(Thread.currentThread());
                }
            }
        }
    }


}
