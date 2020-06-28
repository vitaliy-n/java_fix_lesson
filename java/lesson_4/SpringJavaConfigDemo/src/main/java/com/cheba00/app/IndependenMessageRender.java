package com.cheba00.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@Component
@ComponentScan(basePackages = "com.cheba00.app")
public class IndependenMessageRender {
    @Autowired
    private MessageRender renderer;


    public void print(){
        renderer.printMessage();

    }
}
