package com.pattern.adapter;

/**
 * Adapter class for StripeGateway.
 * Adapts StripeGateway to the PaymentProcessor interface, converting dollars to cents.
 */
public class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Stripe expects amount in cents, so we translate the values
        double amountInCents = amount * 100.0;
        stripeGateway.chargeCustomer(amountInCents);
    }
}
