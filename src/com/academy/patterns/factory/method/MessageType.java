package com.academy.patterns.factory.method;

/**
 * Created by keos on 08.06.15.
 */
public enum  MessageType {

    DATA_MESSAGE("data_message"), PING_MESSAGE("ping_message");

    private String type;

    MessageType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MessageType{" +
                "type='" + type + '\'' +
                '}';
    }
}
