package frc.robot.commands.turret;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;
import frc.robot.utils.NetworkTableManager;

public class SetHoodToTargetAngle extends CommandBase {
  NetworkTableManager networkTableManager;

  private Turret turret;

  private PIDController pid;

  public SetHoodToTargetAngle(Turret turret) {
    this.turret = turret;
    pid = new PIDController(0.05, 0, 0);
    pid.setTolerance(0.1, 0.1);
  }

  @Override
  public void initialize() {
    pid.setSetpoint(85);
  }

  @Override
  public void execute() {
    // TODO: Ask Emily whether this accounts for the turret angle
    // Not Yet  :,) - Emily

    turret.setHood(MathUtil.clamp(pid.calculate(turret.getHoodPosition()), -0.1, 0.1));
    System.out.println("Perror: " + pid.getPositionError() + ", At Setpoint: " + pid.atSetpoint());
  }
}
