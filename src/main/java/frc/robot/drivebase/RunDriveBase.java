package frc.robot.drivebase;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.Drivebase;
import frc.robot.util.Constants;
import frc.robot.util.CustomMath;

public class RunDriveBase extends CommandBase {
  private Drivebase drivebase;

  private OI oi;
  private CustomMath customMath;

  private int gear_select;

  public RunDriveBase(Drivebase drivebase, OI oi) {
    this.oi = oi;
    this.drivebase = drivebase;

    addRequirements(drivebase);
    customMath = new CustomMath();

    // Adds values to the list of gear speeds according to their gear positions.
  }

  @Override
  public void initialize() {
    drivebase.motor_coast();
  }

  @Override
  public void execute() {
    // set the variables multiplier and reverser using the getter methods in the drivebase class

    int reverser = drivebase.getReverser();
    double multiplier = drivebase.getMultiplier();

    if (reverser == 1) {
      drivebase.left_motorSpeed(
          reverser
              * (customMath.makeSign(
                  oi.driverController.leftStick.getY(),
                  multiplier
                      * Math.pow(
                          oi.driverController.leftStick.getY(),
                          Constants.SubsystemSpeeds.DrivebaseValues.StickPower))));
      drivebase.right_motorSpeed(
          reverser
              * (customMath.makeSign(
                  oi.driverController.rightStick.getY(),
                  multiplier
                      * Math.pow(
                          oi.driverController.rightStick.getY(),
                          Constants.SubsystemSpeeds.DrivebaseValues.StickPower))));
      // Set the motor speeds
      // (reverser * (customMath.makeSign(oi.driverController.leftStick.getY(), multiplier *
      // Math.pow(oi.driverController.leftStick.getY(),Constants.SubsystemSpeeds.DrivebaseValues.StickPower))));
      // (reverser * (customMath.makeSign(oi.driverController.rightStick.getY(), multiplier *
      // Math.pow(oi.driverController.rightStick.getY(),
      // Constants.SubsystemSpeeds.DrivebaseValues.StickPower))));
    } else {
      drivebase.left_motorSpeed(
          reverser
              * (customMath.makeSign(
                  oi.driverController.rightStick.getY(),
                  multiplier
                      * Math.pow(
                          oi.driverController.rightStick.getY(),
                          Constants.SubsystemSpeeds.DrivebaseValues.StickPower))));
      drivebase.right_motorSpeed(
          reverser
              * (customMath.makeSign(
                  oi.driverController.leftStick.getY(),
                  multiplier
                      * Math.pow(
                          oi.driverController.leftStick.getY(),
                          Constants.SubsystemSpeeds.DrivebaseValues.StickPower))));
      // Set the motor speeds
      // setLeft(reverser * (customMath.makeSign(oi.driverController.rightStick.getY(), multiplier *
      // Math.pow(oi.driverController.rightStick.getY(),
      // Constants.SubsystemSpeeds.DrivebaseValues.StickPower))));
      // setRight(reverser * (customMath.makeSign(oi.driverController.leftStick.getY(), multiplier *
      // Math.pow(oi.driverController.leftStick.getY(),
      // Constants.SubsystemSpeeds.DrivebaseValues.StickPower))));
      System.out.println(
          "Speed currently at " + drivebase.get_motorSpeed() + "\nGear setting: " + gear_select);
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
