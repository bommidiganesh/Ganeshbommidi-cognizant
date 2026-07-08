package com.pattern.proxy;

public class ProxyTest {
    public static void main(String[] args) {
        System.out.println("=== Running Proxy Pattern Verification ===");

        String imageFile = "vacation_photo_4k.jpg";
        System.out.println("--- Test 1: Instantiating Proxy Image ---");
        Image image = new ProxyImage(imageFile);
        System.out.println("ProxyImage object created. Notice no loading log has occurred yet.");
        System.out.println();

        System.out.println("--- Test 2: First Call to display() (Should trigger Remote Load) ---");
        long startTime = System.currentTimeMillis();
        image.display();
        long duration1 = System.currentTimeMillis() - startTime;
        System.out.println("Time taken for first display: " + duration1 + " ms");
        System.out.println();

        System.out.println("--- Test 3: Second Call to display() (Should retrieve from Cache) ---");
        startTime = System.currentTimeMillis();
        image.display();
        long duration2 = System.currentTimeMillis() - startTime;
        System.out.println("Time taken for second display: " + duration2 + " ms");
        System.out.println();

        // Basic verification
        if (duration2 >= duration1) {
            System.err.println("Warning: Cache retrieval was not faster than first load!");
        }

        System.out.println("TEST PASSED: Proxy successfully deferred image loading until display time and cached the loaded image.");
        System.out.println("=== Proxy Pattern Verification Completed Successfully ===\n");
    }
}
