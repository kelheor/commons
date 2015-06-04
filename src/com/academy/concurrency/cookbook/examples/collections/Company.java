package com.academy.concurrency.cookbook.examples.collections;

/**
 * Created by rnazirov on 27.04.2015.
 */
public class Company implements Runnable {
    private Account account;

    public Company(Account account) {
        this.account=account;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            account.addAmount(1000);
        }
    }

}
