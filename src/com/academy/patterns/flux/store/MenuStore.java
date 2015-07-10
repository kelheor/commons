package com.academy.patterns.flux.store;

import com.academy.patterns.flux.action.*;

/**
 * Created by keos on 10.07.15.
 */
public class MenuStore extends Store {

    private MenuItem menuItem = MenuItem.HOME;

    @Override
    public void onAction(Action action) {
        if(action.getActionType().equals(ActionType.MENU_ITEM_SELECTED)) {
            MenuAction menuAction = (MenuAction) action;
            menuItem = menuAction.getMenuItem();
            notifyChange();
        }
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }
}
