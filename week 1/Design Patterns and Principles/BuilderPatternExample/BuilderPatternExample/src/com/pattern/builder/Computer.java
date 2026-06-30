package com.pattern.builder;

/**
 * Product class representing a Computer.
 * Utilizes the Builder Pattern for construction of optional and required attributes.
 */
public class Computer {
    // Required attributes
    private final String cpu;
    private final String ram;
    private final String storage;

    // Optional attributes
    private final String gpu;
    private final boolean isGraphicsCardEnabled;
    private final boolean hasWiFi;
    private final boolean hasBluetooth;

    // Private constructor accepting the Builder
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.hasWiFi = builder.hasWiFi;
        this.hasBluetooth = builder.hasBluetooth;
    }

    // Getters
    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getStorage() { return storage; }
    public String getGpu() { return gpu; }
    public boolean isGraphicsCardEnabled() { return isGraphicsCardEnabled; }
    public boolean hasWiFi() { return hasWiFi; }
    public boolean hasBluetooth() { return hasBluetooth; }

    @Override
    public String toString() {
        return "Computer Configuration:\n" +
               "  - CPU: " + cpu + "\n" +
               "  - RAM: " + ram + "\n" +
               "  - Storage: " + storage + "\n" +
               "  - GPU: " + (gpu != null ? gpu : "Integrated Graphics") + "\n" +
               "  - Dedicated Graphics Enabled: " + isGraphicsCardEnabled + "\n" +
               "  - Wi-Fi Adapter: " + (hasWiFi ? "Installed" : "None") + "\n" +
               "  - Bluetooth Adapter: " + (hasBluetooth ? "Installed" : "None");
    }

    /**
     * Static nested Builder class.
     */
    public static class Builder {
        // Required attributes
        private final String cpu;
        private final String ram;
        private final String storage;

        // Optional attributes (default valued)
        private String gpu = null;
        private boolean isGraphicsCardEnabled = false;
        private boolean hasWiFi = false;
        private boolean hasBluetooth = false;

        /**
         * Builder constructor enforcing required fields.
         */
        public Builder(String cpu, String ram, String storage) {
            if (cpu == null || ram == null || storage == null) {
                throw new IllegalArgumentException("CPU, RAM, and Storage are required attributes.");
            }
            this.cpu = cpu;
            this.ram = ram;
            this.storage = storage;
        }

        public Builder setGpu(String gpu) {
            this.gpu = gpu;
            this.isGraphicsCardEnabled = (gpu != null);
            return this; // return builder instance for method chaining
        }

        public Builder setHasWiFi(boolean hasWiFi) {
            this.hasWiFi = hasWiFi;
            return this;
        }

        public Builder setHasBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        /**
         * Builds and returns a new Computer instance.
         */
        public Computer build() {
            return new Computer(this);
        }
    }
}
