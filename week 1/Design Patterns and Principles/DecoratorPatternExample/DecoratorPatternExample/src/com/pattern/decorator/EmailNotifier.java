package com.pattern.decorator;

/**
 * Concrete Component representing the core/base notification channel (Email).
 */
public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("[EmailNotifier] Sending email: " + message);
    }
}
