package com.academy.patterns.flux.action;

/**
 * Created by keos on 10.07.15.
 */
public class MenuAction extends Action {

    private MenuItem menuItem;

    public MenuAction(MenuItem menuItem) {
        super(ActionType.MENU_ITEM_SELECTED);
        this.menuItem = menuItem;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }
}
