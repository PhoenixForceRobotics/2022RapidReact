package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Flywheel;
import frc.robot.utils.Constants.TurretConstants;

public class FlywheelPID extends CommandBase {
  private double P, D;
  private double previous_error, setVelocity, error, derivative;
  private Flywheel flywheel;
  private double PIDSpeed;
  private boolean PIDstatus;

  public FlywheelPID(Flywheel flywheel, double setVelocity) {
    this.flywheel = flywheel;
    P = TurretConstants.FLYWHEEL_P;
    D = TurretConstants.FLYWHEEL_D;
    previous_error = 0;
    error = 0;
    derivative = 0;
    PIDSpeed = 0;
    this.setVelocity = setVelocity / .969; // .969 is gear ratio
  }

  public boolean PID() {
    error = setVelocity - flywheel.getFWLeftEncoderVel();
    derivative = (error - this.previous_error) / .02;
    PIDSpeed += (P * error + D * derivative);
    this.previous_error = error;
    return (error <= .5 && error >= .5);
  }

  @Override
  public void initialize() {
    flywheel.resetFWEncoder();
  }

  @Override
  public void execute() {
    // setVelocity = FlywheelMath.getVelocity();
    // PIDstatus = PID();
    // if (flywheel.getToggleFlyWheel() && PIDstatus == false) {
    //     flywheel.setFlywheel(PIDSpeed);
    // } else if(!flywheel.getToggleFlyWheel()) {
    //    flywheel.setFlywheelPercent(0);
    // } else {
    //     // Keeps at previous speed
    // }
    if (flywheel.getToggleFlyWheel()) {
      flywheel.setFlywheelPercent(.1);
    } else if (!flywheel.getToggleFlyWheel()) {
      flywheel.setFlywheelPercent(0);
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
