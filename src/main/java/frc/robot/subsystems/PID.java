package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.Map;

public class PID extends SubsystemBase {

  public PIDController intakeRotatorPID;
  public PIDController flimseyPID;

  double intakeRotatorKp = 0.5;
  double intakeRotatorKi = 0;
  double intakeRotatorKd = 0;

  double flimseyKp = 0.2;
  double flimseyKi = 0;
  double flimseyKd = 0;

  private ShuffleboardTab tab = Shuffleboard.getTab("Climber PID");

  private NetworkTableEntry intakeRotatorKpEntry =
      tab.add("intakeRotatorKp", intakeRotatorKp)
          .withWidget(BuiltInWidgets.kNumberSlider)
          .withProperties(Map.of("min", 0, "max", 1)) // specify widget properties here
          .getEntry();

  private NetworkTableEntry intakeRotatorKiEntry =
      tab.add("intakeRotatorKi", intakeRotatorKi).getEntry();
  private NetworkTableEntry intakeRotatorKdEntry =
      tab.add("intakeRotatorKd", intakeRotatorKd).getEntry();

  private NetworkTableEntry flimseyKpEntry =
      tab.add("flimseyKp", flimseyKp)
          .withWidget(BuiltInWidgets.kNumberSlider)
          .withProperties(Map.of("min", 0, "max", 0.2)) // specify widget properties here
          .getEntry();
  private NetworkTableEntry flimseyKiEntry =
      tab.add("flimseyKi", flimseyKi)
          .withWidget(BuiltInWidgets.kNumberSlider)
          .withProperties(Map.of("min", 0, "max", 0.2)) // specify widget properties here
          .getEntry();
  private NetworkTableEntry flimseyKdEntry =
      tab.add("flimseyKd", flimseyKd)
          .withWidget(BuiltInWidgets.kNumberSlider)
          .withProperties(Map.of("min", 0, "max", 0.2)) // specify widget properties here
          .getEntry();

  public PID() {
    System.out.println("PID has been called");
    // change values, need to test to find the right values.
    flimseyPID = new PIDController(flimseyKp, flimseyKi, flimseyKd);
    // intakeRotatorPID = new PIDController(intakeRotatorKp, intakeRotatorKi, intakeRotatorKd);
  }

  public double flimseyCalculate(double measurement) {
    flimseyKp = flimseyKpEntry.getDouble(1.0);
    flimseyKi = flimseyKiEntry.getDouble(1.0);
    flimseyKd = flimseyKdEntry.getDouble(1.0);

    flimseyPID.setP(flimseyKp);
    flimseyPID.setI(flimseyKi);
    flimseyPID.setD(flimseyKd);

    return flimseyPID.calculate(measurement);
  }

  public boolean flimseyAtSetPoint() {
    return flimseyPID.atSetpoint();
  }

  public void flimseySetSetPoint(double setPoint) {
    flimseyPID.setSetpoint(setPoint);
  }

  public void flimseySetTolerance(double tolerance) {
    flimseyPID.setTolerance(tolerance);
  }

  public void flimseyReset() {
    flimseyPID.reset();
  }

  public void printThing() {
    System.out.println("Print thing");
  }

  public double intakeRotatorCalculate(double measurement) {
    intakeRotatorKp = intakeRotatorKpEntry.getDouble(1.0);
    intakeRotatorKi = intakeRotatorKiEntry.getDouble(1.0);
    intakeRotatorKd = intakeRotatorKdEntry.getDouble(1.0);

    intakeRotatorPID.setP(intakeRotatorKp);
    intakeRotatorPID.setI(intakeRotatorKi);
    intakeRotatorPID.setD(intakeRotatorKd);
    return intakeRotatorPID.calculate(measurement);
  }

  public boolean intakeRotatorAtSetPoint() {
    return intakeRotatorPID.atSetpoint();
  }

  public void intakeRotatorSetSetPoint(double setPoint) {
    intakeRotatorPID.setSetpoint(setPoint);
  }

  public void intakeRotatorSetTolerance(double tolerance) {
    intakeRotatorPID.setTolerance(tolerance);
  }

  public void intakeRotatorReset() {
    intakeRotatorPID.reset();
  }
}
