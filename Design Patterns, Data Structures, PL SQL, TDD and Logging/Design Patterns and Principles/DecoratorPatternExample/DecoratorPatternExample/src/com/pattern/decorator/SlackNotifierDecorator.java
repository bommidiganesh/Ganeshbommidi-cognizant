package com.pattern.decorator;

/**
 * Concrete Decorator adding Slack notification behavior.
 */
public class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // sends the previous notifications in the chain
        sendSlackMessage(message); // adds Slack notification
    }

    private void sendSlackMessage(String message) {
        System.out.println("[SlackNotifierDecorator] Sending Slack message to channel: " + message);
    }
}
