package frc.team2097.utility;

import frc.team2097.Robot;
import frc.team2097.commands.FlywheelHood;
import frc.team2097.commands.ToggleFlywheelPID;

public class OI {
    public PFRController driverController;
    public PFRController operatorController;

    public OI() {
        driverController = new PFRController(0);
        operatorController = new PFRController(1);

        // Initialize Button Bindings
        operatorController.aButton().whenPressed(new FlywheelHood(Robot.flywheel));

        operatorController.bButton().whenPressed(new ToggleFlywheelPID(Robot.flywheel));
        /*
         * Example:
         * driverController.aButton().whenPressed(RunDrivebase(Robot.drivebase));
         */

            //                        XBOX ELITE CONTROLLER MAP
    // 
    // 
    //               [ LT ]                        [ RT ]                  Left Trigger, Right Trigger
    //            [    LB    ]                  [    RB    ]               Left Bumper, Right Bumper
    //            ------------                  ------------
    //          /              \--------------/              \              
    //         /      ----                             Y      \             Left Stick, Home Button   
    //        /     /      \         \ /            X     B    \            
    //       /      \      /         / \               A        \           Y Button, X Button, B Button, A Button
    //      /         ----                                       \
    //     /                    []         []                     \         Select Button, Start Button
    //    /                                                        \
    //   /      ||        --------------------------       ----     \
    //   \   ========    /                          \    /      \   /       DPad, Right Stick
    //    \     ||      /                            \   \      /  /
    //     \           /                              \    ----   /
    //      -----------                                -----------
  
  
  
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    //// joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
  
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
  
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
  
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
  
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
  
    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    }
}
