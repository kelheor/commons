package com.academy.patterns.factory.method;

/**
 * Created by keos on 08.06.15.
 */
public class App {

    public static void main(String[] args) {

        // Шаблонный метод позволяет наследникам реализовывать свои собственные методы создания инстансов объектов на основе единого интерфейса
        Producer producer;
        Message message;

        producer = new AttackSystemMessageProducer();
        message = producer.createMessage(MessageType.DATA_MESSAGE);
        System.out.println(message);

        producer = new DefenceSystemMessageProducer();
        message = producer.createMessage(MessageType.DATA_MESSAGE);
        System.out.println(message);
    }
}
