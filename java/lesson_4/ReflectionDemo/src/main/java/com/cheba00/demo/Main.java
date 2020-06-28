package com.cheba00.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        SomeClass someClass = new SomeClass();
        Class<SomeClass> someClassAsClass = (Class<SomeClass>) someClass.getClass();
        Field field = someClassAsClass.getDeclaredField("someField");

        Method[] methods= someClassAsClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());

        }

    }
}
