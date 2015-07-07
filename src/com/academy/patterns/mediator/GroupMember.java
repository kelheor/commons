package com.academy.patterns.mediator;

/**
 * Created by keos on 07.07.15.
 */
public interface GroupMember {

    void joinEvent(Group group);
    void groupExecute(String action);
    void execute(String action);
}
