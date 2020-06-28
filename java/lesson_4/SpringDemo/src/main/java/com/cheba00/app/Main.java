package com.cheba00.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com.cheba00\\context.xml");
//        MessageRender messageRender = (MessageRender) applicationContext.getBean("renderer");
//        messageRender.printMessage();
        IndependenMessageRender render = applicationContext.getBean(IndependenMessageRender.class);
        render.print();


    }
}
