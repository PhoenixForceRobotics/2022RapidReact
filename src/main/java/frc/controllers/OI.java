package frc.robot.Services;

import frc.robot.Commands.DisableSolenoid;
import frc.robot.Commands.ForwardSolenoid;
import frc.robot.Commands.ReverseSolenoid;
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

