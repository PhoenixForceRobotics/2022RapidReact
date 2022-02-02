package frc.robot.utility;

import java.lang.Math;

import frc.robot.Constants;

public class FlywheelMath {
    private double theta, distance;

    public double getTheta() {
        if(distance <= Constants.SubsystemMath.FlywheelMath.ZONE1) {
            return getThetaZone1();
        } else if (distance <= Constants.SubsystemMath.FlywheelMath.ZONE2) {
            return getThetaZone2();
        } else {
            return getThetaZone3();
        }
    }

    // Math from the spreadsheet
    public double getThetaZone1() {
        theta = -.679 * Math.pow(distance, 2) - 1.06 * distance + 88.4;
        return theta;
    }

    public double getThetaZone2() {
        theta = -.207 * Math.pow(distance, 2) - .757 * distance + 88.2;
        return theta;
    }

    public double getThetaZone3() {
        theta = -.088 * Math.pow(distance, 2) - 0.67 * distance + 88.4;
        return theta;
    }
    
}