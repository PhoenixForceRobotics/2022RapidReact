package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.utility.Motor;

//import com.revrobotics.CANSparkMaxLowLevel.MotorType;
//import com.revrobotics.CANSparkMaxLowLevel;

public class Climber extends SubsystemBase {

    public Solenoid pistonRaiserLeft;
    public Solenoid pistonRaiserRight;
    public Solenoid pistonGearBreak;

    public Motor flimsyArm;
    // nicknamed Francis
    public Motor spoolLeft;
    // nicknamed Jose
    public Motor spoolRight;
    // nicknamed Alberta

    // Encoder
    RelativeEncoder spoolLeftEncoder;
    RelativeEncoder spoolRightEncoder;
    RelativeEncoder flimseyArmEncoder;

    public Climber() {
        // pistons
        pistonRaiserLeft = new Solenoid(PneumaticsModuleType.CTREPCM,
                Constants.PneumaticsMap.Climber.SOLENOID1);
        pistonRaiserRight = new Solenoid(PneumaticsModuleType.CTREPCM,
                Constants.PneumaticsMap.Climber.SOLENOID2);
        pistonGearBreak = new Solenoid(PneumaticsModuleType.CTREPCM,
                Constants.PneumaticsMap.Climber.SOLENOID3);

        // Motors, motor class is not set up.
        flimsyArm = new Motor(Constants.MotorMap.Climber.FLIMSEYARM, MotorType.kBrushed,
                Constants.MotorMap.Climber.FlIMSEYARM_REVERSED, 30);
        spoolLeft = new Motor(Constants.MotorMap.Climber.SPOOLLEFT, MotorType.kBrushed,
                Constants.MotorMap.Climber.SPOOLLEFT_REVERSED, 30);
        spoolRight = new Motor(Constants.MotorMap.Climber.SPOOLRIGHT, MotorType.kBrushed,
                Constants.MotorMap.Climber.SPOOLRIGHT_REVERSED, 30);

        // Encoders
        flimseyArmEncoder = flimsyArm.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
        spoolRightEncoder = spoolRight.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
        spoolLeftEncoder = spoolLeft.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
    }

    public void Levitate() {
        pistonRaiserLeft.set(true);
        pistonRaiserRight.set(true);
    }

    public void stopLevitate() {
        pistonRaiserLeft.set(false);
        pistonRaiserRight.set(false);
    }

    public void activatePistonBreak() {
        pistonGearBreak.set(true);
    }

    public void deactivatePistonBreak() {
        pistonGearBreak.set(false);
    }

    public void setFlimseyArm(double value) {
        flimsyArm.set(value);
    }

    public void setSpools(double value) {
        spoolRight.set(value);
        spoolLeft.set(value);
    }

    public void turnOffSpools(double value) {
        spoolRight.set(0);
        spoolLeft.set(0);
    }

    public void turnOffFlimseyArm(double value) {
        spoolRight.set(0);
        spoolLeft.set(0);
    }

    // Encoder Commands
    public double getPositionLeftEncoder() {
        return spoolLeftEncoder.getPosition();
    }

    public double getPositionRightEncoder() {
        return spoolRightEncoder.getPosition();
    }

    public double getPositionFlimseyEncoder() {
        return flimseyArmEncoder.getPosition();
    }

    public void resetFlimseyEncoder() {
        flimseyArmEncoder.setPosition(0.0);
    }

    public void resetSpoolLeftEncoder() {
        spoolLeftEncoder.setPosition(0.0);
    }

    public void resetSpoolRightEncoder() {
        spoolRightEncoder.setPosition(0.0);
    }

    // Might not use these get velocity but they are here just incase
    public double getVelocityFlimseyEncoder() {
        return flimseyArmEncoder.getVelocity();
    }

    public double getVelocitySpoolLeftEncoder() {
        return spoolLeftEncoder.getVelocity();
    }

    public double getVelocitySpoolRightEncoder() {
        return spoolRightEncoder.getVelocity();
    }
}