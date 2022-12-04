package org.example.entity;

import org.example.component.DaggerResolverComponent;

import javax.inject.Inject;

public class OverlayPlugin {
    @Inject
    public Resolver resolver;

    public void onCreate(Context context) {
        DaggerResolverComponent.builder().context(context).build().inject(this);
        System.out.println("onCreate: context is " + context);
        System.out.println("onCreate: resolver is " + resolver);
    }
}
