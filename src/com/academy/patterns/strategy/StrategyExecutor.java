package com.academy.patterns.strategy;

/**
 * Created by keos on 05.06.15.
 */
public class StrategyExecutor {

    private Strategy strategy;

    public StrategyExecutor(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.execute();
    }
}
