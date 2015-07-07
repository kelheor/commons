package com.academy.patterns.mediator;

/**
 * Created by keos on 07.07.15.
 */
public abstract class AbstractGroupMember implements GroupMember {

    protected Group group;

    @Override
    public void joinEvent(Group group) {
        System.out.println(this + " joined to the group");
        this.group = group;
    }

    @Override
    public void groupExecute(String action) {
        System.out.println(this + " NOTIFIED ABOUT ACTION - " + action);
    }

    @Override
    public void execute(String action) {
        if(group != null) {
            System.out.println(this + " EXECUTE " + action);
            group.execute(this, action);
        }
    }

    @Override
    public abstract String toString();
}
