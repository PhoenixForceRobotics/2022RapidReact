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
import frc.robot.utils.Constants.DriveConstants;
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
            DriveConstants.LEFT_REVERSE,
            new CANSparkMax(DriveConstants.LEFT_1, MotorType.kBrushless),
            new CANSparkMax(DriveConstants.LEFT_2, MotorType.kBrushless));

    right =
        new SparkMotorGroup(
            DriveConstants.RIGHT_REVERSE,
            new CANSparkMax(DriveConstants.RIGHT_1, MotorType.kBrushless),
            new CANSparkMax(DriveConstants.RIGHT_2, MotorType.kBrushless));
    leftEncoder = left.getEncoder();
    rightEncoder = right.getEncoder();

    differentialDrive = new DifferentialDrive(left, right);

    setConversion(0.15, 14.7);
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
    System.out.println("Voltage: " + leftVoltage);
  }

  public void tankDrive(double leftStick, double rightStick) {
    set(
        Math.pow(leftStick, DriveConstants.STICK_POWER),
        Math.pow(rightStick, DriveConstants.STICK_POWER));
  }

  public void arcadeDrive(double forward, double turn) {
    differentialDrive.arcadeDrive(forward, turn);
  }

  public void setConversion(double wheelCircumference, double gearRatio) {
    leftEncoder.setPositionConversionFactor(wheelCircumference * Math.PI / gearRatio);
    leftEncoder.setVelocityConversionFactor(wheelCircumference * Math.PI / gearRatio / 60);

    rightEncoder.setPositionConversionFactor(wheelCircumference * Math.PI / gearRatio);
    rightEncoder.setVelocityConversionFactor(wheelCircumference * Math.PI / gearRatio / 60);
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

  public RelativeEncoder getLeftEncoder() {
    return leftEncoder;
  }

  public RelativeEncoder getRightEncoder() {
    return rightEncoder;
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
