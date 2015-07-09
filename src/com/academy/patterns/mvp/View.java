package com.academy.patterns.mvp;

/**
 * Created by keos on 09.07.15.
 */
public class View {

    private boolean opened;

    private Presenter presenter;

    public void open() {
        opened = true;
    }

    public void close() {
        opened = false;
    }

    public boolean isOpened() {
        return opened;
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void displayData(String data) {
        System.out.println("Incoming data: " + data);
    }
}
