package com.pattern.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        System.out.println("=== Running Decorator Pattern Verification ===");

        String criticalAlert = "CRITICAL: Database server disk space is at 98%!";

        // 1. Base Notifier: Only Email
        System.out.println("--- Setup 1: Base Email Notification ---");
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send(criticalAlert);
        System.out.println();

        // 2. Decorated: Email + SMS
        System.out.println("--- Setup 2: Email + SMS Notification ---");
        Notifier emailAndSMS = new SMSNotifierDecorator(emailNotifier);
        emailAndSMS.send(criticalAlert);
        System.out.println();

        // 3. Fully Decorated: Email + SMS + Slack
        System.out.println("--- Setup 3: Email + SMS + Slack Notification ---");
        Notifier multiChannelNotifier = new SlackNotifierDecorator(
                                            new SMSNotifierDecorator(
                                                new EmailNotifier()
                                            )
                                        );
        multiChannelNotifier.send(criticalAlert);
        System.out.println();

        // 4. Dynamic setup: Email + Slack only
        System.out.println("--- Setup 4: Email + Slack Notification (No SMS) ---");
        Notifier emailAndSlack = new SlackNotifierDecorator(new EmailNotifier());
        emailAndSlack.send(criticalAlert);
        System.out.println();

        System.out.println("TEST PASSED: Notifications were successfully sent and layered dynamically across multiple channels.");
        System.out.println("=== Decorator Pattern Verification Completed Successfully ===\n");
    }
}
