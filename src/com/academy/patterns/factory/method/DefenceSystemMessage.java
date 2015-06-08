package com.academy.patterns.factory.method;

/**
 * Created by keos on 08.06.15.
 */
public class DefenceSystemMessage implements Message {

    private MessageType messageType;

    public DefenceSystemMessage(MessageType messageType) {
        this.messageType = messageType;
    }
}
