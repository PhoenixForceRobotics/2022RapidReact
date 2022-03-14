// package frc.robot.subsystems;

// import com.revrobotics.CANSparkMax.IdleMode;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;
// import com.revrobotics.RelativeEncoder;
// import com.revrobotics.SparkMaxRelativeEncoder;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.util.Constants;
// import frc.robot.util.Motor;

// public class IntakeSystem extends SubsystemBase {
// Motor rotatorMotor;
// RelativeEncoder rotatorMotorEncoder;

// public IntakeSystem() {

// rotatorMotor =
// new Motor(
// Constants.MotorMap.Climber.ROTATEINTAKE,
// MotorType.kBrushless,
// Constants.MotorMap.Climber.ROTATEINTAKE_REVERSED,
// 40);

// rotatorMotorEncoder =
// rotatorMotor.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
// }

// public void setRotatorEncoder(double position) {
// rotatorMotorEncoder.setPosition(position);
// }

// public double getRotatorEncoderPosition() {
// return rotatorMotorEncoder.getPosition();
// }

// public void setRotatorMotorSpeed(double speed) {
// rotatorMotor.set(speed);
// }

// public void rotatorMotorCoast() {
// rotatorMotor.setIdleMode(IdleMode.kCoast);
// }

// public void rotatorMotorBreak() {
// rotatorMotor.setIdleMode(IdleMode.kBrake);
// }
// }
