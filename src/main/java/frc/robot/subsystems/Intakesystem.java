package frc.robot.subsystems;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Motor;

public class Intakesystem extends SubsystemBase {

  // variable decleration

  public static Motor rotatormotor2, wheelmotor;
  private static DoubleSolenoid piston1, piston2;
  private static RelativeEncoder rotatormotor2Encoder, wheelmotorEncoder;

  public Intakesystem() {

    // motor setting

    rotatormotor2 = new Motor(5, MotorType.kBrushless, true, 40);
    wheelmotor = new Motor(6, MotorType.kBrushless, true, 40);

    // motor encoder setting

    rotatormotor2Encoder = rotatormotor2.getEncoder();
    wheelmotorEncoder = wheelmotor.getEncoder();

    // piston setting

    piston1 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    piston2 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);
  }

  // rotator motor setter/getters

  // rotator motor 2 setter/getters

  public void setRotator2Encoder(double value) {
    rotatormotor2Encoder.setPosition(value);
  }

  public double getRotator2EncoderPosition() {
    return rotatormotor2Encoder.getPosition();
  }

  public void setRotatormotor2Speed(double speed) {
    rotatormotor2.set(speed);
  }

  public void rotatorMotor2Coast() {
    rotatormotor2.setIdleMode(IdleMode.kCoast);
  }

  public void rotatorMotor2Brake() {
    rotatormotor2.setIdleMode(IdleMode.kBrake);
  }

  public double getRotator2Velocity() {
    return rotatormotor2Encoder.getVelocity();
  }

  // wheel motor setter/getters

  public void setWheelEncoder(double value) {
    wheelmotorEncoder.setPosition(value);
  }

  public double getWheelEncoderPosition() {
    return wheelmotorEncoder.getPosition();
  }

  public void setWheelmotorSpeed(double speed) {
    wheelmotor.set(speed);
  }

  public void WheelMotorCoast() {
    wheelmotor.setIdleMode(IdleMode.kCoast);
  }

  public void WheelMotorBrake() {
    wheelmotor.setIdleMode(IdleMode.kBrake);
  }

  public double getWheelVelocity() {
    return wheelmotorEncoder.getVelocity();
  }

  // piston1 functions

  public void setPiston1Forward() {
    piston1.set(Value.kForward);
  }

  public void setPiston1Reverse() {
    piston1.set(Value.kReverse);
  }

  // piston1 functions

  public void setPiston2Forward() {
    piston2.set(Value.kForward);
  }

  public void setPiston2Reverse() {
    piston2.set(Value.kReverse);
  }

  public boolean pissonntoggle = true;
}
