package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants.TurretConstants;
import frc.robot.utils.Falcon;
import frc.robot.utils.Motor;

public class Turret extends SubsystemBase {

  public enum RotationDirection {
    CLOCKWISE,
    COUNTER_CLOCKWISE
  }

  private Motor rotation; // Neo
  private Falcon flywheelLeft, flywheelRight; // Falcons
  private Motor hood; // Neo 550

  private RelativeEncoder rotationEncoder; // Neo
  private RelativeEncoder hoodEncoder; // Neo 550

  private Relay limelight;

  private boolean atLeftLimit;
  private boolean atRightLimit;
  private boolean flywheelEnabled;

  private ShuffleboardTab tab;
  private NetworkTableEntry flywheelVelocity,
      turretAtRightLimit,
      turretAtLeftLimit,
      flywheelPosition;

  public Turret() {
    rotation = new Motor(TurretConstants.ROTATE_PORT, TurretConstants.ROTATE_REVERSED);
    hood = new Motor(TurretConstants.HOOD_PORT, TurretConstants.HOOD_REVERSED);

    flywheelLeft =
        new Falcon(TurretConstants.LEFT_FLYWHEEL_PORT, TurretConstants.LEFT_FLYWHEEL_REVERSED);
    flywheelRight =
        new Falcon(TurretConstants.RIGHT_FLYWHEEL_PORT, TurretConstants.RIGHT_FLYWHEEL_REVERSED);

    flywheelLeft.PIDconfig(TurretConstants.FLYWHEEL);

    rotationEncoder = rotation.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
    hoodEncoder = hood.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);

    rotationEncoder.setPositionConversionFactor(360 / 86.66666); // Makes the encoder output "degrees"

    hood.setIdleMode(IdleMode.kBrake);
    rotation.setIdleMode(IdleMode.kBrake);

    flywheelLeft.setCoast();
    flywheelRight.follow(flywheelLeft);
    flywheelRight.setInverted(InvertType.OpposeMaster);

    limelight = new Relay(TurretConstants.RELAY_PORT, Direction.kReverse);
    limelight.set(Value.kOn);

    tab = Shuffleboard.getTab("Turret Values");
    turretAtLeftLimit = tab.add("Turret At Left Limit", false).getEntry();
    turretAtRightLimit = tab.add("Turret At Right Limit", false).getEntry();
    flywheelVelocity = tab.add("Flywheel Velocity", 0).getEntry();
    flywheelPosition = tab.add("Turret Angle", 0).getEntry();
  }

  @Override
  public void periodic() {
    atLeftLimit = getTurretAngle() < TurretConstants.MAX_ANGLE_LEFT;
    atRightLimit = getTurretAngle() > TurretConstants.MAX_ANGLE_RIGHT;

    if (atLeftLimit) {
      turretAtLeftLimit.setBoolean(true);
    } else if (atRightLimit) {
      turretAtRightLimit.setBoolean(true);
    } else {
      turretAtLeftLimit.setBoolean(false);
      turretAtRightLimit.setBoolean(false);
    }

    flywheelVelocity.setDouble(getFlywheelVelocity());
    flywheelPosition.setDouble(getTurretRotations());
  }

  public void setRotation(double speedPercentage) {
    RotationDirection direction =
        speedPercentage > 0 ? RotationDirection.CLOCKWISE : RotationDirection.COUNTER_CLOCKWISE;

    if (direction == RotationDirection.CLOCKWISE && atRightLimit) {
      rotation.set(0);
    } else if (direction == RotationDirection.COUNTER_CLOCKWISE && atLeftLimit) {
      rotation.set(0);
    } else {
      rotation.set(
          MathUtil.clamp(speedPercentage, -TurretConstants.MAX_SPEED, TurretConstants.MAX_SPEED));
    }
  }

  public void setRotationPosition(double angle) {
    rotationEncoder.setPosition(angle);
  }

  public double getTurretAngle() {
    return rotationEncoder.getPosition();
  }

  public void setFlywheelPercent(double percentageSpeed) {
    flywheelLeft.setPercentage(percentageSpeed);
  }

  public void setFlywheelVelocity(double velocity) {
    flywheelLeft.setVelocity(velocity);
  }

  public void setFlywheelVoltage(double outputVoltage) {
    flywheelLeft.setVoltage(outputVoltage);
  }

  public double getFlywheelPosition() {
    return flywheelLeft.getPosition();
  }

  public double getFlywheelVelocity() {
    return flywheelLeft.getVelocity();
  } // returns RPM @ the motor

  public void setHood(double speed) {
    hood.set(speed);
  }

  public void setHoodBrake() {
    hood.setIdleMode(IdleMode.kBrake);
  }

  public void setHoodCoast() {
    hood.setIdleMode(IdleMode.kCoast);
  }

  public double getHoodPosition() {
    return hoodEncoder.getPosition();
  }

  public void resetHoodEncoder() {
    hoodEncoder.setPosition(0);
  }

  public void resetFlywheelEncoder() {
    flywheelLeft.setSelectedSensorPosition(0);
  }

  public double getTurretRotations() {
    return rotationEncoder.getPosition();
  }

  public void resetTurret() {
    rotationEncoder.setPosition(0);
  }

  public RelativeEncoder getHoodEncoder() {
    return hoodEncoder;
  }

  public boolean isAtLeftLimit() {
    return atLeftLimit;
  }

  public boolean isAtRightLimit() {
    return atRightLimit;
  }

  public void setFlywheelEnabled(boolean flywheelEnabled) {
    this.flywheelEnabled = flywheelEnabled;
  }

  public boolean isFlywheelEnabled() {
    return flywheelEnabled;
  }

  public boolean toggleFlywheel() {
    flywheelEnabled = !flywheelEnabled; // Toggles a boolean
    return flywheelEnabled;
  }
}
