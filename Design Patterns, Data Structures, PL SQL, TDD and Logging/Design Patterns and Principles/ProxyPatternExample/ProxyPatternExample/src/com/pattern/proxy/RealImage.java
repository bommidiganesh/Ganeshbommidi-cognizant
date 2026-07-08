package com.pattern.proxy;

/**
 * Real Subject class. Represents the actual heavy resource.
 */
public class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("[RealImage] Loading heavy image '" + filename + "' from remote server (network request)...");
        try {
            // Simulate network latency
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[RealImage] Image '" + filename + "' loaded successfully.");
    }

    @Override
    public void display() {
        System.out.println("[RealImage] Displaying high-resolution image: " + filename);
    }
}
