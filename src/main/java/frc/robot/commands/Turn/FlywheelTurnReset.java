package frc.robot.commands.Turn;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Flywheel;
import frc.robot.utils.Constants;

public class FlywheelTurnReset extends CommandBase{
    private boolean done;
    public  boolean resetFWTurn;
    private double targetRotations, error;
    private Flywheel flywheel;

    public FlywheelTurnReset(Flywheel flywheel) {
        this.flywheel = flywheel;
     
    }

    @Override
    public void initialize() {
        done = false;
        targetRotations = 65.0 / 4;
        error = targetRotations;
        flywheel.resetFWRotateEncoder();
        resetFWTurn = false;
    }

    @Override
    public void execute() {
        error -= Math.abs(flywheel.getFWRotateEncoderPosition());
        if (Math.abs(flywheel.getFWRotateEncoderPosition()) >= targetRotations) {
            done = true;
            resetFWTurn = done;
            flywheel.resetFWRotateEncoder();
        }

        if (Constants.MotorSpeeds.Flywheel.ROTATE_SPEED * Math.abs( 1 / flywheel.getFWRotateEncoderPosition()) < .1) {
            flywheel.setFlywheelRotate(.1 * -1);
        } else if (Math.abs(flywheel.getFWRotateEncoderPosition()) > 2) {
            flywheel.setFlywheelRotate(Constants.MotorSpeeds.Flywheel.ROTATE_SPEED * -1 * Math.abs( 1 / flywheel.getFWRotateEncoderPosition()));            
        } else {
            flywheel.setFlywheelRotate(Constants.MotorSpeeds.Flywheel.ROTATE_SPEED * -1 * .5);
        }
    }

    @Override
    public boolean isFinished() {
        return done;
    }
}
