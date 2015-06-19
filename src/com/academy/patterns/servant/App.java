package com.academy.patterns.servant;

/**
 * Created by keos on 19.06.15.
 */
public class App {

    public static void main(String[] args) {
        // Servant предоставляет определенные методы целой группе классов, вместо того, чтобы реализовывать их в каждом
        Excalibur excalibur = new Excalibur();
        Malevalensis malevalensis = new Malevalensis();
        Servant servant = new Servant();
        servant.provideAmmo(excalibur);
        servant.provideAmmo(malevalensis);
        excalibur.attack();
        malevalensis.attack();
    }
}
