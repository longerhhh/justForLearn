package org.example;

import org.example.entity.Context;
import org.example.entity.OverlayPlugin;

public class Main {
    public static void main(String[] args) {
        new OverlayPlugin().onCreate(new Context("name", "description"));
    }
}