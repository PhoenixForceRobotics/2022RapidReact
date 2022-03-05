package frc.robot.subsystems;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.Constants;
import frc.robot.util.Motor;

public class Climber extends SubsystemBase {

  boolean levitateStatus;
  boolean pistonBreakStatus;

  boolean activateNextSequence = false;

  Solenoid pistonRaiserLeft;
  Solenoid pistonRaiserRight;
  Solenoid pistonGearBreak;

  // Motors
  Motor flimseyArm;
  // nicknamed Francis

  // Motor spoolLeft;
  // nicknamed Jose
  // Motor spoolRight;
  // nicknamed Alberta
  // Jose and Alberta used to live happily then they were murdered by a redesign
  // from Lars

  Timer delay;

  // Encoder
  RelativeEncoder flimseyArmEncoder;

  public Climber() {

    // Motors
    flimseyArm =
        new Motor(
            Constants.MotorMap.Climber.FLIMSEYARM,
            MotorType.kBrushless,
            Constants.MotorMap.Climber.FlimseyArm_Reversed,
            40);

    // Solenoids
    pistonRaiserLeft =
        new Solenoid(PneumaticsModuleType.CTREPCM, Constants.PneumaticsMap.Climber.SOLENOID1);
    pistonRaiserRight =
        new Solenoid(PneumaticsModuleType.CTREPCM, Constants.PneumaticsMap.Climber.SOLENOID2);

    // Encoders
    flimseyArmEncoder = flimseyArm.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
  }

  // Solenoid commands
  public void Levitate() {
    pistonRaiserLeft.set(true);
    pistonRaiserRight.set(true);
    levitateStatus = true;
  }

  public void stopLevitate() {
    pistonRaiserLeft.set(false);
    pistonRaiserRight.set(false);
    levitateStatus = false;
  }

  public boolean getLevitateStatus() {
    return levitateStatus;
  }

  public void setLevitateStatus(boolean value) {
    levitateStatus = value;
  }

  // Flimsey Arm Commands
  public void setFlimseyMotorSpeed(double speed) {
    flimseyArm.set(speed);
  }

  public void flimseyArm_coast() {
    flimseyArm.setIdleMode(IdleMode.kCoast);
  }

  public void flimseyArm_break() {
    flimseyArm.setIdleMode(IdleMode.kBrake);
  }

  // Encoders
  public void setFlimseyArmEncoder(double position) {
    flimseyArmEncoder.setPosition(position);
  }

  public double getFlimseyArmPosition() {
    return flimseyArmEncoder.getPosition();
  }

  // Delay Commands
  public void startTimer() {
    delay.start();
  }

  public void stopTimer() {
    delay.stop();
  }

  public void resetTimer() {
    delay.reset();
  }

  public boolean timeElapsed(double seconds) {
    return delay.hasElapsed(seconds);
  }

  // Activate next sequence
  public boolean activateNextSequence() {
    return levitateStatus;
  }

  public void setActivateNextSequence(boolean value) {
    levitateStatus = value;
  }
}
