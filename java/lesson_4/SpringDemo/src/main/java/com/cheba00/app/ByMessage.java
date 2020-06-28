package com.cheba00.app;

public class ByMessage implements Message {
    private String text;
    @Override
    public String getText() {
        return text;
    }

    public ByMessage(String text) {
        this.text = "By" + text;
    }
}
