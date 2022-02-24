package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import frc.robot.utility.ArcMath;

public class NetworkTableManager {
    NetworkTableEntry xEntry;
    NetworkTableEntry yEntry;
 
    public void robotInit() {
       //Get the default instance of NetworkTables that was created automatically
       //when your program starts
       NetworkTableInstance inst = NetworkTableInstance.getDefault();

       NetworkTable table = inst.getTable("PiVisionData"); //grab data from pi

       NetworkTableEntry hasTarget = table.getEntry("hasTarget");
       NetworkTableEntry ACSXCoordinate = table.getEntry("ACSX");
       NetworkTableEntry ACSYCoordinate = table.getEntry("ACSY");
       NetworkTableEntry PCSXCoordinate = table.getEntry("PCSX");
       NetworkTableEntry PCSYCoordinate = table.getEntry("PCSY");
       NetworkTableEntry yawEntry = table.getEntry("yaw");
       NetworkTableEntry pitchEntry = table.getEntry("pitch");
       NetworkTableEntry distanceEntry = table.getEntry("distance");
 
       //Get the entries within that table that correspond to the X and Y values
       //for some operation in your program.
       xEntry = table.getEntry("X");
       yEntry = table.getEntry("Y");
       
    }
 
    public void teleopPeriodic() {
       double x = 1;
       double y = 1;
       //Using the entry objects, set the value to a double that is constantly
       //increasing. The keys are actually "/datatable/X" and "/datatable/Y".
       //If they don't already exist, the key/value pair is added.
                           
    }
}