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
            public static int SHOOT_LEFT = 2;
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
            public static double FLYWHEEL_P = .1;
            public static double FLYWHEEL_D = .01;

            public static double HOOP_HEIGHT = 104; // Inches :(
            public static double FLYWHEEL_HEIGHT = 33; // Inches
            public static double TOTAL_HEIGHT = HOOP_HEIGHT - FLYWHEEL_HEIGHT;

            public static double HOOD_MAX_ROTATE = 5; // Motor rotate max on hood

            public static double ZONE3 = 362.243; // Length of the Hypotenuse of Quarter of Field in Inches
            public static double ZONE2 = ZONE3 * 2 / 3;
            public static double ZONE1 = ZONE3 / 3; 

            //lower speeds for more accuracy
            public static double VELOCITY_ZONE1 = ZONE1 / 
            (Math.cos((50.0/180.0) * Math.PI) * 
            Math.sqrt((ZONE1 * Math.tan((50.0/180.0) * Math.PI) - TOTAL_HEIGHT) / 192)); 
            // Inches per second, can reach ZONE1 horizontally max, 
            // TOTAL_HEIGHT height at 50 degrees ~9.56m/s (for now)
            public static double VELOCITY_ZONE2 = ZONE2 / 
            (Math.cos((50.0/180.0) * Math.PI) * 
            Math.sqrt((ZONE2 * Math.tan((50.0/180.0) * Math.PI) - TOTAL_HEIGHT) / 192)); ;
            // Inches per second, can reach ZONE2 horizontally, 
            // TOTAL_HEIGHT height at 50 degrees ~11.7m/s (for now)
            public static double VELOCITY_ZONE3 = ZONE3 / 
            (Math.cos((50.0/180.0) * Math.PI) * 
            Math.sqrt((ZONE3 * Math.tan((50.0/180.0) * Math.PI) - TOTAL_HEIGHT) / 192)); ; 
            // Inches per second, can reach ZONE3 horizontally, 
            // TOTAL_HEIGHT height at 50 degrees ~13.7m/s (for now)

        }
    }
}