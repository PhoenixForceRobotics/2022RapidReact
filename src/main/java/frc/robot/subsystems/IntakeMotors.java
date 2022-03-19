package frc.robot.subsystems;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants;
import frc.robot.utils.Motor;

public class IntakeMotors extends SubsystemBase {

  // variable decleration

  public static Motor collectormotor2, collectormotor1;
  private static RelativeEncoder collectormotor1Encoder, collectormotor2Encoder;

  public IntakeMotors() {

    // motor setting

    collectormotor2 =
        new Motor(Constants.IntakeConstants.INTAKE_WHEEL_PORT, MotorType.kBrushless, true, 40);
    collectormotor1 =
        new Motor(Constants.IntakeConstants.INTAKE_WHEEL_PORT, MotorType.kBrushless, true, 40);

    // motor encoder setting

    collectormotor1Encoder = collectormotor2.getEncoder();
    collectormotor2Encoder = collectormotor1.getEncoder();
  }

  // rotator motor setter/getters

  public void setcollectormotor2Encoder(double value) {
    collectormotor2Encoder.setPosition(value);
  }

  public double getcollectormotor2EncoderPosition() {
    return collectormotor2Encoder.getPosition();
  }

  public void setcollectormotor2Speed(double speed) {
    collectormotor2.set(speed);
  }

  public void collectormotor2Coast() {
    collectormotor2.setIdleMode(IdleMode.kCoast);
  }

  public void collectormotor2Brake() {
    collectormotor2.setIdleMode(IdleMode.kBrake);
  }

  public double getcollectormotor2Velocity() {
    return collectormotor2Encoder.getVelocity();
  }

  // wheel motor setter/getters

  public void setcollectormotor1Encoder(double value) {
    collectormotor1Encoder.setPosition(value);
  }

  public double getcollectormotor1EncoderPosition() {
    return collectormotor1Encoder.getPosition();
  }

  public void setcollectormotor1Speed(double speed) {
    collectormotor1.set(speed);
  }

  public void collectormotor1Coast() {
    collectormotor1.setIdleMode(IdleMode.kCoast);
  }

  public void collectormotor1Brake() {
    collectormotor1.setIdleMode(IdleMode.kBrake);
  }

  public double getcollectormotor1Velocity() {
    return collectormotor1Encoder.getVelocity();
  }
}
