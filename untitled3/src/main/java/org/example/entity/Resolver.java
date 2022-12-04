package org.example.entity;

public class Resolver {

    private final Context context;
    private final Controller controller;

    public Resolver(Context context, Controller controller) {
        this.context = context;
        this.controller = controller;
    }

    public Context getContext() {
        return context;
    }

    public Controller getController() {
        return controller;
    }

    @Override
    public String toString() {
        return "Resolver{" +
                "context=" + context +
                ", controller=" + controller +
                '}';
    }
}
