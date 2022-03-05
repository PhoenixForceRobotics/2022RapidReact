package frc.team2097.commands;

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2097.utility.Constants;
import frc.team2097.subsystems.Flywheel;

public class FlyWheelPID extends CommandBase{
    private double P, D;
    private double previous_error, setVelocity, error, derivative;
    private Flywheel flywheel;
    private double PIDSpeed;
    private boolean done;

    public FlyWheelPID(Flywheel flywheel, double setVelocity) {
        this.flywheel = flywheel;
        P = Constants.SubsystemMath.FlywheelMath.FLYWHEEL_P;
        D = Constants.SubsystemMath.FlywheelMath.FLYWHEEL_D;
        previous_error = 0;
        error = 0;
        derivative = 0;
        PIDSpeed = 0;
        this.setVelocity = setVelocity;
    }

    public boolean PID() {
        System.out.println(flywheel.getFWLeftEncoderVel());
        error = setVelocity - flywheel.getFWLeftEncoderVel();
        derivative = (error - this.previous_error) / .02;
        PIDSpeed += (P*error + D*derivative) / 5800;
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
        done = PID();
        flywheel.setFlywheel(PIDSpeed);
    }

    @Override
    public boolean isFinished() {
        if(done) {
            flywheel.setFlywheel(0);
        }
        return done;
    }
}
