package com.academy.patterns.mvp;

/**
 * Created by keos on 09.07.15.
 */
public class Presenter {

    private View view;

    private Model model;

    public Presenter(View view) {
        this.view = view;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void start() {
        view.setPresenter(this);
        view.open();
    }

    public void dataEvent(String data) {
        System.out.println("Receiving new data...");
        model.processText(data);
        view.displayData(data);
    }

    public void confirmed() {
        System.out.println("Data successfully received.");
    }

    public void cancelled() {
        view.close();
    }
}
