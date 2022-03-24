package frc.robot.commands.turret;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;
import frc.robot.utils.FlywheelMath;
import frc.robot.utils.NetworkTableManager;

public class SetHoodToTargetAngle extends CommandBase {
  NetworkTableManager networkTableManager;

  private Turret turret;

  private PIDController pid;

  public SetHoodToTargetAngle(Turret turret) {
    this.turret = turret;
    pid = new PIDController(0.3, 0, 0);
  }

  @Override
  public void execute() {
    pid.setSetpoint(
        FlywheelMath.getTheta()); // TODO: Ask Emily whether this accounts for the turret angle
                                  // Not Yet  :,) - Emily 

    turret.setHood(pid.calculate(0));
  }
}
