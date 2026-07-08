package com.pattern.factory;

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document (.pdf) in Read-Only mode...");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF Document...");
    }

    @Override
    public String getType() {
        return "PDF Document";
    }
}
