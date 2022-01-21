package frc.robot;

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class Constants {
    public static class MotorMap {
        public static class Flywheel {
            public static int HOOD = 4;
            public static int SHOOT_LEFT = 5;
            public static int SHOOT_RIGHT = 6;
            public static int ROTATE = 7;

            public static boolean HOOD_REVERSED = false;
            public static boolean SHOOT_LEFT_REVERSED = false;
            public static boolean SHOOT_RIGHT_REVERSED = false;
            public static boolean ROTATE_REVERSED = false;
        }
    }
    public static class SubsystemMath {
        public static class FlywheelMath {

        }
    }
}