package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Climber;

public class RunSpools extends CommandBase {

    private Climber climber;
    private double rotationValue;
    private boolean done;

    public RunSpools(double amountOfRotation) {
        this.climber = Robot.climber;
        rotationValue = amountOfRotation;
        done = false;
    }

    @Override
    public void initialize() {
        climber.spoolBreak();
        climber.resetSpoolLeftEncoder();
    }

    @Override
    public void execute() {
        double tolerance = 0.005;
        if (climber.getPositionLeftEncoder() >= rotationValue - tolerance &&  rotationValue + tolerance >= climber.getPositionLeftEncoder()) {
            climber.setSpools(0);
            done = true;
        } else if (climber.getPositionLeftEncoder() < rotationValue) {
            climber.setSpools(Constants.Motorspeed.Climber.SPOOL_SPEED);
        } else {
            climber.setSpools(Constants.Motorspeed.Climber.SPOOL_SPEED * -1);
        }
    }

    @Override
    public boolean isFinished() {
        return done;
    }
}
