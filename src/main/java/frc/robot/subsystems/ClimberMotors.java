package frc.robot.subsystems;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;
// import edu.wpi.first.wpilibj.PneumaticsModuleType;
// import edu.wpi.first.wpilibj.DoubleSolenoid;
// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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

    // // Solenoids
    // pistonRaiserLeft = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,
    // Constants.PneumaticsMap.Climber.SOLENOID1Forward,
    // Constants.PneumaticsMap.Climber.SOLENOID1Backward);
    // pistonRaiserRight = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,
    // Constants.PneumaticsMap.Climber.SOLENOID2Forward,
    // Constants.PneumaticsMap.Climber.SOLENOID2Backward);

    // Encoders
    rightClimbingArmEncoder = rightClimbingArm.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);

    // delay = new Timer();
  }

  // // Solenoid commands
  // public void Levitate() {
  // pistonRaiserLeft.set(Value.kForward);
  // pistonRaiserRight.set(Value.kForward);
  // }

  // public void stopLevitate() {
  // pistonRaiserLeft.set(Value.kReverse);
  // pistonRaiserRight.set(Value.kReverse);
  // }

  // public void toggle() {
  // isPiston = pistonRaiserLeft.get();
  // System.out.println("I pressed:" + isPiston);

  // if (isPiston == Value.kForward) {
  // pistonRaiserLeft.set(Value.kReverse);
  // } else {
  // pistonRaiserLeft.set(Value.kForward);
  // }
  // }

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

  // // Delay Commands
  // public void startTimer() {
  // delay.start();
  // }

  // public void stopTimer() {
  // delay.stop();
  // }

  // public void resetTimer() {
  // delay.reset();
  // }

  // public boolean timeElapsed(double seconds) {
  // return delay.hasElapsed(seconds);
  // }

  // // Activate next sequence
  public boolean getActivateNextSequence() {
    return activateNextSequence;
  }

  public void setActivateNextSequence(boolean value) {
    activateNextSequence = value;
  }
}
