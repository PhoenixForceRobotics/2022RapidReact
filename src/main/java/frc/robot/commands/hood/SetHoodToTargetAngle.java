package frc.robot.commands.hood;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;
import frc.robot.utils.FlywheelMath;
import frc.robot.utils.NetworkTableManager;

public class SetHoodToTargetAngle extends CommandBase {
  NetworkTableManager networkTableManager;

  private Turret turret;
  private double maxDegree, minDegree;

  private PIDController pid;

  public SetHoodToTargetAngle(Turret turret) {
    this.turret = turret;
    // shoot angle
    maxDegree = 85;
    minDegree = 45;
    pid = new PIDController(0.1, 0, 0);
  }

  @Override
  public void execute() {
    // pitchAngle = FlywheelMath.getTheta();
    pid.setSetpoint(
        FlywheelMath.getTheta()); // TODO: Ask Emily whether this accounts for the turret angle

    turret.setHood(pid.calculate(turret.getHoodAngle()));
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
