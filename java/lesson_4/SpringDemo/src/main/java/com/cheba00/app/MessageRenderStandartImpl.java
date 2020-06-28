package com.cheba00.app;


public class MessageRenderStandartImpl implements MessageRender {
    public Message message;


    public MessageRenderStandartImpl(Message message) {
        this.message = message;
    }



    public void printMessage(){
        System.out.println(message.getText());
    }
}
