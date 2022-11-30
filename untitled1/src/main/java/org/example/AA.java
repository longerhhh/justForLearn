package org.example;

import dagger.Component;

import javax.inject.Inject;

public class AA {
    @Inject
    public AA() {}

    void a() {
        System.out.println('a');
    }

    static class B {
        @Inject
        AA AA;
        public B(){
            DaggerAA_AComponent.create().inject(this);
            System.out.println("init b");
        }
        void b() {
            AA.a();
            System.out.println('b');
        }
    }

    @Component
    interface AComponent{
        void inject(B b);
    }

    static class C extends B {
        @Inject
        AA ac;

        public C(){
            super();
        }
        void c() {
            System.out.println('c');
            ac.a();
        }
    }
}
