package com.academy.patterns.mvp;

/**
 * Created by keos on 09.07.15.
 */
public class App {
    public static void main(String[] args) {
        // Model-View-Presenter
        // Model - логика
        // View - GUI
        // Presenter - отвечает за реакцию пользователя и обновления View
        Model model = new Model();
        View view = new View();
        Presenter presenter = new Presenter(view);
        presenter.setModel(model);

        // В данном случае презентер получает данные откуда-то, например при нажатии на кнопку
        // Эти данные уходят на модель, обрабатываются ей, далее передаются на View


        // При этом в отличии от MVC, где контроллер выдает нужный View, здесь Presenter связан с конкретным View
        // и без presenter'а View работать не будет.
        // А вообще здесь есть неплохие схемы: http://stackoverflow.com/questions/2056/what-are-mvp-and-mvc-and-what-is-the-difference
        presenter.start();
        presenter.dataEvent("TEST DATA");
        presenter.confirmed();
    }
}
