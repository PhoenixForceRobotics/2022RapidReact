package frc.robot.commands.turret;

import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;

public class ResetHood extends CommandBase {
  private Turret turret;
  private RelativeEncoder hoodEncoder;

  public ResetHood(Turret turret) {
    this.turret = turret;
  }

  @Override
  public void initialize() {
    turret.setHoodCoast();
    hoodEncoder = turret.getHoodEncoder();
  }

  @Override
  public boolean isFinished() {
    return Math.abs(hoodEncoder.getVelocity()) <= .2;
  }

  @Override
  public void end(boolean interrupted) {
    hoodEncoder.setPosition(85);
    turret.setHoodBrake();
  }
}
