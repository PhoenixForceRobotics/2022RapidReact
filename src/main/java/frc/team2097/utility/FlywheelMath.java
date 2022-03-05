package frc.team2097.utility;

import java.lang.Math;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.team2097.utility.Constants;

public class FlywheelMath {
    private static double theta, distance;
    static NetworkTable table = NetworkTableInstance.getDefault().getTable("PiVisionData");
    static NetworkTableEntry distanceEntry = table.getEntry("distance");
    static NetworkTableEntry thetaEntry = table.getEntry("pitch");

    public static double getTheta() {
        distance = distanceEntry.getDouble(-1);
        if(distance == -1) {
            return 50;
        } else if(distance <= Constants.SubsystemMath.FlywheelMath.ZONE1) {
            return getThetaZone1();
        } else if (distance <= Constants.SubsystemMath.FlywheelMath.ZONE2) {
            return getThetaZone2();
        } else {
            return getThetaZone3();
        }
    }

    // Math from the spreadsheet
    public static double getThetaZone1() {
        theta = -.679 * Math.pow(distance, 2) - 1.06 * distance + 88.4;
        return theta;
    }

    public static double getThetaZone2() {
        theta = -.207 * Math.pow(distance, 2) - .757 * distance + 88.2;
        return theta;
    }

    public static double getThetaZone3() {
        theta = -.088 * Math.pow(distance, 2) - 0.67 * distance + 88.4;
        return theta;
    }
    
}