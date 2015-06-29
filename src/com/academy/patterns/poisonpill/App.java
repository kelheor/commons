package com.academy.patterns.poisonpill;

/**
 * Created by keos on 29.06.15.
 */
public class App {

    public static void main(String[] args) {
        // Используется, когда нужно послать сигнал на остановку какому-то потоку из другого потока
        MessageQueue queue = new SimpleMessageQueue(10000);
        final Producer producer = new Producer(queue, "PRODUCER_1");
        final Consumer consumer = new Consumer(queue, "CONSUMER_1");

        new Thread(() -> consumer.consume()).start();

        new Thread(() -> {
            producer.send("hand shake");
            producer.send("important data");
            producer.send("goodbye!");
            producer.stop();
        }).start();

    }
}
