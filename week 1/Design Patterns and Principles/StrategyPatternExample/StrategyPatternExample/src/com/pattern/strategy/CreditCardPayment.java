package com.pattern.strategy;

/**
 * Concrete Strategy implementing Credit Card payment.
 */
public class CreditCardPayment implements PaymentStrategy {
    private final String name;
    private final String cardNumber;
    private final String cvv;
    private final String expiryDate;

    public CreditCardPayment(String name, String cardNumber, String cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount) {
        // Mask card number for security display
        String maskedCard = "****-****-****-" + (cardNumber.length() > 4 ? cardNumber.substring(cardNumber.length() - 4) : "1111");
        System.out.printf("[CreditCardPayment] Paid $%.2f using Credit Card (Holder: %s, Card: %s)%n", amount, name, maskedCard);
    }
}
