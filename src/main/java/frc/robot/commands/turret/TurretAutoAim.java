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

  private RotationDirection rotationDirection;

  public TurretAutoAim(Turret turret) {
    this.turret = turret;

    table = NetworkTableInstance.getDefault().getTable("PiVisionData");

    ACSX = table.getEntry("ACSX");

    pid = new PIDController(1, 0, 0);
    pid.setSetpoint(0);
  }

  @Override
  public void initialize() {
    xCoordinate = ACSX.getDouble(5);
  }

  @Override
  public void execute() {
    xCoordinate = ACSX.getDouble(5);

    if (xCoordinate != 5) {
      double output = MathUtil.clamp(pid.calculate(-xCoordinate), -0.5, 0.5);

      turret.setRotation(output);
      System.out.println("targeting! Output: " + output);
    } else {
      scan();
    }
  }

  public void scan() {

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
}
