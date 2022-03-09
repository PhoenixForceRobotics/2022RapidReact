package frc.team2097.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2097.utility.Constants;
import frc.team2097.subsystems.Flywheel;

public class FlywheelPID extends CommandBase {
    private double P, D;
    private double previous_error, setVelocity, error, derivative;
    private Flywheel flywheel;
    private double PIDSpeed;
    private boolean done;
    private boolean PIDstatus;

    public FlywheelPID(Flywheel flywheel, double setVelocity) {
        this.flywheel = flywheel;
        P = Constants.SubsystemMath.FlywheelMath.FLYWHEEL_P;
        D = Constants.SubsystemMath.FlywheelMath.FLYWHEEL_D;
        previous_error = 0;
        error = 0;
        derivative = 0;
        PIDSpeed = 0;
        this.setVelocity = setVelocity / .969;
    }

    public boolean PID() {
        error = setVelocity - flywheel.getFWLeftEncoderVel();
        derivative = (error - this.previous_error) / .02;
        PIDSpeed += (P * error + D * derivative);
        this.previous_error = error;
        return (error <= .5 && error >= .5);
    }

    @Override
    public void initialize() {
        done = false;
        flywheel.resetFWEncoder();
    }

    @Override
    public void execute() {
        PIDstatus = PID();
        if (flywheel.getToggleFlyWheel() && PIDstatus == false) {
            flywheel.setFlywheel(PIDSpeed);
        } else {
            // Keeps at previous speed
        }
    }

    @Override
    public boolean isFinished() {
        return done;
    }
}
