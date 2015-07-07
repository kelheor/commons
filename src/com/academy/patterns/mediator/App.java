package com.academy.patterns.mediator;

/**
 * Created by keos on 07.07.15.
 */
public class App {

    public static void main(String[] args) {
        // Медиатор управляет тем, как группа объектов взаимодействуют между собой
        // Вместо обращения к каждому из них при каком-либо эвенте дергается лишь медиатор
        Group group = new GroupImpl();
        Avalon avalon = new Avalon();
        Yggdrasil yggdrasil = new Yggdrasil();
        group.add(avalon);
        group.add(yggdrasil);

        avalon.execute("Ignite shield");
        yggdrasil.execute("Restore shield");
    }
}
