package frc.robot.commands.flywheel;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.subsystems.Turret;

public class ToggleFlywheel extends InstantCommand {
  private Turret turret;

  public ToggleFlywheel(Turret turret) {
    this.turret = turret;
  }

  @Override
  public void initialize() {
    turret.toggleFlywheel();
  }
}
