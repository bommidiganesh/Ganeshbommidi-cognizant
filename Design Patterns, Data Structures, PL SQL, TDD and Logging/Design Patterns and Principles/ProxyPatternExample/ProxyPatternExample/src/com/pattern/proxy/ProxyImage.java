package com.pattern.proxy;

/**
 * Proxy class that controls access to RealImage,
 * implementing lazy initialization and caching.
 */
public class ProxyImage implements Image {
    private final String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
        // Notice: We do NOT instantiate RealImage here.
        // This achieves lazy initialization.
    }

    @Override
    public void display() {
        if (realImage == null) {
            System.out.println("[ProxyImage] RealImage not loaded yet. Lazy-instantiating...");
            realImage = new RealImage(filename); // Cache the instance
        } else {
            System.out.println("[ProxyImage] Retrieval from CACHE for image: " + filename);
        }
        realImage.display();
    }
}
