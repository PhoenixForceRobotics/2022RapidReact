package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PID extends SubsystemBase{
    public PIDController intakePID;


    //creating new pid controller
    public PID(){
        intakePID = new PIDController(0.3, 0.0, 0.0);
    }


    //creating pid commands
    public double pidcalculate(double measurement){
        return intakePID.calculate(measurement);
    }
    public void setpidpoint(double setpoint){
        intakePID.setSetpoint(setpoint);
    }
    public void pidreset(){
        intakePID.reset();
    }
    public double getposerror(){
        return intakePID.getPositionError();
    }
    public void setTolerance(double tolerance){
        intakePID.setTolerance(tolerance);
    }
    public void setpidp(double p){
        intakePID.setP(p);
    }
    public void setpidi(double i){
        intakePID.setI(i);
    }
    public void setpidd(double d){
        intakePID.setD(d);
    }
    public boolean atsetpoint(){
        return intakePID.atSetpoint();
    }
    public void print(){
        System.out.println("I print");
    }
    
}
