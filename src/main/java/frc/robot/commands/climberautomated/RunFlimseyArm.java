package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.PID;

public class RunFlimseyArm extends CommandBase {

    private Climber climber;
    private PID pid;

    private double rotationValue;
    private double tolerance;
    private boolean done;
    private double motorSpeed;

    public RunFlimseyArm(double amountOfRotation, double toleranceValue) {
        this.climber = Robot.climber;

        this.pid = Robot.pid;

        rotationValue = amountOfRotation;
        tolerance = toleranceValue;

        done = false;
    }

    @Override
    public void initialize() {
        climber.spoolCoast();
        climber.resetFlimseyEncoder();
        pid.flimseyReset();
        pid.flimseySetSetPoint(rotationValue);
        pid.flimseySetTolerance(tolerance);

        done = false;
        
    }

    @Override
    public void execute() {
        
        if (pid.flimseyAtSetPoint()){
            climber.setFlimseyArm(0);
            pid.flimseyReset();
            done = true;
        }
        else {
            motorSpeed = pid.flimseyCalculate(climber.getPositionFlimseyEncoder());
            climber.setFlimseyArm(motorSpeed);
        }
     

        // double tolerance = 0.005;
        // if (climber.getPositionFlimseyEncoder() >= rotationValue - tolerance &&  rotationValue + tolerance >= climber.getPositionFlimseyEncoder()) {
        //     climber.spoolBreak();
        //     climber.setFlimseyArm(0);
        //     done = true;
        // } else if (climber.getPositionFlimseyEncoder() < rotationValue) {
        //     climber.setFlimseyArm(Constants.Motorspeed.Climber.FLIMSEY_SPEED);
        // } else {
        //     climber.setFlimseyArm(Constants.Motorspeed.Climber.FLIMSEY_SPEED * -1);
        // }
    }

    @Override
    public boolean isFinished() {
        return done;
    }
}