package org.example.entity;

public class Controller {
    public Context context;

    public Controller(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "context=" + context +
                '}';
    }
}
