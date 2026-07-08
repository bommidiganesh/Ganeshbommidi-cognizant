package com.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject class. Maintains stock prices and notifies observers of any changes.
 */
public class StockMarket implements Stock {
    private final List<Observer> observers;
    private String stockName;
    private double price;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        if (o != null && !observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void deregisterObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }

    /**
     * Change the stock price and trigger notifications to all observers.
     */
    public void updatePrice(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        System.out.println("\n[StockMarket] Stock Update: " + stockName + " is now $" + price);
        notifyObservers();
    }
}
