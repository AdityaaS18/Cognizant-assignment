package Week1DPP.CommandPatternExample;

// Test the Command Implementation
public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl remoteControl = new RemoteControl();

        // Create commands
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        // Set commands to remote control
        remoteControl.setCommand(lightOnCommand);
        remoteControl.pressButton(); // Light is on

        remoteControl.setCommand(lightOffCommand);
        remoteControl.pressButton(); // Light is off
    }
}
