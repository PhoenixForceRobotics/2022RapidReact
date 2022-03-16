package frc.robot.commands.drivebase;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import frc.robot.utils.Constants;
import frc.robot.utils.CustomMath;
import frc.robot.utils.OI;

public class RunDriveBase extends CommandBase {
  private Drivebase drivebase;

  private OI oi;
  private CustomMath customMath;

  private int gearSelect;

  private double leftStickPosition;
  private double rightStickPosition;
  private double multiplier;

  public RunDriveBase(Drivebase drivebase, OI oi) {
    this.oi = oi;
    this.drivebase = drivebase;

    addRequirements(drivebase);
    customMath = new CustomMath();

    // Adds values to the list of gear speeds according to their gear positions.
  }

  @Override
  public void initialize() {
    drivebase.motorCoast();
  }

  @Override
  public void execute() {
    // set the variables multiplier and reverser using the getter methods in the
    // drivebase class

    multiplier = drivebase.getMultiplier();
    leftStickPosition = oi.driverController.leftStick.getY();
    rightStickPosition = oi.driverController.rightStick.getY();

    // making the second input have the same sign as the first input
    drivebase.leftMotorSpeed(
        (customMath.makeSign(
            leftStickPosition,
            multiplier
                * Math.pow(
                    leftStickPosition, Constants.SubsystemSpeeds.DrivebaseValues.StickPower))));

    drivebase.rightMotorSpeed(
        (customMath.makeSign(
            rightStickPosition,
            multiplier
                * Math.pow(
                    rightStickPosition, Constants.SubsystemSpeeds.DrivebaseValues.StickPower))));

    System.out.println(
        "Speed currently at " + drivebase.getMotorSpeed() + "\nGear setting: " + gearSelect);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
