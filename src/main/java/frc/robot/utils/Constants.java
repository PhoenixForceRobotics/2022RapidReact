package frc.robot.utils;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into to a variable name.
 * This provides flexibility changing wiring, makes checking the wiring easier and significantly
 * reduces the number of magic numbers floating around.
 */
public class Constants {
  public static final class DriveConstants {

    public static final int LEFT_1 = 3;
    public static final int LEFT_2 = 4;
    public static final boolean LEFT_REVERSE = false;

    public static final int RIGHT_1 = 1;
    public static final int RIGHT_2 = 2;
    public static final boolean RIGHT_REVERSE = true;

    public static final double STICK_POWER = 3;

    public static final double STATIC_VOLTS = 0.0; // Constant
    public static final double VELOCITY_VOLTS = 0.0; // Volt seconds per meter
    public static final double ACCELERATION_VOLTS = 0.0; // Volt seconds per meter ^ 2

    public static final SimpleMotorFeedforward FEED_FORWARD =
        new SimpleMotorFeedforward(STATIC_VOLTS, VELOCITY_VOLTS, ACCELERATION_VOLTS);
    // TODO: !!!!SysID to gain these values!!!!!\

    public static final DifferentialDriveKinematics DRIVE_KINEMATICS =
        new DifferentialDriveKinematics(1);
    // TODO: Find the actual value of the track width IN METERS

    public static final PIDController LEFT_PID = new PIDController(0.01, 0, 0);
    public static final PIDController RIGHT_PID = new PIDController(0.01, 0, 0);
    // TODO: tune this PID

    public static final double MAX_ACCELERATION_ERROR = 5; // In meters/second^2
  }

  public static final class AutoConstants {
    public static final RamseteController RAMSETE_CONTROLLER = new RamseteController();

    public static final double MAX_SPEED = 5; // TODO: Decide reasonable speed and accel
    public static final double MAX_ACCELERATION = 1;
    public static final double MAX_VOLTAGE = 10;

    public static final DifferentialDriveVoltageConstraint AUTO_VOLTAGE_CONSTRAINT =
        new DifferentialDriveVoltageConstraint(
            DriveConstants.FEED_FORWARD, DriveConstants.DRIVE_KINEMATICS, MAX_VOLTAGE);
    public static final TrajectoryConfig TRAJECTORY_CONFIG =
        new TrajectoryConfig(MAX_SPEED, MAX_ACCELERATION)
            .setKinematics(DriveConstants.DRIVE_KINEMATICS)
            .addConstraint(AUTO_VOLTAGE_CONSTRAINT);
  }

  public static final class ClimbConstants {
    public static final int FORWARD_CHANNEL = 2;
    public static final int REVERSE_CHANNEL = 3;
  }

  public static final class TurretConstants {

    public static int HOOD_PORT = 11;
    public static int LEFT_FLYWHEEL_PORT = 21;
    public static int RIGHT_FLYWHEEL_PORT = 20;
    public static int ROTATE_PORT = 8;

    public static boolean HOOD_REVERSED = true;
    public static boolean LEFT_FLYWHEEL_REVERSED = false;
    public static boolean RIGHT_FLYWHEEL_REVERSED = true;
    public static boolean ROTATE_REVERSED = false;

    public static double ROTATE_SPEED = .4;

    public static double HOOD_SPEED = .2;

    public static int RELAY_PORT = 0;

    public static FalconConfigFields FLYWHEEL =
        new FalconConfigFields(new PIDValues(0.1, 0, 0, 0, 1), 1.0);

    // TODO: Calculate the feedforward for the flywheel

    public static final double MAX_ANGLE_LEFT = -120; // In degrees
    public static final double MAX_ANGLE_RIGHT = 90;

    public static final double MAX_SPEED = 0.5;
    public static final int STICK_POWER = 3;

    public static final double HOOP_HEIGHT = 103.937; // Inches
    public static final double FLYWHEEL_HEIGHT = 33;
    public static final double TOTAL_HEIGHT = HOOP_HEIGHT - FLYWHEEL_HEIGHT;

    public static final double HOOD_MAX_ROTATE = 5;

    public static final double FLYWHEEL_HIGH = 70;
    public static final double FLYWHEEL_LOW = 55;

    public static double ZONE3 = 362.243; // Furthest corner to center
    public static double ZONE2 = ZONE3 * 2 / 3; // 241.4953333
    public static double ZONE1 = ZONE3 / 3; // 120.74.......;;''''''''''[76667

    public static double ROTATE_BUFFER = 0.05;

    public static double GRAVITY =
        386.0892; // force of earth's gravity at sea level in inches/second/second; it's
    // in inches to stay consistent with everything else

    // lower speeds for more accuracy
    public static double VELOCITY_ZONE1 =
        ZONE1
            / (Math.cos((50.0 / 180.0) * Math.PI)
                * Math.sqrt(
                    (ZONE1 * Math.tan((50 / 180.0) * Math.PI) - TOTAL_HEIGHT) / (GRAVITY / 2)));
    // Meters per second, can reach ZONE1 horizontally max,
    // TOTAL_HEIGHT height at 50 degrees ~305.55 inches/second (for now)
    public static double VELOCITY_ZONE2 =
        ZONE2
            / (Math.cos((50.0 / 180.0) * Math.PI)
                * Math.sqrt(
                    (ZONE2 * Math.tan((50.0 / 180.0) * Math.PI) - TOTAL_HEIGHT) / (GRAVITY / 2)));;
    // Meters per second, can reach ZONE2 horizontally,
    // TOTAL_HEIGHT height at 50 degrees ~354 inches/second (for now)
    public static double VELOCITY_ZONE3 =
        ZONE3
            / (Math.cos((50.0 / 180.0) * Math.PI)
                * Math.sqrt(
                    (ZONE3 * Math.tan((50.0 / 180.0) * Math.PI) - TOTAL_HEIGHT) / (GRAVITY / 2)));;
    // inches per second, can reach ZONE3 horizontally,
    // TOTAL_HEIGHT height at 50 degrees ~412 inches/second

  }

  public static final class ControllerConstants {
    public static final int DPAD_DOWN = 180;
    public static final int DPAD_UP = 0;
    public static final int DPAD_LEFT = 270;
    public static final int DPAD_RIGHT = 90;

    public static final double AXIS_DEADZONE = 0.05;
  }

  public static final class UtilConstants {
    public static final double FALCON_ENCODER_RESOLUTION = 2048;
    public static final int CLOSED_LOOP_SPEED_MS = 1; // in milliseconds
  }

  public static final class IntakeConstants {
    public static final int COLLECTOR_PORT = 7;
    public static final int BELT_PORT = 9;
    public static final int TRANSPORT_LEFT_PORT = 5;
    public static final int TRANSPORT_RIGHT_PORT = 6;

    public static final boolean COLLECTOR_REVERSED = false;
    public static final boolean BELT_REVERSED = true;
    public static final boolean TRANSPORT_LEFT_REVERSED = true;
    public static final boolean TRANSPORT_RIGHT_REVERSED = true;

    public static final int COLLECTOR_PISTON_FORWARD_PORT = 0;
    public static final int COLLECTOR_PISTON_REVERSED_PORT = 1;

    public static final double BELT_SPEED = 0.3;
    public static final double TRANSPORT_OUTTAKE_SPEED = 0.35;
    public static final double FEED_FLYWHEEL_SPEED = 1;
    public static final double COLLECTOR_SPEED = 0.5;
    public static final double SWITCH_FREQUENCY = 0.25;
  }
}
