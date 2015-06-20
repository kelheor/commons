package com.academy.patterns.templatemethod;

/**
 * Created by Kelheor on 20.06.2015.
 */
public class App {

    public static void main(String[] args) {
        // Шаблонный метод предоставляет частичную реализацию алгоритма, в то время как его потомки реализуют оставшиеся части
        TakaoCruiser takaoCruiser = new TakaoCruiser();
        takaoCruiser.attack();
        takaoCruiser.setAttackMethod(new OrbitalStrike());
        takaoCruiser.attack();
    }
}
