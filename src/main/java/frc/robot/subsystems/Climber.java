package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.Constants;

public class Climber extends SubsystemBase {

  boolean levitateStatus = false;
  boolean pistonBreakStatus;

  boolean activateNextSequence = false;

  DoubleSolenoid pistonRaiser;

  DoubleSolenoid.Value isPiston;

  Timer delay;

  public Climber() {

    // Solenoids
    pistonRaiser =
        new DoubleSolenoid(
            PneumaticsModuleType.CTREPCM,
            Constants.PneumaticsMap.Climber.SOLENOID_LEFT_FORWARD,
            Constants.PneumaticsMap.Climber.SOLENOID_LEFT_BACKWARD);

    delay = new Timer();
  }

  // Solenoid commands
  public void pistonForward() {
    pistonRaiser.set(Value.kForward);
  }

  public void pistonReverse() {
    pistonRaiser.set(Value.kReverse);
  }

  public void toggle() {
    isPiston = pistonRaiser.get();

    if (isPiston == Value.kForward) {
      pistonRaiser.set(Value.kReverse);
    } else {
      pistonRaiser.set(Value.kForward);
    }
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
