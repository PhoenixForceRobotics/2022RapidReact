package frc.robot.commands.turn;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Flywheel;
import frc.robot.utils.Constants.TurretConstants;
import frc.robot.utils.NetworkTableManager;

public class FlywheelTurn extends CommandBase {

  private Flywheel flywheel;
  private double buffer;
  private double xCoordinate;
  private int reverse;
  private boolean turnAround, outOfBounds;

  private double maxRotate;

  private NetworkTable table;
  private NetworkTableEntry ACSX;

  public FlywheelTurn(Flywheel flywheel) {
    this.flywheel = flywheel;
    turnAround = false;
    reverse = 1;

    table = NetworkTableInstance.getDefault().getTable("PiVisionData");

    ACSX = table.getEntry("ACSX");
  }

  @Override
  public void initialize() {
    buffer = TurretConstants.ROTATE_BUFFER;
    maxRotate = (1.0 / 3.5) * 65;
    flywheel.resetFWRotateEncoder();
    outOfBounds = false;
  }

  @Override
  public void execute() {
    xCoordinate = ACSX.getDouble(5);
    if (!(NetworkTableManager.getHasTarget()) || outOfBounds) {
      if (TurretConstants.ROTATE_SPEED * Math.abs(1 / flywheel.getFWRotateEncoderPosition()) < .1) {
        flywheel.setFlywheelRotate(.1 * reverse);
      } else if (Math.abs(flywheel.getFWRotateEncoderPosition()) > 2) {
        flywheel.setFlywheelRotate(
            TurretConstants.ROTATE_SPEED
                * reverse
                * Math.abs(1 / flywheel.getFWRotateEncoderPosition()));
      } else {
        flywheel.setFlywheelRotate(TurretConstants.ROTATE_SPEED * reverse * .5);
      }
    } else if (xCoordinate >= buffer || xCoordinate <= -1 * buffer) {
      flywheel.setFlywheelRotate(TurretConstants.ROTATE_SPEED * xCoordinate * .75);
    } else {
      flywheel.setFlywheelRotate(0);
    }

    System.out.println("Speed:" + flywheel.getFWRotateVel());
    System.out.println("rotations:" + flywheel.getFWRotateEncoderPosition());
    System.out.println("x-coordinate:" + xCoordinate);

    outOfBounds = (xCoordinate > maxRotate || xCoordinate < -maxRotate);

    if (turnAround) {
      if (flywheel.getFWRotateEncoderPosition() < -maxRotate) {
        turnAround = false;
        reverse = 1;
      }
    } else {
      if (flywheel.getFWRotateEncoderPosition() > maxRotate) {
        turnAround = true;
        reverse = -1;
      }
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
