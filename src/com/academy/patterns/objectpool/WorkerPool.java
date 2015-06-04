package com.academy.patterns.objectpool;

/**
 * Created by rnazirov on 03.06.2015.
 */
public class WorkerPool extends ObjectPool<Worker> {

    @Override
    protected Worker create() {
        return new Worker();
    }
}
