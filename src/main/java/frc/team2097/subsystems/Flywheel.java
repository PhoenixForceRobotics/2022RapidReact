package frc.team2097.subsystems;

import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team2097.utility.Constants;
import frc.team2097.utility.Falcon;
import frc.team2097.utility.Motor;

public class Flywheel extends SubsystemBase{

    public Motor flywheelRotate; // Neo
    public Falcon flywheelLeft, flywheelRight; // Falcons
    public Motor flywheelHood; // Neo 550

    public RelativeEncoder fwRotateEncoder; // Neo
    public RelativeEncoder fwLeftEncoder, fwRightEncoder; // Falcons
    public RelativeEncoder fwHoodEncoder; // Neo 550

    public Flywheel() {
        flywheelRotate = new Motor(Constants.MotorMap.Flywheel.ROTATE, MotorType.kBrushless, Constants.MotorMap.Flywheel.ROTATE_REVERSED, 30);
        flywheelLeft = new Falcon(Constants.MotorMap.Flywheel.SHOOT_LEFT, Constants.MotorMap.Flywheel.SHOOT_LEFT_REVERSED);
        flywheelRight = new Falcon(Constants.MotorMap.Flywheel.SHOOT_RIGHT, Constants.MotorMap.Flywheel.SHOOT_RIGHT_REVERSED);
        flywheelHood = new Motor(Constants.MotorMap.Flywheel.HOOD, MotorType.kBrushless, Constants.MotorMap.Flywheel.HOOD_REVERSED, 30);

        fwRotateEncoder = flywheelRotate.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
        fwLeftEncoder = flywheelLeft.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
        fwRightEncoder = flywheelRight.getEncoder();
        fwHoodEncoder = flywheelHood.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);

        flywheelRotate.setIdleMode(IdleMode.kBrake);
        flywheelLeft.setIdleMode(IdleMode.kCoast);
        flywheelRight.setIdleMode(IdleMode.kCoast);
        flywheelHood.setIdleMode(IdleMode.kBrake);
    }
    
    public void setFlywheelRotate(double speed) {
        flywheelRotate.set(speed);
    }

    public void setFlywheel(double speed) {
        flywheelLeft.set(speed);
        flywheelRight.set(speed);
    }

    public void setFlywheelHood(double speed) {
        flywheelHood.set(speed);
    }

    public double getFWHoodPos() {
        return fwHoodEncoder.getPosition();
    }

    public void setFlywheelHoodBrake() {
        flywheelHood.setIdleMode(IdleMode.kBrake);
    }

    public void setFlywheelHoodCoast() {
        flywheelHood.setIdleMode(IdleMode.kCoast);
    }
    
    public void resetFWHoodEncoder() {
        fwHoodEncoder.setPosition(0);
    }

    public double getFWLeftEncoderVel() {
        return fwLeftEncoder.getVelocity();
    }

    public void resetFWEncoder() {
        fwLeftEncoder.setPosition(0);
    }

    public double getFWRotateEncoderPosition() {
        return fwRotateEncoder.getPosition();
    }

    public void resetFWRotateEncoder() {
        fwRotateEncoder.setPosition(0);
    }
}