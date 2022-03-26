package frc.robot.commands.turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;
import frc.robot.utils.Constants.TurretConstants;
import frc.robot.utils.NetworkTableManager;
import frc.robot.utils.TurretMath;

public class HoodAngle extends CommandBase {
  NetworkTableManager networkTableManager;

  private double pitchAngle;
  private Turret turret;
  private double maxDegree, minDegree;
  private double degreeRange;
  private double buffer;
  private double hoodRotations, relativeRotation;
  private double error;

  public HoodAngle(Turret turret) {
    this.turret = turret;
    // shoot angle
    maxDegree = 85;
    minDegree = 55;
    degreeRange = maxDegree - minDegree;
    // motor rotations to big roation
    // 40* big robation/motor roations = how much it spins every small motor spin
    buffer = .25;
    hoodRotations = 0;
    relativeRotation = 360 * .024 * hoodRotations;
    error = 0;
  }

  @Override
  public void initialize() {
    pitchAngle = TurretMath.getTheta();
  }

  @Override
  public void execute() {
    pitchAngle = TurretMath.getTheta();
    System.out.println(pitchAngle);
    // pitchAngle = 60; // testing angle, the line above is the real one when the hood
    // to ball angle calculuations are ready
    hoodRotations = turret.getHoodPosition();
    error = (maxDegree - relativeRotation) - pitchAngle;
    relativeRotation = 360 * .02517 * hoodRotations;
    System.out.println("Current degrree " + (maxDegree - relativeRotation));
    if (maxDegree - relativeRotation >= pitchAngle - buffer
        && maxDegree - relativeRotation <= pitchAngle + buffer) {
      turret.setHood(0);
    } else if (pitchAngle > maxDegree) {
      pitchAngle = maxDegree;
    } else if (pitchAngle < minDegree) {
      pitchAngle = minDegree;
    } else if (maxDegree - relativeRotation < minDegree) {
      turret.setHood(-.05);
    } else if (maxDegree - relativeRotation > maxDegree) {
      turret.setHood(0);
    } else {
      // System.out.println("Speed:" + TurretConstants.HOOD_SPEED * error / (degreeRange * 2 /
      // 3.5));
      turret.setHood(TurretConstants.HOOD_SPEED * error / (degreeRange * 2 / 3));
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
