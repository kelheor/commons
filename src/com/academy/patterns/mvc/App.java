package com.academy.patterns.mvc;

/**
 * Created by keos on 08.07.15.
 */
public class App {

    public static void main(String[] args) {
        // Старый добрый MVC - разделение на модели, представления, и контроллеры, которые всем этим управляют
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.setText("TEST");
        controller.updateView();
    }
}
