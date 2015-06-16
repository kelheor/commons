package com.academy.patterns.callback;

/**
 * Created by keos on 16.06.15.
 */
public abstract class Task {

    public final void executeWith(Callback callback) {
        execute();
        if(callback != null) {
            callback.call();
        }
    }

    public abstract void execute();
}
