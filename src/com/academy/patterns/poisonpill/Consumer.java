package com.academy.patterns.poisonpill;

/**
 * Created by keos on 29.06.15.
 */
public class Consumer {
    private final MQSubscribePoint queue;
    private final String name;

    public Consumer(MQSubscribePoint queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    public void consume() {
        while (true) {
            Message message;
            try {
                message = queue.take();
                if(message == Message.POISON_PILL) {
                    System.out.println(String.format("Consumer %s receive request to terminate.", name));
                    break;
                }
            } catch (InterruptedException e) {
                System.err.println(e);
                return;
            }
            String sender = message.getHeader(Message.Headers.SENDER);
            String body = message.getBody();
            System.out.println(String.format("Message [%s] from [%s] received by [%s]", body, sender, name));
        }
    }
}
