package com.academy.patterns.command;

/**
 * Created by Kelheor on 27.06.2015.
 */
public class RocketAttack extends Command {

    private DamageLevel oldDamageLevel;
    private Target target;

    @Override
    public void execute(Target target) {
        oldDamageLevel = target.getDamageLevel();
        target.setDamageLevel(DamageLevel.getIncreasedDamageLevel(target.getDamageLevel()));
        this.target = target;
    }

    @Override
    public void undo() {
        if (oldDamageLevel != null && target != null) {
            DamageLevel damageLevel = target.getDamageLevel();
            target.setDamageLevel(oldDamageLevel);
            oldDamageLevel = damageLevel;
        }
    }

    @Override
    public void redo() {
        undo();
    }

    @Override
    public String toString() {
        return "Rocket attack";
    }
}
