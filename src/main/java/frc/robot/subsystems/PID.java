package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.math.controller.PIDController;

public class PID extends SubsystemBase {

    PIDController spoolPID;
    PIDController flimseyPID;

    public PID() {
        //change values, need to test to find the right values.
        spoolPID = new PIDController(0.5, 1, 1);
        flimseyPID = new PIDController(0.5, 1, 1);
    }

    public double flimseyCalculate(double measurement){
        return flimseyPID.calculate(measurement);
    }

    public boolean flimseyAtSetPoint(){
        return flimseyPID.atSetpoint();
    }

    public void flimseySetSetPoint(double setPoint){
        flimseyPID.setSetpoint(setPoint);
    }

    public void flimseySetTolerance(double tolerance){
        flimseyPID.setTolerance(tolerance);
    }

    public void flimseyReset(){
        flimseyPID.reset();
    }


    public double spoolCalculate(double measurement){
        return spoolPID.calculate(measurement);
    }

    public boolean spoolAtSetPoint(){
        return spoolPID.atSetpoint();
    }

    public void spoolSetSetPoint(double setPoint){
        spoolPID.setSetpoint(setPoint);
    }

    public void spoolSetTolerance(double tolerance){
        spoolPID.setTolerance(tolerance);
    }

    public void spoolReset(){
        spoolPID.reset();
    }
}
