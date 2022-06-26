package org.example;

import dagger.Component;

import javax.inject.Inject;

public class A {
    @Inject
    public A() {}

    void a() {
        System.out.println('a');
    }

    static class B {
        @Inject A a;
        public B(){
            DaggerA_AComponent.create().inject(this);
            System.out.println("init b");
        }
        void b() {
            a.a();
            System.out.println('b');
        }
    }

    @Component
    interface AComponent{
        void inject(B b);
    }

    static class C extends B {
        @Inject A ac;

        public C(){
            super();
        }
        void c() {
            System.out.println('c');
            ac.a();
        }
    }
}
