package frc.robot.utils;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.utils.Constants.TurretConstants;

public class TurretMath {
  private static double theta, distance;
  static NetworkTable table = NetworkTableInstance.getDefault().getTable("PiVisionData");
  static NetworkTableEntry distanceEntry = table.getEntry("distance");
  static NetworkTableEntry thetaEntry = table.getEntry("pitch");

  public static double getTheta() {
    distance = NetworkTableManager.getDistanceEntry() + 24;
    System.out.println("Distance" + distance);
    if (distance == 24) {
      return 75;
    } else {
      theta = -0.0306 * distance + (-7.99 * Math.pow(10, -5) * Math.pow(distance, 2) + 88.7);
      return theta;
    }
    // } else if (distance <= TurretConstants.ZONE1) {
    //   return getThetaZone1();
    // } else if (distance <= TurretConstants.ZONE2) {
    //   return getThetaZone2();
    // } else {
    //   return getThetaZone3();
    // }
  }

  // Math from the spreadsheet
  public static double getThetaZone1() {
    theta = -.0915 * Math.pow(distance, 2) + 6.71 * distance + 133;
    return theta;
  }

  public static double getThetaZone2() {
    theta = -.204 * Math.pow(10, -4) * Math.pow(distance, 2) - .0486 * distance + 88.7;
    return theta;
  }

  public static double getThetaZone3() {
    theta = -1.11 * Math.pow(10, -4) * Math.pow(distance, 2) - 0.036 * distance + 88.7;
    return theta;
  }

  public static double getVelocity() {
    distance = distanceEntry.getDouble(-1);
    if (distance == -1) {
      return 0;
    } else if (distance <= TurretConstants.ZONE1) {
      return TurretConstants.VELOCITY_ZONE1;
    } else if (distance <= TurretConstants.ZONE2) {
      return TurretConstants.VELOCITY_ZONE2;
    } else {
      return TurretConstants.VELOCITY_ZONE3;
    }
  }
}
