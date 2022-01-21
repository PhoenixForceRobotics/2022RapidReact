/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.controllers.BobXboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.commands.climber.*;
import frc.robot.subsystems.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public BobXboxController driverController;
  public BobXboxController operatorController;

  public OI() {
      driverController = new BobXboxController(0, 0.11, 0.11);
      operatorController = new BobXboxController(1, 0.11, 0.11);
  
      /// Driver:
      operatorController.rightStickButton.whenPressed(new activatePistons());

      operatorController.rightStickButton.whenPressed(new spoolsForward());
      operatorController.rightStickButton.whenPressed(new spoolsBackward());
      operatorController.rightStickButton.whenReleased(new spoolsStop());

      operatorController.rightStickButton.whenPressed(new flimseyArmForward());
      operatorController.rightStickButton.whenPressed(new flimseyArmBackward());
      operatorController.rightStickButton.whenReleased(new flimseyArmStop());

      operatorController.rightStickButton.whenPressed(new deactivatePistons());
      operatorController.rightStickButton.whenPressed(new activatePistons());
      operatorController.rightStickButton.whenPressed(new deactivatePistonBreak());

      /// Operator:z

  }
}


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

