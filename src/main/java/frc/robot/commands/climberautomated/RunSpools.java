package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.PID;

public class RunSpools extends CommandBase {

    private Climber climber;
    private PID pid;

    private double rotationValue;
    private double tolerance;
    private boolean done;
    private double motorSpeed;

    public RunSpools(double amountOfRotation, double tolerance) {
        this.climber = Robot.climber;
        this.pid = Robot.pid;
        rotationValue = amountOfRotation;
        done = false;
    }

    @Override
    public void initialize() {
        climber.spoolBreak();
        climber.resetSpoolLeftEncoder();

        pid.spoolReset();
        pid.spoolSetSetPoint(rotationValue);
        pid.spoolSetTolerance(tolerance);

        done = false;
    }

    @Override
    public void execute() {
            motorSpeed = pid.spoolCalculate(climber.getPositionLeftEncoder());
            climber.setSpools(motorSpeed);
            
        // double tolerance = 0.005;
        // if (climber.getPositionLeftEncoder() >= rotationValue - tolerance &&  rotationValue + tolerance >= climber.getPositionLeftEncoder()) {
        //     climber.setSpools(0);
        //     done = true;
        // } else if (climber.getPositionLeftEncoder() < rotationValue) {
        //     climber.setSpools(Constants.Motorspeed.Climber.SPOOL_SPEED);
        // } else {
        //     climber.setSpools(Constants.Motorspeed.Climber.SPOOL_SPEED * -1);
        // }
    }

    @Override
    public boolean isFinished() {
        if (pid.spoolAtSetPoint()){
            climber.setSpools(0);
            pid.spoolReset();
            done = true;
        }
        return done;
    }
}
