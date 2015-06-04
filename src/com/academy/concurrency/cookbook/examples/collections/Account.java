package com.academy.concurrency.cookbook.examples.collections;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by rnazirov on 27.04.2015.
 */
public class Account {

    private AtomicLong balance;

    public Account() {
        balance = new AtomicLong();
    }

    public long getBalance() {
        return balance.get();
    }

    public void setBalance(long balance) {
        this.balance.set(balance);
    }

    public void addAmount(long amount) {
        this.balance.getAndAdd(amount);
    }

    public void subtractAmount(long amount) {
        this.balance.getAndAdd(-amount);
    }
}
