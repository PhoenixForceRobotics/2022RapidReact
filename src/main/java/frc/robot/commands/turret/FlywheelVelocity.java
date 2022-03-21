package frc.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;
import frc.robot.utils.FlywheelMath;

public class FlywheelVelocity extends CommandBase {
  private Turret turret;

  public FlywheelVelocity(Turret turret) {}

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    turret.setFlywheelVelocity(FlywheelMath.getVelocity());
  }

  @Override
  public void end(boolean interrupted) {
    turret.setFlywheelPercent(0);
  }
}
