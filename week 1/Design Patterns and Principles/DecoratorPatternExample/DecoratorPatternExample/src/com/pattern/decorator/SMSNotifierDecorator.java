package com.pattern.decorator;

/**
 * Concrete Decorator adding SMS notification behavior.
 */
public class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // sends the previous notifications in the chain
        sendSMS(message);     // adds SMS notification
    }

    private void sendSMS(String message) {
        System.out.println("[SMSNotifierDecorator] Sending SMS: " + message);
    }
}
