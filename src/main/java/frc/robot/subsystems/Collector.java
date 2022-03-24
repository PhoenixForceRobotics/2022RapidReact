package frc.robot.subsystems;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants;
import frc.robot.utils.Motor;

public class Collector extends SubsystemBase {

  // variable decleration

  private Motor collectorMotor;
  private RelativeEncoder collectorEncoder;

  private DoubleSolenoid collectorPiston;
  private Timer delay;

  public Collector() {

    // motor setting
    collectorMotor =
        new Motor(
            Constants.FeederIntakeConstants.SHUTTLE,
            Constants.FeederIntakeConstants.SHUTTLE_REVERSE);

    collectorEncoder = collectorMotor.getEncoder();

    collectorPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);

    delay = new Timer();
  }

  // rotator motor 2 setter/getters
  public void setCollectorPosition(double speed) {
    collectorEncoder.setPosition(speed);
  }

  public double getCollectorPosition() {
    return collectorEncoder.getPosition();
  }

  public void setCollectorMotor(double speed) {
    collectorMotor.set(speed);
  }

  public void collectorMotorCoast() {
    collectorMotor.setIdleMode(IdleMode.kCoast);
  }

  public void collectorMotorBrake() {
    collectorMotor.setIdleMode(IdleMode.kBrake);
  }

  // shuttleExtender functions
  public void setPiston(Value value) {
    collectorPiston.set(value);
  }

  public void setShuttleExtenderForward() {
    setPiston(Value.kForward);
  }

  public void setShuttleExtenderReverse() {
    setPiston(Value.kReverse);
  }

  public DoubleSolenoid.Value getShuttleExtenderPosition() {
    return collectorPiston.get();
  }

  // Shuttle Delay Might Be Used For Sequential Command Groups
  public void startTimer() {
    delay.start();
  }

  public void stopTimer() {
    delay.stop();
  }

  public void resetTimer() {
    delay.reset();
  }

  public double getTimer() {
    return delay.get();
  }
}
