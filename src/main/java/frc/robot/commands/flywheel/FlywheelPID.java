package frc.robot.commands.flywheel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;

public class FlywheelPID extends CommandBase {
  private Turret turret;

  public FlywheelPID(Turret turret) {}

  @Override
  public void initialize() {
    turret.resetFlywheelEncoder();
  }

  @Override
  public void execute() {
    turret.setFlywheelVelocity(3500);
  }

  @Override
  public void end(boolean interrupted) {
    turret.setFlywheelPercent(0);
  }
}
