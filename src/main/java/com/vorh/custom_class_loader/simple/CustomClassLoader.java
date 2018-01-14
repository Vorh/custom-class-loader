package com.vorh.custom_class_loader.simple;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by vorh on 1/14/18.
 */
public class CustomClassLoader extends ClassLoader{


    public CustomClassLoader(ClassLoader classLoader) {
        super(classLoader);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = loadClassData(name);
        return defineClass(name,bytes,0,bytes.length);
    }

    private byte[] loadClassData(String name) {
        String url = name.replace(".","/")+".class";
        System.out.println("Loading of class: " + name + " url: " +url);
        InputStream is = getClass().getClassLoader().getResourceAsStream(url);

        ByteArrayOutputStream bytesClass = new ByteArrayOutputStream();


        int len;
        try {
            while ((len = is.read())!= -1){
                bytesClass.write(len);
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return bytesClass.toByteArray();
    }


}
