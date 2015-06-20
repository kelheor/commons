package com.academy.patterns.templatemethod;

/**
 * Created by Kelheor on 20.06.2015.
 */
public abstract class AttackMethod {

    public abstract void specialAttack();

    public void attack() {
        System.out.println("ATTACKING THE ENEMY");
        System.out.println("USING SPECIAL ATTACK: ");
        specialAttack();
    }
}
