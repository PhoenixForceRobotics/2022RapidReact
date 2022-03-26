package frc.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;

public class ResetHoodStart extends CommandBase {
  private Turret turret;

  public ResetHoodStart(Turret turret) {
    this.turret = turret;
  }

  @Override
  public void initialize() {
    turret.setHoodCoast();
  }

  @Override
  public void execute() {
    turret.setHood(-.05);
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
