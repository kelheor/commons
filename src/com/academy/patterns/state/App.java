package com.academy.patterns.state;

import com.academy.patterns.shared.AttackSystem;

/**
 * Created by Kelheor on 12.06.2015.
 */
public class App {
    public static void main(String[] args) {
        // Патерн состояние похож на паттерн стратегия, но имеет различия
        // Его суть в том, что поведение объекта зависит от его состояния
        // То есть меняется логика всего объекта, а в случае стратегии меняется лишь одна небольшая часть объекта
        // При этом стратегию нужно сетать извне, а состояние есть у объекта внутри изначально
        // Также состояние содержит ссылку на оригинальный объект, а стратегия нет

        // В данном примере мы лишь можем наблюдать какое у объекта состояние, но вообще говоря можно
        // менять поведение методов в реальной разработке в зависимости от состояния
        AttackSystem attackSystem = new AttackSystem();
        attackSystem.setState(new PassiveState());
        attackSystem.getState().observe();
        attackSystem.setState(new ActiveState());
        attackSystem.getState().observe();
    }
}
