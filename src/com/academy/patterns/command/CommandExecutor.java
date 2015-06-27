package com.academy.patterns.command;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Kelheor on 27.06.2015.
 */
public class CommandExecutor {

    private Deque<Command> undoStack = new LinkedList<>();
    private Deque<Command> redoStack = new LinkedList<>();

    public void execute(Command command, Target target) {
        System.out.println(this + " execute " + command + " at " + target);
        command.execute(target);
        undoStack.offerLast(command);
    }

    public void undoLastSpell() {
        if (!undoStack.isEmpty()) {
            Command previousCommand = undoStack.pollLast();
            redoStack.offerLast(previousCommand);
            System.out.println(this + " undoes " + previousCommand);
            previousCommand.undo();
        }
    }

    public void redoLastSpell() {
        if (!redoStack.isEmpty()) {
            Command previousCommand = redoStack.pollLast();
            undoStack.offerLast(previousCommand);
            System.out.println(this + " redoes " + previousCommand);
            previousCommand.redo();
        }
    }

    @Override
    public String toString() {
        return "Command executor";
    }
}