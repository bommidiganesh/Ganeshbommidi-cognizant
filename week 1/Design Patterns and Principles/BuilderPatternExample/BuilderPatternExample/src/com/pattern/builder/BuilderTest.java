package com.pattern.builder;

public class BuilderTest {
    public static void main(String[] args) {
        System.out.println("=== Running Builder Pattern Verification ===");

        // 1. Build a basic office PC (only required parameters)
        System.out.println("--- Building Office Computer ---");
        Computer officePC = new Computer.Builder("Intel Core i3-13100", "8GB DDR4", "256GB NVMe SSD")
                                .build();
        System.out.println(officePC);
        System.out.println();

        // 2. Build a high-end Gaming PC (all parameters)
        System.out.println("--- Building Gaming Computer ---");
        Computer gamingPC = new Computer.Builder("AMD Ryzen 9 7950X", "32GB DDR5", "2TB NVMe SSD")
                                .setGpu("NVIDIA RTX 4090")
                                .setHasWiFi(true)
                                .setHasBluetooth(true)
                                .build();
        System.out.println(gamingPC);
        System.out.println();

        // 3. Build a Server node (some optional parameters)
        System.out.println("--- Building Server Node ---");
        Computer serverNode = new Computer.Builder("Intel Xeon Silver 4410Y", "64GB ECC RAM", "4TB RAID-5 HDD")
                                .setHasWiFi(false)
                                .setHasBluetooth(false)
                                .build();
        System.out.println(serverNode);
        System.out.println();

        // Verification assertions
        if (!officePC.getCpu().equals("Intel Core i3-13100") || officePC.getGpu() != null || officePC.hasWiFi()) {
            System.err.println("TEST FAILED: Office PC properties incorrect!");
            System.exit(1);
        }
        if (!gamingPC.getGpu().equals("NVIDIA RTX 4090") || !gamingPC.hasWiFi() || !gamingPC.hasBluetooth()) {
            System.err.println("TEST FAILED: Gaming PC properties incorrect!");
            System.exit(1);
        }

        System.out.println("TEST PASSED: Computers built and verified successfully using Builder Pattern.");
        System.out.println("=== Builder Pattern Verification Completed Successfully ===\n");
    }
}
