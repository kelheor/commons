package com.academy.patterns.resource.aquisition.is.initialization;

/**
 * Created by keos on 01.07.15.
 */
public class App {

    public static void main(String[] args) throws Exception {
        // Отличие AutoCloseable от Closeable в том, что если несколько раз вызывать метод close, то для AutoClosable могут
        // проявлятся какие-нибудь сторонние эффекты, а для Closeable их не должно быть. Ну и exception'ы они кидают разные.

        // Данный пример показывает как реализовать нужные интерфейсы у объектов, чтобы использовать их в конструкции try-with-resources
        try(Area51 area51 = new Area51()) {
            System.out.println("SEEKING FOR UFO");
        }

        try(SecretPolygon secretPolygon = new SecretPolygon()) {
            System.out.println("SEEKING FOR ULTIMATE WEAPON");
        }
      
    }
}
