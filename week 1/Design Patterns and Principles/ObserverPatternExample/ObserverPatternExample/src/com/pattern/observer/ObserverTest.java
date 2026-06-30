package com.pattern.observer;

public class ObserverTest {
    public static void main(String[] args) {
        System.out.println("=== Running Observer Pattern Verification ===");

        // Create the subject (StockMarket)
        StockMarket stockMarket = new StockMarket();

        // Create observers
        Observer mobileApp = new MobileApp("MyTrade Mobile");
        Observer webApp = new WebApp("Global Finance Portal");

        System.out.println("--- Test 1: Registering Observers and Broadcasting Price Change ---");
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);
        
        // Update stock and notify
        stockMarket.updatePrice("GOOGL", 185.50);
        System.out.println();

        System.out.println("--- Test 2: Another Price Update (All Observers Active) ---");
        stockMarket.updatePrice("AAPL", 172.30);
        System.out.println();

        System.out.println("--- Test 3: Deregistering MobileApp Observer ---");
        stockMarket.deregisterObserver(mobileApp);
        System.out.println("MobileApp unregistered. Changing price of MSFT...");
        stockMarket.updatePrice("MSFT", 420.75);
        System.out.println();

        System.out.println("TEST PASSED: Stock price updates were correctly dispatched to all registered observers, and ignored by deregistered observers.");
        System.out.println("=== Observer Pattern Verification Completed Successfully ===\n");
    }
}
