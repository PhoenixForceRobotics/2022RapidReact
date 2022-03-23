package frc.robot.subsystems;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants;
import frc.robot.utils.Motor;

public class Shuttle extends SubsystemBase {

  // variable decleration

  private Motor shuttleMotor;
  private DoubleSolenoid shuttleExtender;
  private RelativeEncoder shuttleEncoder;
  private Timer delay;

  public Shuttle() {

    // motor setting
    shuttleMotor =
        new Motor(
            Constants.FeederIntakeConstants.SHUTTLE,
            MotorType.kBrushless,
            Constants.FeederIntakeConstants.SHUTTLE_REVERSE,
            40);

    shuttleEncoder = shuttleMotor.getEncoder();

    shuttleExtender = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);

    delay = new Timer();
  }

  // rotator motor 2 setter/getters
  public void setshuttleEncoder(double value) {
    shuttleEncoder.setPosition(value);
  }

  public double getshuttleEncoderPosition() {
    return shuttleEncoder.getPosition();
  }

  public void setShuttleMotor(double speed) {
    shuttleMotor.set(speed);
  }

  public void shuttleMotorCoast() {
    shuttleMotor.setIdleMode(IdleMode.kCoast);
  }

  public void shuttleMotorBrake() {
    shuttleMotor.setIdleMode(IdleMode.kBrake);
  }

  // shuttleExtender functions

  public void setShuttleExtenderForward() {
    shuttleExtender.set(Value.kForward);
  }

  public void setShuttleExtenderReverse() {
    shuttleExtender.set(Value.kReverse);
  }

  public DoubleSolenoid.Value getShuttleExtenderPosition() {
    return shuttleExtender.get();
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
