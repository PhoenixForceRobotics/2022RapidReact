package frc.utils;

import frc.commands.DisableSolenoid;
import frc.commands.ForwardSolenoid;
import frc.commands.ReverseSolenoid;
import frc.robot.Robot;

public class OI {
    private PFRController driverController;
    private PFRController operatorController;
    
    public OI()
    {
        driverController = new PFRController(0);
        operatorController = new PFRController(1);
        initializeBindings();
    }

    public void initializeBindings()
    {
        driverController.xButton().whenPressed(new DisableSolenoid(Robot.climb));
        driverController.yButton().whenPressed(new ForwardSolenoid(Robot.climb));
        driverController.aButton().whenPressed(new ReverseSolenoid(Robot.climb));
    }
    
    public PFRController getDriverController() {
        return driverController;
    }

    public PFRController getOperatorController() {
        return operatorController;
    }


}

