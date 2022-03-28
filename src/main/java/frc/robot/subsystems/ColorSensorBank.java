package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants;
import frc.robot.utils.Constants.ColorSensorBankConstants.ShuttleSlotStatus;

public class ColorSensorBank extends SubsystemBase {
    //port definitions
    private I2C.Port onboardI2C = I2C.Port.kOnboard; //dedicated i2c port; TODO: does gyro already use it, and if so what do i do about it?
    private I2C.Port mxpI2C = I2C.Port.kMXP; //i2c using MXP; TODO: find out how hard MXP is to interface with (excluding dedicated off-the-shelf interfacing hardware because $$$ and also time)
    //sensor definitions
    private ColorSensorV3 colorSensorLeft = new ColorSensorV3(onboardI2C);
    private ColorSensorV3 colorSensorRight = new ColorSensorV3(mxpI2C); //My eXpansion Port connector on rio
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
        //left slot
        if (colorSensorLeft.getProximity() <= Constants.ColorSensorBankConstants.THRESHHOLD_CARGO_PROXIMITY) {
            ColorMatchResult matchResult = colorMatcher.matchClosestColor(colorSensorLeft.getColor());
            previousMatchConfidence[0] = matchResult.confidence;
            if (matchResult.color == Constants.ColorSensorBankConstants.COLOR_CARGO_BLUE) { //java doesn't let you switch with colors :(
                shuttleBallStatus[0] = ShuttleSlotStatus.BLUE;
            } else if (matchResult.color == Constants.ColorSensorBankConstants.COLOR_CARGO_RED) {
                shuttleBallStatus[0] = ShuttleSlotStatus.RED;
            } else {
                shuttleBallStatus[0] = ShuttleSlotStatus.UNKNOWN;
            }
        } else {
            shuttleBallStatus[0] = ShuttleSlotStatus.EMPTY;
            previousMatchConfidence[0] = -1.0;
        }
        //right slot; copy and pasted so probably deserves more thorough vetting
        if (colorSensorRight.getProximity() <= Constants.ColorSensorBankConstants.THRESHHOLD_CARGO_PROXIMITY) {
            ColorMatchResult matchResult = colorMatcher.matchClosestColor(colorSensorRight.getColor());
            previousMatchConfidence[1] = matchResult.confidence;
            if (matchResult.color == Constants.ColorSensorBankConstants.COLOR_CARGO_BLUE) { //java STILL doesn't let you switch with colors :(
                shuttleBallStatus[1] = ShuttleSlotStatus.BLUE;
            } else if (matchResult.color == Constants.ColorSensorBankConstants.COLOR_CARGO_RED) {
                shuttleBallStatus[1] = ShuttleSlotStatus.RED;
            } else {
                shuttleBallStatus[1] = ShuttleSlotStatus.UNKNOWN;
            }
        } else {
            shuttleBallStatus[1] = ShuttleSlotStatus.EMPTY;
            previousMatchConfidence[1] = -1.0;
        }
    }

    //getters

    public ColorSensorV3 getLeftSensor() {
        return colorSensorLeft;
    }

    public ColorSensorV3 getRightSensor() {
        return colorSensorRight;
    }

    public ShuttleSlotStatus[] getShuttleStatus() {
        return shuttleBallStatus;
    }

    public double[] getPreviousMatchConfidence() {
        return previousMatchConfidence;
    }
}