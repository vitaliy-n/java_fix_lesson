package com.cheba00.app;

public class MessageRenderErrorImpl implements MessageRender {
    public Message message;


    public MessageRenderErrorImpl(Message message) {
        this.message = message;
    }


    public void printMessage() {
        System.err.println((message.getText()));
    }
}

