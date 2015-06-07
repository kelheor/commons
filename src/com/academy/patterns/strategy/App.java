package com.academy.patterns.strategy;

/**
 * Created by keos on 05.06.15.
 */
public class App {
    public static void main(String[] args) {

        // ��������� ��������� ����������� �������� ��������� ��������

        StrategyExecutor strategyExecutor = new StrategyExecutor(new SinglethreadStrategy());
        strategyExecutor.execute();

        strategyExecutor.setStrategy(new MultithreadStrategy());
        strategyExecutor.execute();
    }
}
