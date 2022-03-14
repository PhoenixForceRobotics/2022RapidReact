package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.Map;

public class PID extends SubsystemBase {

  // public PIDController intakeRotatorPID;
  public PIDController climberArmPID;

  // double intakeRotatorKp = 0.2;
  // double intakeRotatorKi = 0;
  // double intakeRotatorKd = 0;

  double climberArmKp = 0.2;
  double climberArmKi = 0;
  double climberArmKd = 0;

  private ShuffleboardTab tab = Shuffleboard.getTab("Climber PID");

  // private NetworkTableEntry intakeRotatorKpEntry =
  // tab.add("intakeRotatorKp", intakeRotatorKp)
  // .withWidget(BuiltInWidgets.kNumberSlider)
  // .withProperties(Map.of("min", 0, "max", 1)) // specify widget properties here
  // .getEntry();
  // private NetworkTableEntry intakeRotatorKiEntry =
  // tab.add("intakeRotatorKi", intakeRotatorKi)
  // .withWidget(BuiltInWidgets.kNumberSlider)
  // .withProperties(Map.of("min", 0, "max", 0.1)) // specify widget properties
  // here
  // .getEntry();
  // private NetworkTableEntry intakeRotatorKdEntry =
  // tab.add("intakeRotatorKd", intakeRotatorKd)
  // .withWidget(BuiltInWidgets.kNumberSlider)
  // .withProperties(Map.of("min", 0, "max", 0.1)) // specify widget properties
  // here
  // .getEntry();

  private NetworkTableEntry climberArmKpEntry = tab.add("climberArmKp", climberArmKp)
      .withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("min", 0, "max", 0.2)) // specify widget properties here
      .getEntry();
  private NetworkTableEntry climberArmKiEntry = tab.add("climberArmKi", climberArmKi)
      .withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("min", 0, "max", 0.1)) // specify widget properties here
      .getEntry();
  private NetworkTableEntry climberArmKdEntry = tab.add("climberArmKd", climberArmKd)
      .withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("min", 0, "max", 0.1)) // specify widget properties here
      .getEntry();

  public PID() {
    System.out.println("PID has been called");
    // change values, need to test to find the right values.
    climberArmPID = new PIDController(climberArmKp, climberArmKi, climberArmKd);
    // intakeRotatorPID = new PIDController(intakeRotatorKp, intakeRotatorKi,
    // intakeRotatorKd);
  }

  public double climberArmCalculate(double measurement) {
    climberArmKp = climberArmKpEntry.getDouble(1.0);
    climberArmKi = climberArmKiEntry.getDouble(1.0);
    climberArmKd = climberArmKdEntry.getDouble(1.0);

    climberArmPID.setP(climberArmKp);
    climberArmPID.setI(climberArmKi);
    climberArmPID.setD(climberArmKd);

    return climberArmPID.calculate(measurement);
  }

  public boolean climberArmAtSetPoint() {
    return climberArmPID.atSetpoint();
  }

  public void climberArmSetSetPoint(double setPoint) {
    climberArmPID.setSetpoint(setPoint);
  }

  public void climberArmSetTolerance(double tolerance) {
    climberArmPID.setTolerance(tolerance);
  }

  public void climberArmReset() {
    climberArmPID.reset();
  }

  // public double intakeRotatorCalculate(double measurement) {
  // intakeRotatorKp = intakeRotatorKpEntry.getDouble(1.0);
  // intakeRotatorKi = intakeRotatorKiEntry.getDouble(0);
  // intakeRotatorKd = intakeRotatorKdEntry.getDouble(0);

  // intakeRotatorPID.setP(intakeRotatorKp);
  // intakeRotatorPID.setI(intakeRotatorKi);
  // intakeRotatorPID.setD(intakeRotatorKd);
  // return intakeRotatorPID.calculate(measurement);
  // }

  // public boolean intakeRotatorAtSetPoint() {
  // return intakeRotatorPID.atSetpoint();
  // }

  // public void intakeRotatorSetSetPoint(double setPoint) {
  // intakeRotatorPID.setSetpoint(setPoint);
  // }

  // public void intakeRotatorSetTolerance(double tolerance) {
  // intakeRotatorPID.setTolerance(tolerance);
  // }

  // public void intakeRotatorReset() {
  // intakeRotatorPID.reset();
  // }
}
