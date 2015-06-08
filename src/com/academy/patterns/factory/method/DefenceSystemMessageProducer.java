package com.academy.patterns.factory.method;

/**
 * Created by keos on 08.06.15.
 */
public class DefenceSystemMessageProducer implements Producer {

    @Override
    public Message createMessage(MessageType messageType) {
        return new DefenceSystemMessage(messageType);
    }
}
