package frc.robot.subsystems;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Motor;

public class Intake extends SubsystemBase {

  // variable decleration

  public Motor intakeMotor;
  private DoubleSolenoid intakePiston;
  private RelativeEncoder intakeEncoder;

  public Intake() {

    // motor setting
    intakeMotor = new Motor(6, MotorType.kBrushless, true, 40);

    // motor encoder setting
    intakeEncoder = intakeMotor.getEncoder();

    // piston setting
    intakePiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);
  }

  // rotator motor 2 setter/getters
  public void setIntakeEncoder(double value) {
    intakeEncoder.setPosition(value);
  }

  public double getIntakeEncoderPosition() {
    return intakeEncoder.getPosition();
  }

  public void setIntakeMotor(double speed) {
    intakeMotor.set(speed);
  }

  public void intakeMotorCoast() {
    intakeMotor.setIdleMode(IdleMode.kCoast);
  }

  public void intakeMotorBrake() {
    intakeMotor.setIdleMode(IdleMode.kBrake);
  }

  // intakePiston functions

  public void setIntakePistonForward() {
    intakePiston.set(Value.kForward);
  }

  public void setIntakePistonReverse() {
    intakePiston.set(Value.kReverse);
  }

  public DoubleSolenoid.Value getIntakePistonPosition() {
    return intakePiston.get();
  }

  // piston1 functions
  public boolean pissonntoggle = true;
}
