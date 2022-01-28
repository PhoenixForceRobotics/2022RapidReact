/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.util;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into to a variable name.
 * This provides flexibility changing wiring, makes checking the wiring easier and significantly
 * reduces the number of magic numbers floating around.
 */
public class Constants {
  public static class MotorMap {
    // Map your subsystem motor ports here
    public static class Drivebase {
      public static int LEFT_1 = 13;
      public static int LEFT_2 = 14;
      public static int LEFT_3 = 15;

      public static int RIGHT_1 = 16;
      public static int RIGHT_2 = 1;
      public static int RIGHT_3 = 2;

      public static final boolean LEFT1_REVERSED = false;
      public static final boolean LEFT2_REVERSED = false;
      public static final boolean LEFT3_REVERSED = false;

      public static final boolean RIGHT1_REVERSED = true;
      public static final boolean RIGHT2_REVERSED = true;
      public static final boolean RIGHT3_REVERSED = true;
    }
  }

  public static class SubsystemSpeeds {
    public static class DrivebaseSpeed {
      public static double MotorSpeed = .2;
      public static double MotorSpeed2 = .1;
    }

    public static class DrivebaseValues {
      public static double StickPower = 3;
    }
  }
}
