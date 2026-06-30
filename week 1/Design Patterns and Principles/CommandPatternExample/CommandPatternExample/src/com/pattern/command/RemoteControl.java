package com.pattern.command;

/**
 * Invoker class. Holds a command and triggers it when a button is pressed.
 */
public class RemoteControl {
    private Command command;

    /**
     * Set the command to be executed by this remote control slot.
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * Trigger the command's execution.
     */
    public void pressButton() {
        if (command == null) {
            System.out.println("[RemoteControl] Button pressed, but no command is assigned to this slot.");
            return;
        }
        System.out.println("[RemoteControl] Button pressed. Executing command...");
        command.execute();
    }
}
