package frc.team2097.utils;

public class OI {
    public PFRController driverController;
    public PFRController operatorController;

    public OI() {
        driverController = new PFRController(0);
        operatorController = new PFRController(1);
 
        // Initialize Button Bindings
        
        /*
        * Example:
        * driverController.aButton().whenPressed(RunDrivebase(Robot.drivebase)); 
        */
    }
}
