package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Climber;

public class RunFlimseyArm extends CommandBase {

    private Climber climber;
    private double rotationValue;
    private boolean done;

    public RunFlimseyArm(double amountOfRotation) {
        this.climber = Robot.climber;
        rotationValue = amountOfRotation;
        done = false;
    }

    @Override
    public void initialize() {
        climber.spoolCoast();
        climber.resetFlimseyEncoder();
    }

    @Override
    public void execute() {
        double tolerance = 0.005;
        if (climber.getPositionFlimseyEncoder() >= rotationValue - tolerance &&  rotationValue + tolerance >= climber.getPositionFlimseyEncoder()) {
            climber.spoolBreak();
            climber.setFlimseyArm(0);
            done = true;
        } else if (climber.getPositionFlimseyEncoder() < rotationValue) {
            climber.setFlimseyArm(Constants.Motorspeed.Climber.FLIMSEY_SPEED);
        } else {
            climber.setFlimseyArm(Constants.Motorspeed.Climber.FLIMSEY_SPEED * -1);
        }
    }

    @Override
    public boolean isFinished() {
        return done;
    }
}