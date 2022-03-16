package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants;
import frc.robot.utils.Motor;
import frc.robot.utils.SparkMotorGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Drivebase extends SubsystemBase {
  // Create Motor Data Fields
  RelativeEncoder leftMotorEncoder;
  RelativeEncoder rightMotorEncoder;

  double Multiplier = 1;

  private SparkMotorGroup leftMotors;
  private SparkMotorGroup rightMotors;

  // Drivebase constructor
  public Drivebase() {
    // Set the motor instances to an object
    // The parameters for a motor are (portNumber, MotorType, reversedOrNotBooleam,
    // voltageInput)
    // MotorType for our robot is kBrushless, and the voltage input is 40)
    // Set the Motors idle mode to coast.
    // to do so, use "motorName.setIdleMode(Idlemode.kCoast);"

    leftMotors = new SparkMotorGroup(false,
        new Motor(
            Constants.MotorMap.Drivebase.LEFT_1,
            MotorType.kBrushless,
            Constants.MotorMap.Drivebase.LEFT1_REVERSED,
            40),
        new Motor(
            Constants.MotorMap.Drivebase.LEFT_2,
            MotorType.kBrushless,
            Constants.MotorMap.Drivebase.LEFT2_REVERSED,
            40));

    rightMotors = new SparkMotorGroup(false,
        new Motor(
            Constants.MotorMap.Drivebase.RIGHT_1,
            MotorType.kBrushless,
            Constants.MotorMap.Drivebase.RIGHT1_REVERSED,
            40),
        new Motor(
            Constants.MotorMap.Drivebase.RIGHT_2,
            MotorType.kBrushless,
            Constants.MotorMap.Drivebase.RIGHT2_REVERSED,
            40));

    leftMotorEncoder = leftMotors.getEncoder();
    leftMotorEncoder = rightMotors.getEncoder();
    motorCoast();
  }

  public void leftMotorSpeed(double speed) {
    leftMotors.set(speed);
  }

  public void rightMotorSpeed(double speed) {
    rightMotors.set(speed);
  }

  public Double getMotorSpeed() {
    return Collections.max(
        new ArrayList<Double>(
            Arrays.asList(
                leftMotors.get(),
                rightMotors.get())));
  }

  // Create a method that sets the motors speeds based on an input
  // All the ones on the left should have the same speed
  // All the ones on the right should have the same speed
  // to do so, use "motorName.set(motorSpeed)"

  public void motorCoast() {
    leftMotors.setCoast();
    rightMotors.setCoast();
  }

  public void motorBreak() {
    leftMotors.setBrake();
    rightMotors.setBrake();
  }

  public void shift() {
    if (Multiplier == Constants.SubsystemSpeeds.DrivebaseSpeed.MotorSpeed) {
      Multiplier = Constants.SubsystemSpeeds.DrivebaseSpeed.MotorSpeed2;
    } else {
      Multiplier = Constants.SubsystemSpeeds.DrivebaseSpeed.MotorSpeed;
    }
  }

  public double getMultiplier() {
    return Multiplier;
  }

}
