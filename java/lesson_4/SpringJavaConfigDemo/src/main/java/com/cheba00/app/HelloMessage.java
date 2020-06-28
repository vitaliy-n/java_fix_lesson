package com.cheba00.app;

public class HelloMessage implements Message  {
    private String text;
    @Override
    public String getText() {
        return text;
    }

    public HelloMessage(String text) {
        this.text = "Hello" + text;
    }
}
