package com.academy.patterns.flux.action;

/**
 * Created by keos on 10.07.15.
 */
public class ContentAction extends Action {

    private Content content;

    public ContentAction(Content content) {
        super(ActionType.CONTENT_CHANGED);
        this.content = content;
    }

    public Content getContent() {
        return content;
    }
}
