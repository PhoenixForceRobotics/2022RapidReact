package frc.robot.subsystems;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants.TurretConstants;
import frc.robot.utils.Falcon;
import frc.robot.utils.Motor;

public class Flywheel extends SubsystemBase {

  public Motor flywheelRotate; // Neo
  public Falcon flywheelLeft, flywheelRight; // Falcons
  public Motor flywheelHood; // Neo 550

  public RelativeEncoder fwRotateEncoder; // Neo
  public RelativeEncoder fwHoodEncoder; // Neo 550

  public boolean toggleFlyWheel;

  public Relay limelight;

  public Flywheel() {
    flywheelRotate =
        new Motor(
            TurretConstants.ROTATE_PORT, TurretConstants.ROTATE_REVERSED);
    flywheelLeft =
        new Falcon(TurretConstants.LEFT_FLYWHEEL_PORT, TurretConstants.LEFT_FLYWHEEL_REVERSED);
    flywheelRight =
        new Falcon(TurretConstants.RIGHT_FLYWHEEL_PORT, TurretConstants.RIGHT_FLYWHEEL_REVERSED);
    flywheelHood =
        new Motor(
            TurretConstants.HOOD_PORT, TurretConstants.HOOD_REVERSED);
    limelight = new Relay(TurretConstants.RELAY_PORT, Direction.kReverse);
    fwRotateEncoder = flywheelRotate.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
    fwHoodEncoder = flywheelHood.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);

    flywheelRotate.setIdleMode(IdleMode.kBrake);
    flywheelLeft.setCoast();
    flywheelRight.setCoast();
    flywheelHood.setIdleMode(IdleMode.kBrake);

    toggleFlyWheel = false;

    limelight.set(Value.kReverse);
    System.out.println("Limelight: " + limelight.get().toString());
  }

  public void setFlywheelRotate(double speed) {
    flywheelRotate.set(speed);
  }

  public double getFWRotateVel() {
    return fwRotateEncoder.getVelocity();
  }

  public void setFlywheel(double velocity) {
    flywheelLeft.setVelocity(velocity);
    flywheelRight.setVelocity(velocity);
  }

  public void setFlywheelPercent(double percent) {
    flywheelLeft.setPercentage(percent);
    flywheelRight.setPercentage(percent);
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
    return flywheelLeft.getVelocity();
  }

  public void resetFWEncoder() {
    flywheelLeft.setSelectedSensorPosition(0);
  }

  public double getFWRotateEncoderPosition() {
    return fwRotateEncoder.getPosition();
  }

  public void resetFWRotateEncoder() {
    fwRotateEncoder.setPosition(0);
  }

  public boolean getToggleFlyWheel() {
    return toggleFlyWheel;
  }

  public void setToggleFlyWheel(boolean value) {
    toggleFlyWheel = value;
  }
}
