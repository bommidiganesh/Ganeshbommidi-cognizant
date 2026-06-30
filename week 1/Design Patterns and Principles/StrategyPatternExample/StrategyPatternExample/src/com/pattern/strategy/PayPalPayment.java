package com.pattern.strategy;

/**
 * Concrete Strategy implementing PayPal payment.
 */
public class PayPalPayment implements PaymentStrategy {
    private final String emailId;
    private final String password;

    public PayPalPayment(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("[PayPalPayment] Paid $%.2f using PayPal account (Email: %s)%n", amount, emailId);
    }
}
