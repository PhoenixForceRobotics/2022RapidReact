package frc.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;
import frc.robot.subsystems.Turret.RotationDirection;
import frc.robot.utils.Constants.TurretConstants;

public class TurretScan extends CommandBase {
  private Turret turret;
  private RotationDirection rotationDirection;

  public TurretScan(Turret turret) {
    this.turret = turret;
    addRequirements(turret);
  }

  @Override
  public void execute() {
    scan();
  }

  @Override
  public void initialize() {
    rotationDirection = RotationDirection.CLOCKWISE;
  }

  @Override
  public void end(boolean interrupted) {
    turret.setRotation(0);
  }

  private void scan() {
    System.out.println("Scanning");
    if (turret.isAtLeftLimit()) {
      rotationDirection = RotationDirection.CLOCKWISE;
    } else if (turret.isAtRightLimit()) {
      rotationDirection = RotationDirection.COUNTER_CLOCKWISE;
    }

    if (rotationDirection == RotationDirection.CLOCKWISE) {
      turret.setRotation(TurretConstants.ROTATE_SPEED);
    } else if (rotationDirection == RotationDirection.COUNTER_CLOCKWISE) {
      turret.setRotation(-TurretConstants.ROTATE_SPEED);
    }
  }
}
