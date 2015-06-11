package com.academy.patterns.observer;

/**
 * Created by keos on 11.06.15.
 */
public interface Observer<S extends Observable<S, O, A>, O extends Observer<S, O, A>, A> {
    void update(S subject, A argument);
}
