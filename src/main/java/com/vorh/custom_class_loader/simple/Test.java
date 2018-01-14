package com.vorh.custom_class_loader.simple;

/**
 * Created by vorh on 1/14/18.
 */
public class Test extends TestSuperClass implements TestInterface{

    @Override
    public void show(){
        System.out.println("Hello world!");
    }
}
