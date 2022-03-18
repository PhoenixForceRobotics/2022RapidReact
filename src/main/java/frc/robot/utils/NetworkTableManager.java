package frc.robot.utils;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class NetworkTableManager {
   private static NetworkTableInstance inst = NetworkTableInstance.getDefault();

   private static NetworkTable table = inst.getTable("PiVisionData"); //grab data from pi

   private static NetworkTableEntry hasTarget = table.getEntry("hasTarget");
   private static NetworkTableEntry ACSXCoordinate = table.getEntry("ACSX");
   private static NetworkTableEntry ACSYCoordinate = table.getEntry("ACSY");
   private static NetworkTableEntry PCSXCoordinate = table.getEntry("PCSX");
   private static NetworkTableEntry PCSYCoordinate = table.getEntry("PCSY");
   private static NetworkTableEntry yawEntry = table.getEntry("yaw");
   private static NetworkTableEntry pitchEntry = table.getEntry("pitch");
   private static NetworkTableEntry distanceEntry = table.getEntry("distance");

   public static boolean getHasTarget() {
       return hasTarget.getBoolean(false);
   }

   public static double getACSXCoordinate() {
       return ACSXCoordinate.getDouble(5);
   }
   public static double getACSYCoordinate() {
       return ACSYCoordinate.getDouble(0);
   }

   public static double getPCSXCoordinate() {
       return PCSXCoordinate.getDouble(0);
   }

   public static double getPCSYCoordinate() {
       return PCSYCoordinate.getDouble(0);
   }

   public static double getDistanceEntry() {
       return distanceEntry.getDouble(0);
   }

   public static double getYawEntry() {
       return yawEntry.getDouble(0);
   }

   public static double getPitchEntry() {
       return pitchEntry.getDouble(0);
   }

   public static double getPitch() {
      return pitchEntry.getDouble(0);
   }
      //Get the default instance of NetworkTables that was created automatically
       //when your program starts
       
       //Get the entries within that table that correspond to the X and Y values
       //for some operation in your program.
}