package com.academy.patterns.flux;

import com.academy.patterns.flux.action.MenuItem;
import com.academy.patterns.flux.dispatcher.Dispatcher;
import com.academy.patterns.flux.store.ContentStore;
import com.academy.patterns.flux.store.MenuStore;
import com.academy.patterns.flux.view.ContentView;
import com.academy.patterns.flux.view.MenuView;

/**
 * Created by keos on 10.07.15.
 */
public class App {
    public static void main(String[] args) {

        // Если вы не фейсбук, то лучше не использовать эту муть
        // По идее у нас есть диспатчер, который получает с вьюх эвенты и перенаправляет их на нужные store, которые
        // в свою очередь обновляют вьюхи
        MenuStore menuStore = new MenuStore();
        Dispatcher.getInstance().registerStore(menuStore);

        ContentStore contentStore = new ContentStore();
        Dispatcher.getInstance().registerStore(contentStore);

        MenuView menuView = new MenuView();
        menuStore.registerView(menuView);

        ContentView contentView = new ContentView();
        contentStore.registerView(contentView);

        menuView.render();
        contentView.render();

        menuView.itemClicked(MenuItem.COMPANY);
    }
}
