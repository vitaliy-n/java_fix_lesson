package com.cheba00.app;

import org.springframework.beans.factory.annotation.Autowired;

public class IndependenMessageRender {
    @Autowired
    private MessageRender renderer;


    public void print(){
        renderer.printMessage();

    }
}
