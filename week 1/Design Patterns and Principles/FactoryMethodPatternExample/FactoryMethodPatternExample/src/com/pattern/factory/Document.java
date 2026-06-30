package com.pattern.factory;

/**
 * Interface representing a generic Document.
 */
public interface Document {
    void open();
    void close();
    String getType();
}
