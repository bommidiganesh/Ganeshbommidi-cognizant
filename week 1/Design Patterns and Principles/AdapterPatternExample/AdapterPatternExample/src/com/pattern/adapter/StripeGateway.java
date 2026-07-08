package com.pattern.adapter;

/**
 * Another Adaptee class. Contains a different API than the target interface.
 */
public class StripeGateway {
    public void chargeCustomer(double amountInCents) {
        System.out.println("[StripeGateway] charging customer cents " + (int)(amountInCents) + " via Stripe API.");
    }
}
