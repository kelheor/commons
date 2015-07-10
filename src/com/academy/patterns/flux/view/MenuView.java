package com.academy.patterns.flux.view;

import com.academy.patterns.flux.action.MenuItem;
import com.academy.patterns.flux.dispatcher.Dispatcher;
import com.academy.patterns.flux.store.MenuStore;
import com.academy.patterns.flux.store.Store;

/**
 * Created by keos on 10.07.15.
 */
public class MenuView implements View {
    private MenuItem selected = MenuItem.HOME;

    @Override
    public void storeChanged(Store store) {
        MenuStore menuStore = (MenuStore) store;
        selected = menuStore.getMenuItem();
        render();
    }

    @Override
    public void render() {
        for(MenuItem menuItem: MenuItem.values()) {
            if(selected.equals(menuItem)) {
                System.out.println(String.format("* %s", menuItem.toString()));
            } else {
                System.out.println(menuItem.toString());
            }
        }
    }

    public void itemClicked(MenuItem menuItem) {
        Dispatcher.getInstance().menuItemSelected(menuItem);
    }
}
