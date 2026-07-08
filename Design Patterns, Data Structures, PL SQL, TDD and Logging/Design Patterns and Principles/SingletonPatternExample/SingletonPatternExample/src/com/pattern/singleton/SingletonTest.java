package com.pattern.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("=== Running Singleton Pattern Verification ===");

        // Test 1: Retrieve instance twice in the same thread and verify they are identical references
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First log message via logger1.");
        logger2.log("Second log message via logger2.");

        boolean areIdentical = (logger1 == logger2);
        System.out.println("Reference Comparison (logger1 == logger2): " + areIdentical);

        if (!areIdentical) {
            System.err.println("TEST FAILED: Logger instances are not identical!");
            System.exit(1);
        }
        System.out.println("TEST PASSED: Both references point to the exact same Logger instance.");

        // Test 2: Multithreaded safety verification
        System.out.println("\n--- Starting Multithreaded Access Test ---");
        int threadCount = 5;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        final Logger[] threadInstances = new Logger[threadCount];
        AtomicBoolean threadFailure = new AtomicBoolean(false);

        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            executor.submit(() -> {
                threadInstances[index] = Logger.getInstance();
                threadInstances[index].log("Log from Thread-" + index);
            });
        }

        executor.shutdown();
        try {
            if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
                // Verify all threads received the exact same instance
                Logger masterInstance = Logger.getInstance();
                for (int i = 0; i < threadCount; i++) {
                    if (threadInstances[i] != masterInstance) {
                        threadFailure.set(true);
                    }
                }
            } else {
                System.err.println("Thread execution timed out.");
                threadFailure.set(true);
            }
        } catch (InterruptedException e) {
            System.err.println("Test interrupted: " + e.getMessage());
            threadFailure.set(true);
        }

        if (threadFailure.get()) {
            System.err.println("TEST FAILED: Different Logger instances were created across threads!");
            System.exit(1);
        } else {
            System.out.println("TEST PASSED: All threads shared the exact same Logger instance successfully.");
        }

        System.out.println("=== Singleton Pattern Verification Completed Successfully ===\n");
    }
}
