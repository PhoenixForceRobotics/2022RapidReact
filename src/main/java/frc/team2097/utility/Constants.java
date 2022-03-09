package frc.team2097.utility;

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
            public static int SHOOT_LEFT = 2;
            public static int SHOOT_RIGHT = 6;
            public static int ROTATE = 7;

            public static boolean HOOD_REVERSED = false;
            public static boolean SHOOT_LEFT_REVERSED = false;
            public static boolean SHOOT_RIGHT_REVERSED = false;
            public static boolean ROTATE_REVERSED = false;
        }
    }

    public static class MotorSpeeds {
        public static class Flywheel {

            public static double ROTATE_SPEED = .4;

            public static double HOOD_SPEED = .4;

        }
    }

    public static class SubsystemMath {
        public static class FlywheelMath {
            public static double FLYWHEEL_P = .1;
            public static double FLYWHEEL_D = 0;

            public static double HOOP_HEIGHT = 103.937; // Inches
            public static double FLYWHEEL_HEIGHT = 33;
            public static double TOTAL_HEIGHT = HOOP_HEIGHT - FLYWHEEL_HEIGHT;

            public static double HOOD_MAX_ROTATE = 5;

            public static double ZONE3 = 362.243; // Furthest corner to center
            public static double ZONE2 = ZONE3 * 2 / 3; // 241.4953333
            public static double ZONE1 = ZONE3 / 3; // 120.7476667

            // lower speeds for more accuracy
            public static double VELOCITY_ZONE1 = ZONE1 /
                    (Math.cos((50.0 / 180.0) * Math.PI) *
                            Math.sqrt((ZONE1 * Math.tan((50 / 180.0) * Math.PI) - TOTAL_HEIGHT)
                                    / (TurretConstants.GRAVITY / 2)));
            // Meters per second, can reach ZONE1 horizontally max,
            // TOTAL_HEIGHT height at 50 degrees ~305.55 inches/second (for now)
            public static double VELOCITY_ZONE2 = ZONE2 /
                    (Math.cos((50.0 / 180.0) * Math.PI) *
                            Math.sqrt((ZONE2 * Math.tan((50.0 / 180.0) * Math.PI) - TOTAL_HEIGHT)
                                    / (TurretConstants.GRAVITY / 2)));;
            // Meters per second, can reach ZONE2 horizontally,
            // TOTAL_HEIGHT height at 50 degrees ~354 inches/second (for now)
            public static double VELOCITY_ZONE3 = ZONE3 /
                    (Math.cos((50.0 / 180.0) * Math.PI) *
                            Math.sqrt((ZONE3 * Math.tan((50.0 / 180.0) * Math.PI) - TOTAL_HEIGHT)
                                    / (TurretConstants.GRAVITY / 2)));;
            // inches per second, can reach ZONE3 horizontally,
            // TOTAL_HEIGHT height at 50 degrees ~412 inches/second

            public static double ROTATE_BUFFER = 0.05;

        }
    }

    public static class TurretConstants {
        public static double GRAVITY = 386.0892; // force of earth's gravity at sea level in inches/second/second; it's
                                                 // in inches to stay consistent with everything else
    }
}