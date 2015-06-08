package com.academy.patterns.factory.method;

/**
 * Created by keos on 08.06.15.
 */
public class AttackSystemMessage implements Message {

    private MessageType messageType;

    public AttackSystemMessage(MessageType messageType) {
        this.messageType = messageType;
    }
}
