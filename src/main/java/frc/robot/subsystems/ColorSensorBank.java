package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants;

public class ColorSensorBank extends SubsystemBase {
    public enum ShuttleSlotStatus {
        EMPTY,
        RED,
        BLUE,
        UNKNOWN
    }
    
    //port definitions
    private I2C.Port onboardI2C = I2C.Port.kOnboard; //dedicated i2c port; TODO: does gyro already use it, and if so what do i do about it?
    private I2C.Port mxpI2C = I2C.Port.kMXP; //i2c using MXP; TODO: find out how hard MXP is to interface with (excluding dedicated off-the-shelf interfacing hardware because $$$ and also time)
    //sensor definitions
    private ColorSensorV3[] colorSensors = new ColorSensorV3[]{new ColorSensorV3(onboardI2C), new ColorSensorV3(mxpI2C)};
    //color matching
    private ColorMatch colorMatcher = new ColorMatch(); //essentially, you feed the ColorMatch object a library of colors and when used to match to sensor data it returns the closest fit
    //shuttle slots
    private ShuttleSlotStatus[] shuttleBallStatus; //status of each slot in the shuttle; left is 0 and right is 1
    private double[] previousMatchConfidence; //confidence of color detection for each slot in the shuttle; left is 0 and right is 1; values are either -1 (empty) or between 0 and 1

    //init
    public ColorSensorBank() {
        //add ball colors to color match library
        colorMatcher.addColorMatch(Constants.ColorSensorBankConstants.COLOR_CARGO_BLUE);
        colorMatcher.addColorMatch(Constants.ColorSensorBankConstants.COLOR_CARGO_RED);
        //setup ball status
        shuttleBallStatus = new ShuttleSlotStatus[2];
        //setup confidence
        previousMatchConfidence = new double[2];
        colorMatcher.setConfidenceThreshold(Constants.ColorSensorBankConstants.THRESHHOLD_CARGO_COLOR_CONFIDENCE);
        //populate with values
        
    }

    //update the object with current sensor values
    @Override
    public void periodic() {
        //there's 100% a cleaner solution to this but it just needs to work
        for (int i = 0; i >= colorSensors.length; i++) { //go through all sensors
            if (colorSensors[i].getProximity() <= Constants.ColorSensorBankConstants.THRESHHOLD_CARGO_PROXIMITY) {
                ColorMatchResult matchResult = colorMatcher.matchClosestColor(colorSensors[i].getColor());
                previousMatchConfidence[i] = matchResult.confidence; //log confidence
                //set status (java doesn't let you switch with colors :( ) 
                if (matchResult.color == Constants.ColorSensorBankConstants.COLOR_CARGO_BLUE) {
                    shuttleBallStatus[i] = ShuttleSlotStatus.BLUE;
                } else if (matchResult.color == Constants.ColorSensorBankConstants.COLOR_CARGO_RED) {
                    shuttleBallStatus[i] = ShuttleSlotStatus.RED;
                } else {
                    shuttleBallStatus[i] = ShuttleSlotStatus.UNKNOWN;
                }
            } else {
                //distance check failed, so it must be empty
                shuttleBallStatus[i] = ShuttleSlotStatus.EMPTY;
                previousMatchConfidence[i] = -1.0;
            }
        }
    }

    //getters

    public ColorSensorV3[] getSensors() {
        return colorSensors;
    }

    public ShuttleSlotStatus[] getShuttleStatus() {
        return shuttleBallStatus;
    }

    public double[] getPreviousMatchConfidence() {
        return previousMatchConfidence;
    }
}