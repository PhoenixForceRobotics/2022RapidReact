package frc.robot.subsystems;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.Constants;
import frc.robot.util.Motor;

public class ClimberMotors extends SubsystemBase {

  boolean activateNextSequence = false;

  // DoubleSolenoid pistonRaiserLeft;
  // DoubleSolenoid pistonRaiserRight;
  // DoubleSolenoid pistonGearBreak;

  // DoubleSolenoid.Value isPiston;

  // Motors
  Motor rightClimbingArm;
  Motor leftClimbingArm;

  // Timer delay;

  // Encoder
  RelativeEncoder rightClimbingArmEncoder;

  public ClimberMotors() {

    // Motors
    rightClimbingArm = new Motor(
        Constants.MotorMap.Climber.RIGHT_CLIMBING_ARM,
        MotorType.kBrushless,
        Constants.MotorMap.Climber.RIGHT_CLIMBING_ARM_REVERSED,
        40);

    leftClimbingArm = new Motor(
        Constants.MotorMap.Climber.LEFT_CLIMBING_ARM,
        MotorType.kBrushless,
        Constants.MotorMap.Climber.LEFT_CLIMBING_ARM_REVERSED,
        40);

    // Encoders
    rightClimbingArmEncoder = rightClimbingArm.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);

    // delay = new Timer();
  }

  // Flimsey ClimbingArm Commands
  public void setClimberArmMotorSpeed(double speed) {
    rightClimbingArm.set(speed);
    leftClimbingArm.set(speed);
  }

  public void climberArm_coast() {
    rightClimbingArm.setIdleMode(IdleMode.kCoast);
    leftClimbingArm.setIdleMode(IdleMode.kCoast);
  }

  public void climberArm_break() {
    rightClimbingArm.setIdleMode(IdleMode.kBrake);
    leftClimbingArm.setIdleMode(IdleMode.kBrake);
  }

  // Encoders
  public void setRightClimberArmEncoder(double position) {
    rightClimbingArmEncoder.setPosition(position);
  }

  public double getRightClimberArmPosition() {
    return rightClimbingArmEncoder.getPosition();
  }

  // // Activate next sequence
  public boolean getActivateNextSequence() {
    return activateNextSequence;
  }

  public void setActivateNextSequence(boolean value) {
    activateNextSequence = value;
  }
}
