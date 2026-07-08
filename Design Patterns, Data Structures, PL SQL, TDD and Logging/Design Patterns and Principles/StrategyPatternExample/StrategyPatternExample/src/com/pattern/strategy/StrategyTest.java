package com.pattern.strategy;

public class StrategyTest {
    public static void main(String[] args) {
        System.out.println("=== Running Strategy Pattern Verification ===");

        // Initialize the context
        PaymentContext context = new PaymentContext();

        // 1. Pay using Credit Card
        System.out.println("--- Test 1: Checkout using Credit Card Strategy ---");
        PaymentStrategy creditCard = new CreditCardPayment(
            "Alice Smith", 
            "1234567890123456", 
            "123", 
            "12/28"
        );
        context.setPaymentStrategy(creditCard);
        context.executePayment(250.75);
        System.out.println();

        // 2. Pay using PayPal
        System.out.println("--- Test 2: Checkout using PayPal Strategy ---");
        PaymentStrategy payPal = new PayPalPayment(
            "alice.smith@example.com", 
            "secure_password_123"
        );
        context.setPaymentStrategy(payPal);
        context.executePayment(99.90);
        System.out.println();

        // 3. Verify exception when no strategy is set
        System.out.println("--- Test 3: Verifying Protection when no Strategy is Set ---");
        PaymentContext emptyContext = new PaymentContext();
        try {
            emptyContext.executePayment(10.00);
            System.err.println("TEST FAILED: Expected IllegalStateException when no strategy is set!");
            System.exit(1);
        } catch (IllegalStateException e) {
            System.out.println("Success: Caught expected exception: " + e.getMessage());
        }
        System.out.println();

        System.out.println("TEST PASSED: Payment strategies were successfully selected and executed dynamically at runtime.");
        System.out.println("=== Strategy Pattern Verification Completed Successfully ===\n");
    }
}
