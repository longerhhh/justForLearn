package org.example.entity;

public class Context {
    private String name;

    private String description;

    public Context(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Context{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
