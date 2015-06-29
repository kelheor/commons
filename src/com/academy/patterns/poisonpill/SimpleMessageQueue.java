package com.academy.patterns.poisonpill;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by keos on 29.06.15.
 */
public class SimpleMessageQueue implements MessageQueue {

    private final BlockingQueue<Message> queue;

    public SimpleMessageQueue(int bound) {
        queue = new ArrayBlockingQueue<Message>(bound);
    }

    @Override
    public void put(Message message) throws InterruptedException {
        queue.put(message);
    }

    @Override
    public Message take() throws InterruptedException {
        return queue.take();
    }
}
