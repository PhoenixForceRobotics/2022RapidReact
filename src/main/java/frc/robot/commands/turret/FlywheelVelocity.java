package frc.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;

public class FlywheelVelocity extends CommandBase {
  private Turret turret;
  private double speed;

  public FlywheelVelocity(Turret turret) {
    this.turret = turret;
  }

  @Override
  public void initialize() {
    speed = 0;
  }

  @Override
  public void execute() {
    speed = speed < 0.70 ? speed + 0.05 : 0.70;
    turret.setFlywheelPercent(
        // pid.calculate(turret.getFlywheelVelocity()
        // + feedforward.calculate(2500)));
        speed);
     // Currently just percentage from trigger
  }

  @Override
  public void end(boolean interrupted) {
    turret.setFlywheelPercent(0);
  }
}
