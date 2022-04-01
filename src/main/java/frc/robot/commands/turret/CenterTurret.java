package frc.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;

public class CenterTurret extends CommandBase {
  private Turret turret;

  public CenterTurret(Turret turret) {
    this.turret = turret;
  }

  @Override
  public void initialize() {
    turret.setRotation(-0.2);
  }

  @Override
  public boolean isFinished() {
    return turret.getTurretAngle() <= 0;
  }

  @Override
  public void end(boolean interrupted) {
    turret.setRotation(0);
  }
}
