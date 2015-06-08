package com.academy.patterns.shared;

/**
 * Created by Kelheor on 07.06.2015.
 */
public abstract class AbstractSystem {

    public void executeActions(Action... actions) {
        for (Action action : actions) {
            action.invoke();
        }
    }

    enum Action {
        FIRE("FIRE"), DEFENCE("DEFENCE");

        private String action;

        Action(String action) {
            this.action = action;
        }

        public void invoke() {
            System.out.println("INVOKE " + action + " ACTION");
        }
    }

    public abstract void execute();

}
