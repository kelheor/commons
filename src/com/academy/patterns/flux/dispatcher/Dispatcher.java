package com.academy.patterns.flux.dispatcher;

import com.academy.patterns.flux.action.*;
import com.academy.patterns.flux.store.Store;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by keos on 10.07.15.
 */
public class Dispatcher {

    private static Dispatcher instance = new Dispatcher();

    private List<Store> storeList = new LinkedList<>();

    private Dispatcher() {

    }

    public static Dispatcher getInstance() {
        return instance;
    }

    public void registerStore(Store store) {
        storeList.add(store);
    }

    private void dispatchAction(Action action) {
        storeList.stream().forEach((store) -> store.onAction(action));
    }

    public void menuItemSelected(MenuItem menuItem) {
        dispatchAction(new MenuAction(menuItem));
        switch (menuItem) {
            case HOME:
            case PRODUCTS:
            default:
                dispatchAction(new ContentAction(Content.PRODUCTS));
                break;
            case COMPANY:
                dispatchAction(new ContentAction(Content.COMPANY));
                break;
        }
    }
}
