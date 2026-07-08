package com.pattern.observer;

/**
 * Concrete Observer representing a web application dashboard.
 */
public class WebApp implements Observer {
    private final String dashboardName;

    public WebApp(String dashboardName) {
        this.dashboardName = dashboardName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("[WebApp - " + dashboardName + "] Dashboard Alert: Stock " + stockName + " is trading at $" + price);
    }
}
