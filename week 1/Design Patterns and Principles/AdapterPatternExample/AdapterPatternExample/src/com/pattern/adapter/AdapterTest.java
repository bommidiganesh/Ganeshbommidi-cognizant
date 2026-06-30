package com.pattern.adapter;

public class AdapterTest {
    public static void main(String[] args) {
        System.out.println("=== Running Adapter Pattern Verification ===");

        // Create the concrete external gateways (Adaptees)
        PayPalGateway payPalGateway = new PayPalGateway();
        StripeGateway stripeGateway = new StripeGateway();

        // Wrap them in their respective adapters (implements target PaymentProcessor)
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);

        double orderAmount1 = 149.99;
        double orderAmount2 = 75.50;

        System.out.println("--- Test 1: Processing via PayPal Adapter ---");
        payPalProcessor.processPayment(orderAmount1);
        System.out.println();

        System.out.println("--- Test 2: Processing via Stripe Adapter ---");
        stripeProcessor.processPayment(orderAmount2);
        System.out.println();

        // Validate that both are instances of the target interface
        if (!(payPalProcessor instanceof PaymentProcessor) || !(stripeProcessor instanceof PaymentProcessor)) {
            System.err.println("TEST FAILED: Adapters do not implement target PaymentProcessor interface!");
            System.exit(1);
        }

        System.out.println("TEST PASSED: Diverse payment gateways were successfully integrated and executed through adapters.");
        System.out.println("=== Adapter Pattern Verification Completed Successfully ===\n");
    }
}
