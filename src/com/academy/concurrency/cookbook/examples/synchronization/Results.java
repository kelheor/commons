package com.academy.concurrency.cookbook.examples.synchronization;

/**
 * Created by rnazirov on 22.04.2015.
 */
public class Results {
    private int data[];

    public Results(int size) {
        data = new int[size];
    }

    public void setData(int position, int value) {
        data[position] = value;
    }

    public int[] getData() {
        return data;
    }
}
