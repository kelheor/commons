package com.academy.patterns.mediator;

/**
 * Created by keos on 07.07.15.
 */
public interface Group {

    void add(GroupMember groupMember);

    void execute(GroupMember groupMember, String action);
}
