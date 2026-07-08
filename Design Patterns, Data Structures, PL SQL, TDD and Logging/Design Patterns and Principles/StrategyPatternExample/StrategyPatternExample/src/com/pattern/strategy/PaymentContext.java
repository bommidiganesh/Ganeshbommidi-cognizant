package com.pattern.strategy;

/**
 * Context class that holds a reference to a PaymentStrategy.
 * Clients interact with this context rather than executing strategies directly.
 */
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    /**
     * Set or change the strategy at runtime.
     *
     * @param paymentStrategy The payment strategy to use
     */
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * Execute the strategy.
     *
     * @param amount The payment amount
     */
    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy is not set.");
        }
        paymentStrategy.pay(amount);
    }
}
