package com.pattern.observer;

/**
 * Concrete Observer representing a mobile application.
 */
public class MobileApp implements Observer {
    private final String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("[MobileApp - " + appName + "] Push Notification: " + stockName + " price changed to $" + price);
    }
}
