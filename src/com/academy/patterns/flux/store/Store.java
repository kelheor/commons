package com.academy.patterns.flux.store;

import com.academy.patterns.flux.action.Action;
import com.academy.patterns.flux.view.View;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by keos on 10.07.15.
 */
public abstract class Store {

    private List<View> viewList = new LinkedList<>();

    public abstract void onAction(Action action);

    public void registerView(View view) {
        viewList.add(view);
    }

    protected void notifyChange() {
        viewList.stream().forEach((view) -> view.storeChanged(this));
    }
}
