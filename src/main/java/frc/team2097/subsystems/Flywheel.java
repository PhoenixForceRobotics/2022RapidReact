package frc.robot.subsystems;

import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.utility.Motor;

public class Flywheel extends SubsystemBase{

    public Motor flywheelRotate; // Neo
    public Motor flywheelLeft, flywheelRight; // Falcons
    public Motor flywheelHood; // Neo 550

    public RelativeEncoder fwRotateEncoder; // Neo
    public RelativeEncoder fwLeftEncoder/*, fwRightEncoder*/; // Falcons
    public RelativeEncoder fwHoodEncoder; // Neo 550

    public Flywheel() {
  //      flywheelRotate = new Motor(Constants.MotorMap.Flywheel.ROTATE, MotorType.kBrushless, Constants.MotorMap.Flywheel.ROTATE_REVERSED, 30);
          flywheelLeft = new Motor(Constants.MotorMap.Flywheel.SHOOT_LEFT, MotorType.kBrushless, Constants.MotorMap.Flywheel.SHOOT_LEFT_REVERSED, 40);
  //      flywheelRight = new Motor(Constants.MotorMap.Flywheel.SHOOT_RIGHT, MotorType.kBrushless, Constants.MotorMap.Flywheel.SHOOT_RIGHT_REVERSED, 40);
  //      flywheelHood = new Motor(Constants.MotorMap.Flywheel.HOOD, MotorType.kBrushless, Constants.MotorMap.Flywheel.HOOD_REVERSED, 30);

 //       fwRotateEncoder = flywheelRotate.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
          fwLeftEncoder = flywheelLeft.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
  //      fwRightEncoder = flywheelRight.getEncoder();
  //      fwHoodEncoder = flywheelHood.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);

 //       flywheelRotate.setIdleMode(IdleMode.kBrake);
          flywheelLeft.setIdleMode(IdleMode.kCoast);
 //       flywheelRight.setIdleMode(IdleMode.kCoast);
 //       flywheelHood.setIdleMode(IdleMode.kBrake);
    }
    
    // public void setFlywheelRotate(double speed) {
    //     flywheelRotate.set(speed);
    // }

    public void setFlywheel(double speed) {
        flywheelLeft.set(speed);
    //    flywheelRight.set(speed);
    }

    // public void setFlywheelHood(double speed) {
    //     flywheelHood.set(speed);
    // // }
    
    public double getFWLeftEncoderVel() {
        return fwLeftEncoder.getVelocity();
    }

    public void resetFWEncoder() {
        fwLeftEncoder.setPosition(0);
    }
}