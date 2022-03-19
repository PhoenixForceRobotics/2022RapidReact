package frc.robot.utils;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PID extends SubsystemBase {

  public PIDController newPID;

  public PID() {
    newPID = new PIDController(0, 0, 0.2);
  }

  public double newPIDCalculate(double measurement) {
    return newPID.calculate(measurement);
  }

  public boolean newPIDAtSetPoint() {
    return newPID.atSetpoint();
  }

  public void newPIDSetTolerance(double tolerance) {
    newPID.setTolerance(tolerance);
  }

  public void newPIDSetSetPoint(double setPoint) {
    newPID.setSetpoint(setPoint);
  }

  public void newPIDSetValues(double p, double i, double d) {
    newPID.setP(p);
    newPID.setI(i);
    newPID.setD(d);
  }

  public void newPIDReset() {
    newPID.reset();
  }
}
