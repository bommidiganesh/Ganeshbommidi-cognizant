package com.pattern.command;

public class CommandTest {
    public static void main(String[] args) {
        System.out.println("=== Running Command Pattern Verification ===");

        // Create the Receiver
        Light livingRoomLight = new Light();

        // Create Concrete Commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Create the Invoker
        RemoteControl remote = new RemoteControl();

        System.out.println("--- Test 1: Button Press with No Command Assigned ---");
        remote.pressButton();
        System.out.println();

        System.out.println("--- Test 2: Issuing Light On Command ---");
        remote.setCommand(lightOn);
        remote.pressButton();
        if (!livingRoomLight.isOn()) {
            System.err.println("TEST FAILED: Light should be ON!");
            System.exit(1);
        }
        System.out.println();

        System.out.println("--- Test 3: Issuing Light Off Command ---");
        remote.setCommand(lightOff);
        remote.pressButton();
        if (livingRoomLight.isOn()) {
            System.err.println("TEST FAILED: Light should be OFF!");
            System.exit(1);
        }
        System.out.println();

        System.out.println("TEST PASSED: Commands were successfully encapsulated and executed through the invoker.");
        System.out.println("=== Command Pattern Verification Completed Successfully ===\n");
    }
}
