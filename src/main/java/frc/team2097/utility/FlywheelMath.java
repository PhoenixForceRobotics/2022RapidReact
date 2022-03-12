package frc.team2097.utility;

import java.lang.Math;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class FlywheelMath {
    private static double theta, distance;
    static NetworkTable table = NetworkTableInstance.getDefault().getTable("PiVisionData");
    static NetworkTableEntry distanceEntry = table.getEntry("distance");
    static NetworkTableEntry thetaEntry = table.getEntry("pitch");

    public static double getTheta() {
        distance = distanceEntry.getDouble(-1) + 24;

        if (distance == 23) {
            return 50;
        } else if (distance <= Constants.SubsystemMath.FlywheelMath.ZONE1) {
            return getThetaZone1();
        } else if (distance <= Constants.SubsystemMath.FlywheelMath.ZONE2) {
            return getThetaZone2();
        } else {
            return getThetaZone3();
        }
    }

    // Math from the spreadsheet
    public static double getThetaZone1() {
        theta = -.0915 * Math.pow(distance, 2) + 6.71 * distance + 133;
        return theta;
    }

    public static double getThetaZone2() {
        theta = -.204 * Math.pow(10, -4)* Math.pow(distance, 2) - .0486 * distance + 88.7;
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
        } else if (distance <= Constants.SubsystemMath.FlywheelMath.ZONE1) {
            return Constants.SubsystemMath.FlywheelMath.VELOCITY_ZONE1;
        } else if (distance <= Constants.SubsystemMath.FlywheelMath.ZONE2) {
            return Constants.SubsystemMath.FlywheelMath.VELOCITY_ZONE2;
        } else {
            return Constants.SubsystemMath.FlywheelMath.VELOCITY_ZONE3;
        }

    }
}