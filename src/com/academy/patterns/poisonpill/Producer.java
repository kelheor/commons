package com.academy.patterns.poisonpill;

import java.util.Date;

/**
 * Created by keos on 29.06.15.
 */
public class Producer {

    private final MQPublishPoint queue;
    private final String name;
    private boolean isStopped;

    public Producer(MQPublishPoint queue, String name) {
        this.queue = queue;
        this.name = name;
        isStopped = false;
    }

    public void send(String body) {
        if(isStopped) {
            throw new IllegalStateException(String.format("Producer %s was stopped and fail to deliver requested message [%s].", body, name));
        }
        Message message = new SimpleMessage();
        message.addHeader(Message.Headers.DATE, new Date().toString());
        message.addHeader(Message.Headers.SENDER, name);
        message.setBody(body);

        try {
            queue.put(message);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    public void stop() {
        isStopped = true;
        try {
            queue.put(Message.POISON_PILL);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
