/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.utils;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Robot;
import frc.robot.commands.intakefeeder.RunCollectorMotor;
import frc.robot.commands.intakefeeder.RunCollectorPiston;
import frc.robot.commands.turret.FlywheelVelocity;
import frc.robot.commands.turret.TurretAutoAim;
import frc.robot.commands.turret.TurretManualTurn;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands
 * and command groups that allow control of the robot.
 */
public class OI {
  public PFRController driverController;
  public PFRController operatorController;

  public OI() {
    driverController = new PFRController(0);
    operatorController = new PFRController(1);

    // Initialize Button Bindings
    // operatorController.aButton().whenPressed(new FlywheelHood(Robot.flywheel));
    // operatorController.bButton().whenPressed(new ToggleFlywheelPID(Robot.flywheel));
    // operatorController.yButton().whenPressed(new ClimbDown(Robot.climber));
    // operatorController.xButton().whenPressed(new ClimbUp(Robot.climber));


    operatorController.bButton().whenPressed(new RunCollectorPiston(Robot.shuttle, Value.kForward));
    operatorController
        .bButton()
        .whenReleased(new RunCollectorPiston(Robot.shuttle, Value.kReverse));

    operatorController.lTriggerButton().whileHeld(new RunCollectorMotor(Robot.shuttle, false));
    operatorController.rTriggerButton().whileHeld(new RunCollectorMotor(Robot.shuttle, false));

    operatorController.lTriggerButton().whenPressed(new RunCollectorPiston(Robot.shuttle, Value.kForward));
    operatorController.lTriggerButton().whenReleased(new RunCollectorPiston(Robot.shuttle, Value.kReverse));
 
    // operatorController.lTriggerButton().whenPressed(new RunCollectorPiston(Robot.shuttle,
    // Value.kForward));
    // operatorController.lTriggerButton().whenReleased(new RunCollectorPiston(Robot.shuttle,
    // Value.kReverse));

    // operatorController.yButton().whenPressed(new ClimbDown(Robot.climber));
    // operatorController.xButton().whenPressed(new ClimbUp(Robot.climber));
    // operatorController.rBumper().whenPressed(new IntakeWheelMove(Robot.intake));

    driverController.lBumper().whenHeld(new TurretManualTurn(Robot.turret, this));
    driverController.lBumper().whenReleased(new TurretAutoAim(Robot.turret));
    driverController.aButton().whenHeld(new FlywheelVelocity(Robot.turret, this));
    /// Operator:

    // operatorController.yButton().whenPressed(new PistonMove(Robot.intake));
    // operatorController.rightTriggerButton.whenPressed(new intakeWheelMove(Robot.intake));
    // operatorController.leftTriggerButton.whenPressed(new intakeWheelMove(Robot.intake));
    /*
     * Example:
     * driverController.aButton().whenPressed(RunDrivebase(Robot.drivebase));
     */

    // button.whenReleased(new ExampleCommand());
  }
}

// XBOX ELITE CONTROLLER MAP
//
//
// [ LT ] [ RT ] Left Trigger, Right Trigger
// [ LB ] [ RB ] Left Bumper, Right Bumper
// ------------ ------------
// / \--------------/ \
// / ---- Y \ Left Stick, Home Button
// / / \ \ / X B \
// / \ / / \ A \ Y Button, X Button, B
// Button, A Button
// / ---- \
// / [] [] \ Select Button, Start
// Button
// / \
// / || -------------------------- ---- \
// \ ======== / \ / \ / DPad, Right Stick
// \ || / \ \ / /
// \ / \ ---- /
// ----------- -----------

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
