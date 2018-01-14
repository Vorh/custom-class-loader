package com.vorh.custom_class_loader.simple;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by vorh on 1/14/18.
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassLoader classLoader = Main.class.getClassLoader();

        loadInterface(new CustomClassLoader(classLoader));
        loadClass(new CustomClassLoader(classLoader));
    }

    private static void loadInterface(CustomClassLoader customClassLoader) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = customClassLoader.findClass("com.vorh.custom_class_loader.simple.Test");
        TestInterface ob = (TestInterface) c.newInstance();
        ob.show();

        Method method = c.getMethod("show");
        method.invoke(ob);

    }

    private static void loadClass(CustomClassLoader classLoader) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = classLoader.findClass("com.vorh.custom_class_loader.simple.Test");
        TestSuperClass ob = (TestSuperClass) c.newInstance();

        System.out.println(ob.getClass());
        ob.show();

        Method method = c.getMethod("show");
        method.invoke(ob);

    }
}
