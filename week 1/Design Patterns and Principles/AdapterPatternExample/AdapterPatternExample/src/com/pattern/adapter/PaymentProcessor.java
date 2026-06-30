package com.pattern.adapter;

/**
 * The target interface that the client expects to work with.
 */
public interface PaymentProcessor {
    void processPayment(double amount);
}
