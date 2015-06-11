package com.academy.patterns.observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Наблюдаемая сущность
 * @param <S> Сущность
 * @param <O> Наблюдатель
 * @param <A> Тип аргумента
 */
public abstract class Observable<S extends Observable<S, O, A>, O extends Observer<S, O, A>, A> {
    protected List<O> observers;

    public Observable() {
        this.observers = new CopyOnWriteArrayList<>();
    }

    public void addObserver(O observer) {
        this.observers.add(observer);
    }

    public void notifyObservers(A argument) {
        for(O observer : observers) {
            observer.update((S) this, argument);
        }
    }
}
