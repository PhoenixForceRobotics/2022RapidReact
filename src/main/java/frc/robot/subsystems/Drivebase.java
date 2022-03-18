package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.math.filter.LinearFilter;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.Vector2d;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.SparkMotorGroup;

public class Drivebase extends SubsystemBase {

  private SparkMotorGroup left;
  private SparkMotorGroup right;

  private RelativeEncoder leftEncoder;
  private RelativeEncoder rightEncoder;

  private Gyro gyro = new ADXRS450_Gyro();

  private DifferentialDrive differentialDrive;
  private DifferentialDriveOdometry odometry;
  private Translation2d prevPosition;
  private Vector2d prevVelocity;
  private Vector2d curVelocity;
  private Vector2d poseAcceleration;

  private BuiltInAccelerometer accelerometer;
  private LinearFilter xAccelerationLinearFilter;
  private LinearFilter yAccelerationLinearFilter;
  private double xAcceleration;
  private double yAcceleration;
  private Vector2d accelerometerAcceleration;

  public Drivebase() {
    left =
        new SparkMotorGroup(
            true,
            new CANSparkMax(3, MotorType.kBrushless),
            new CANSparkMax(4, MotorType.kBrushless));

    right =
        new SparkMotorGroup(
            false,
            new CANSparkMax(2, MotorType.kBrushless),
            new CANSparkMax(1, MotorType.kBrushless));

    leftEncoder = left.getEncoder();
    rightEncoder = right.getEncoder();

    setConversion(12); // TODO: Distance in meters
    resetEncoders();

    odometry = new DifferentialDriveOdometry(gyro.getRotation2d());
    curVelocity = new Vector2d();
    poseAcceleration = new Vector2d();

    accelerometer = new BuiltInAccelerometer();
    xAccelerationLinearFilter = LinearFilter.singlePoleIIR(0.2, 0.02);
    yAccelerationLinearFilter = LinearFilter.singlePoleIIR(0.2, 0.02);
  }

  @Override
  public void periodic() {
    // Previous odometry
    prevPosition = odometry.getPoseMeters().getTranslation();

    // Update odometry
    odometry.update(gyro.getRotation2d(), leftEncoder.getPosition(), rightEncoder.getPosition());

    // Calculate velocity
    double vX = (odometry.getPoseMeters().getTranslation().getX() - prevPosition.getX()) / 0.02;
    double vY = (odometry.getPoseMeters().getTranslation().getY() - prevPosition.getY()) / 0.02;

    // Previous velocity
    prevVelocity = curVelocity;

    // Calculate velocity
    curVelocity = new Vector2d(vX, vY);

    // get acceleration vector
    double aX = (curVelocity.x - prevVelocity.x) / 0.02;
    double aY = (curVelocity.y - prevVelocity.y) / 0.02;

    poseAcceleration = new Vector2d(aX, aY);

    xAcceleration = xAccelerationLinearFilter.calculate(accelerometer.getX());
    yAcceleration = yAccelerationLinearFilter.calculate(accelerometer.getY());
    accelerometerAcceleration = new Vector2d(xAcceleration, yAcceleration); // Pythagorean!

    // if wheel.acceleration > accelerometer velocity + (arbritary constant to prevent small amounts
    // of slipage from causing any issue)

  }

  public void set(double leftPercentage, double rightPercentage) {
    left.set(leftPercentage);
    right.set(rightPercentage);
  }

  public void setVoltage(double leftVoltage, double rightVoltage) {
    left.setVoltage(leftVoltage);
    right.setVoltage(rightVoltage);
  }

  public void tankDrive(double leftStick, double rightStick, int stickPower) {
    left.set(Math.pow(leftStick, stickPower));
    right.set(Math.pow(rightStick, stickPower));
  }

  public void setConversion(double wheelCircumference) {
    leftEncoder.setPositionConversionFactor(wheelCircumference);
    leftEncoder.setVelocityConversionFactor(wheelCircumference / 60);

    rightEncoder.setPositionConversionFactor(wheelCircumference);
    rightEncoder.setVelocityConversionFactor(wheelCircumference / 60);
  }

  public Pose2d getPose() {
    return odometry.getPoseMeters();
  }

  public DifferentialDriveWheelSpeeds getWheelSpeeds() {
    return new DifferentialDriveWheelSpeeds(leftEncoder.getVelocity(), rightEncoder.getVelocity());
  }

  public double getHeading() {
    return gyro.getRotation2d().getDegrees();
  }

  public void resetEncoders() {
    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);
  }

  public SparkMotorGroup getLeft() {
    return left;
  }

  public SparkMotorGroup getRight() {
    return right;
  }

  public DifferentialDrive getDifferentialDrive() {
    return differentialDrive;
  }

  public BuiltInAccelerometer getAccelerometer() {
    return accelerometer;
  }

  public Vector2d getPoseAcceleration() {
    return poseAcceleration;
  }

  public Vector2d getAccelerometerAcceleration() {
    return accelerometerAcceleration;
  }
}
