package com.pattern.decorator;

/**
 * Abstract Decorator class implementing the Component interface and holding a reference to another Component.
 */
public abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        if (wrappedNotifier != null) {
            wrappedNotifier.send(message);
        }
    }
}
