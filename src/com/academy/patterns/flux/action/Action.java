package com.academy.patterns.flux.action;

/**
 * Created by keos on 10.07.15.
 */
public abstract class Action {
    private ActionType actionType;

    public Action(ActionType actionType) {
        this.actionType = actionType;
    }

    public ActionType getActionType() {
        return actionType;
    }
}
