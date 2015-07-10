package com.academy.patterns.flux.view;

import com.academy.patterns.flux.action.Content;
import com.academy.patterns.flux.store.ContentStore;
import com.academy.patterns.flux.store.Store;

/**
 * Created by keos on 10.07.15.
 */
public class ContentView implements View {

    private Content content = Content.PRODUCTS;

    @Override
    public void storeChanged(Store store) {
        ContentStore contentStore = (ContentStore) store;
        content = contentStore.getContent();
        render();
    }

    @Override
    public void render() {
        System.out.println(content.toString());
    }
}
