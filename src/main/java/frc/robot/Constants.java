package frc.robot;

public class Constants {

    public static class MotorMap{

        public static class Climber{

            //change these values to ports later
            public static int FLIMSEYARM = 2;
            public static boolean FlIMSEYARM_REVERSED = false;

            public static int SPOOLLEFT = 1;
            public static boolean SPOOLLEFT_REVERSED = false;

            public static int SPOOLRIGHT = 3;
            public static boolean SPOOLRIGHT_REVERSED = false;
        }
    }

    public static class PneumaticsMap{

        public static class Climber{

            //change these values to ports later
            public static int SOLENOID1 = 4;
            public static int SOLENOID2 = 5;
            public static int SOLENOID3 = 6;
        }
    }

    public static class Motorspeed{

        public static class Climber{

            public static double SPOOL_SPEED = .1;
            public static double FLIMSEY_SPEED = .1;
        }
    }
}
