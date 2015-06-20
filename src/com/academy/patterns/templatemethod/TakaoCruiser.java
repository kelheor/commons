package com.academy.patterns.templatemethod;

import com.academy.patterns.shared.CyberBattleship;

/**
 * Created by Kelheor on 20.06.2015.
 */
public class TakaoCruiser extends CyberBattleship {

    private AttackMethod attackMethod = new NuclearStrike();

    public void setAttackMethod(AttackMethod attackMethod) {
        this.attackMethod = attackMethod;
    }

    public void attack() {
        attackMethod.attack();
    }
}
