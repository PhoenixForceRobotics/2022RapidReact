/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.utils;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name.
 * This provides flexibility changing wiring, makes checking the wiring easier
 * and significantly
 * reduces the number of magic numbers floating around.
 */
public class Constants {
  public static final class DriveConstants {

    public static final int LEFT_1 = 1;
    public static final int LEFT_2 = 2;
    public static final boolean LEFT_REVERSE = true;

    public static final int RIGHT_1 = 3;
    public static final int RIGHT_2 = 4;
    public static final boolean RIGHT_REVERSE = false;

    public static final double STICK_POWER = 3;

    public static final double STATIC_VOLTS = 0.0; // Constant
    public static final double VELOCITY_VOLTS = 0.0; // Volt seconds per meter
    public static final double ACCELERATION_VOLTS = 0.0; // Volt seconds per meter ^ 2

    public static final SimpleMotorFeedforward FEED_FORWARD = new SimpleMotorFeedforward(STATIC_VOLTS, VELOCITY_VOLTS,
        ACCELERATION_VOLTS);
    // TODO: !!!!SysID to gain these values!!!!!\

    public static final DifferentialDriveKinematics DRIVE_KINEMATICS = new DifferentialDriveKinematics(
        1); // TODO: Find the actual value of the track width IN METERS

    public static final PIDController LEFT_PID = new PIDController(0.01, 0, 0);
    public static final PIDController RIGHT_PID = new PIDController(0.01, 0, 0); // TODO: tune this PID

    public static final double MAX_ACCELERATION_ERROR = 5; // In meters/second^2
  }

  public static final class FeederConstants {

    // TODO: Change feeder gear ratio values when we have them!
    public static final double RATIO_TRANSPORTER_TOP = 12;
    public static final double RATIO_TRANSPORTER_BOTTOM = 12;
    public static final double RATIO_OUTAKE = 12;

    // TODO: Change feeder reverse values to make all move ball toward shooter side
    // of the robot on going forward
    public static final int TRANSPORTER_TOP = 97;
    public static final boolean TRANSPORTER_TOP_REVERSE = true;

    public static final int TRANSPORTER_BOTTOM = 98;
    public static final boolean TRANSPORTER_BOTTOM_REVERSE = true;

    public static final int OUTAKE = 99;
    public static final boolean OUTAKE_REVERSE = true;
  }

  public static final class AutoConstants {
    public static final RamseteController RAMSETE_CONTROLLER = new RamseteController();

    public static final double MAX_SPEED = 5; // TODO: Decide reasonable speed and accel
    public static final double MAX_ACCELERATION = 1;
    public static final double MAX_VOLTAGE = 10;

    public static final DifferentialDriveVoltageConstraint AUTO_VOLTAGE_CONSTRAINT = new DifferentialDriveVoltageConstraint(
        DriveConstants.FEED_FORWARD, DriveConstants.DRIVE_KINEMATICS, MAX_VOLTAGE);
    public static final TrajectoryConfig TRAJECTORY_CONFIG = new TrajectoryConfig(MAX_SPEED, MAX_ACCELERATION)
        .setKinematics(DriveConstants.DRIVE_KINEMATICS)
        .addConstraint(AUTO_VOLTAGE_CONSTRAINT);
  }
}
