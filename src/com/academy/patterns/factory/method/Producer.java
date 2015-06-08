package com.academy.patterns.factory.method;

/**
 * Created by keos on 08.06.15.
 */
public interface Producer {

    Message createMessage(MessageType messageType);
}
