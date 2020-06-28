package com.cheba00.app;

public class ByMessage implements Message {
    private String text;
    @Override
    public String getText() {
        return this.text;
    }

    public ByMessage(String text) {
        this.text = "By" + text;
    }
}
