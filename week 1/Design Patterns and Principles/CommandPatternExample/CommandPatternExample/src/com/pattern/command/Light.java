package com.pattern.command;

/**
 * Receiver class. Knows how to perform the actual work.
 */
public class Light {
    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("[Light] The light is now ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("[Light] The light is now OFF.");
    }

    public boolean isOn() {
        return isOn;
    }
}
