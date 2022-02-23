/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.controllers.BobXboxController;
import frc.robot.commands.climberautomated.ActivateNextSequence;
import frc.robot.commands.climberautomated.ClimberSequence;
import frc.robot.commands.climberautomated.DeactivateNextSequence;
import frc.robot.commands.climberautomated.RunFlimseyArm;
import frc.robot.commands.climbermanual.FlimseyForward;
import frc.robot.commands.climbermanual.FlimseyStop;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands
 * and command groups that allow control of the robot.
 */
public class OI {

  public BobXboxController driverController;
  public BobXboxController operatorController;

  public OI() {
    driverController = new BobXboxController(0, 0.11, 0.11);
    operatorController = new BobXboxController(1, 0.11, 0.11);

    // Climber Manual
    driverController.xButton.whenPressed(new FlimseyForward(Robot.climber));
    driverController.xButton.whenReleased(new FlimseyStop(Robot.climber));

    // Climber Automatic
    // Main
    driverController.bButton.whenPressed(new ClimberSequence());
    // Activate next sequence
    driverController.rightTriggerButton.whenPressed(new ActivateNextSequence());
    driverController.rightTriggerButton.whenReleased(new DeactivateNextSequence());

    // Climber testing
    driverController.aButton.whenPressed(
        new RunFlimseyArm(Robot.climber, Robot.pid, 0.5, 0.005, 0.1));
  }
}

  //                        XBOX ELITE CONTROLLER MAP
  //
  //
  //               [ LT ]                        [ RT ]                  Left Trigger, Right Trigger
  //            [    LB    ]                  [    RB    ]               Left Bumper, Right Bumper
  //            ------------                  ------------
  //          /              \--------------/              \
  //         /      ----                             Y      \             Left Stick, Home Button
  //        /     /      \         \ /            X     B    \
  //       /      \      /         / \               A        \           Y Button, X Button, B
  // Button, A Button
  //      /         ----                                       \
  //     /                    []         []                     \         Select Button, Start
  // Button
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
