package com.pattern.adapter;

/**
 * An Adaptee class. Contains a different API than the target interface.
 */
public class PayPalGateway {
    public void sendPayment(double amountInUSD) {
        System.out.println("[PayPalGateway] processing payment of $" + amountInUSD + " via PayPal API.");
    }
}
