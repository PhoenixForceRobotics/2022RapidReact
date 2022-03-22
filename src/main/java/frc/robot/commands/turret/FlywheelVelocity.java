package frc.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;
import frc.robot.utils.FlywheelMath;
import frc.robot.utils.OI;

public class FlywheelVelocity extends CommandBase {
  private Turret turret;
  private OI oi;

  public FlywheelVelocity(Turret turret, OI oi) {
    this.turret = turret;
    this.oi = oi;
  }

  @Override
  public void execute() {
    System.out.println("Running Flywheel");
    turret.setFlywheelPercent(1 * oi.driverController.getLeftTriggerAxis());
  }

  @Override
  public void end(boolean interrupted) {
    turret.setFlywheelPercent(0);
  }
}
