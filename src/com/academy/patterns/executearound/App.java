package com.academy.patterns.executearound;

/**
 * Created by keos on 29.06.15.
 */
public class App {

    public static void main(String[] args) {
        // Идиома execute around избавляет от необходимости постоянно выполнять повторящийся код перед и после вызова бизнес метода
        new SimpleFileWriter("TEST.txt", fileWriter -> {
            fileWriter.write("HELLO WORLD!");
        });
    }
}
