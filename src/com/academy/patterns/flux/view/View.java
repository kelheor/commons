package com.academy.patterns.flux.view;

import com.academy.patterns.flux.store.Store;

/**
 * Created by keos on 10.07.15.
 */
public interface View {

    void storeChanged(Store store);

    void render();
}
