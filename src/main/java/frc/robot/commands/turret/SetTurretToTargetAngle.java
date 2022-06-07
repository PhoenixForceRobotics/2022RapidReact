package frc.robot.commands.turret;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;

public class SetTurretToTargetAngle extends CommandBase {
  private Turret turret;
  private double targetAngle;
  private PIDController pidController;

  public SetTurretToTargetAngle(Turret turret, double targetAngle) {
    this.turret = turret;
    this.targetAngle = targetAngle;

    pidController = new PIDController(0.003, 0, 0.0001);
  }

  @Override
  public void initialize() {
    pidController.setSetpoint(targetAngle);
  }

  @Override
  public void execute() {
    turret.setRotation(pidController.calculate(turret.getTurretRotations()));
  }

  @Override
  public boolean isFinished() {
    return pidController.atSetpoint();
  }

  @Override
  public void end(boolean interrupted) {
    turret.setRotation(0);
  }
}
