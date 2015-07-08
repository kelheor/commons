package com.academy.patterns.mvc;

/**
 * Created by keos on 08.07.15.
 */
public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void setText(String text) {
        model.setText(text);
    }

    public void updateView() {
        view.display(model);
    }
}
