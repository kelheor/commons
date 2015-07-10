package com.academy.patterns.flux.store;

import com.academy.patterns.flux.action.Action;
import com.academy.patterns.flux.action.ActionType;
import com.academy.patterns.flux.action.Content;
import com.academy.patterns.flux.action.ContentAction;

/**
 * Created by keos on 10.07.15.
 */
public class ContentStore extends Store {

    private Content content = Content.PRODUCTS;

    @Override
    public void onAction(Action action) {
        if(action.getActionType().equals(ActionType.CONTENT_CHANGED)) {
            ContentAction contentAction = (ContentAction) action;
            content = contentAction.getContent();
            notifyChange();
        }
    }

    public Content getContent() {
        return content;
    }
}
