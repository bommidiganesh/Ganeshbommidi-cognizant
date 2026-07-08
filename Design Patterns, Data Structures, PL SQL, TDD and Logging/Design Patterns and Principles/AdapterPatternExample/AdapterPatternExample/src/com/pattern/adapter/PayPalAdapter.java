package com.pattern.adapter;

/**
 * Adapter class for PayPalGateway.
 * Adapts PayPalGateway to the PaymentProcessor interface.
 */
public class PayPalAdapter implements PaymentProcessor {
    private final PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Translates the call to PayPal-specific method
        payPalGateway.sendPayment(amount);
    }
}
