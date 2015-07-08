package com.academy.patterns.mvc;

/**
 * Created by keos on 08.07.15.
 */
public class View {

    public void display(Model model) {
        System.out.println(model.getText());
    }
}
