package frc.robot.commands.turret;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;
import frc.robot.subsystems.Turret.RotationDirection;
import frc.robot.utils.Constants.TurretConstants;

public class TurretAutoAim extends CommandBase {

  private Turret turret;
  private double xCoordinate;

  private PIDController pid;
  private NetworkTable table;

  private NetworkTableEntry ACSX;
  private NetworkTableEntry hasTarget;

  private RotationDirection rotationDirection;

  public TurretAutoAim(Turret turret) {
    this.turret = turret;

    table = NetworkTableInstance.getDefault().getTable("PiVisionData");

    ACSX = table.getEntry("ACSX");
    hasTarget = table.getEntry("hasTarget");

    pid = new PIDController(0.15, 0, 0.00001);

    pid.setSetpoint(0);
    rotationDirection = RotationDirection.COUNTER_CLOCKWISE;
    addRequirements(turret);
  }

  @Override
  public void execute() {
    xCoordinate = ACSX.getDouble(0);

    if (hasTarget.getBoolean(false)) {
      double output = MathUtil.clamp(pid.calculate(-xCoordinate), -1, 1);

      System.out.println("Output: " + output);

      turret.setRotation(output);
    } else {
      turret.setRotation(0);
    }
  }

  public void scan() {

    System.out.println("Scanning");
    // Switch directions when at limit
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

  @Override
  public void end(boolean interrupted) {
    turret.setRotation(0);
  }
}
