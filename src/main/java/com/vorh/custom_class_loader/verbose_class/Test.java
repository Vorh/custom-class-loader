package com.vorh.custom_class_loader.verbose_class;

/**
 * Created by vorh on 1/14/18.
 */
public class Test {


    public static class A {

    }

    public static class B extends A{

    }

    public static class C extends B{

    }

    public static void main(String[] args) {
        C c = new C();
        B b = new B();
        A a = new A();


    }
}
