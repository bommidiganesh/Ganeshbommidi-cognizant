package com.pattern.singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A thread-safe Singleton Logger implementation using double-checked locking.
 */
public class Logger {
    // Volatile instance to ensure visibility of changes across threads
    private static volatile Logger instance;

    // Formatter for timestamped logs
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    // Private constructor to prevent instantiation from other classes
    private Logger() {
        // Guard against reflection attacks
        if (instance != null) {
            throw new IllegalStateException("Logger instance already exists. Use getInstance() method.");
        }
        System.out.println("[Logger] Initializing unique Logger instance...");
    }

    /**
     * Public static method to retrieve the single instance of the Logger class.
     * Implements double-checked locking for thread safety and lazy initialization.
     *
     * @return The unique Logger instance
     */
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    /**
     * Log a message with a timestamp.
     *
     * @param message The message to log
     */
    public void log(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.printf("[%s] [LOG] %s%n", timestamp, message);
    }
}
