package com.academy.patterns.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by keos on 07.07.15.
 */
public class GroupImpl implements Group {

    private final List<GroupMember> groupMembers = new ArrayList<>();

    @Override
    public void add(GroupMember groupMember) {
        groupMembers.add(groupMember);
        groupMember.joinEvent(this);
    }

    @Override
    public void execute(GroupMember groupMember, String action) {
        for(GroupMember member : groupMembers) {
            if(member != groupMember) {
                member.groupExecute(action);
            }
        }
    }
}
