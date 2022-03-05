package frc.team2097.commands;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2097.subsystems.Flywheel;

public class FlyWheelHoodReset extends CommandBase{
    private Flywheel flywheel;
    private boolean done;
    private RelativeEncoder hoodEncoder;


    
    public FlyWheelHoodReset(Flywheel flywheel) {
        this.flywheel = flywheel;
        done = false;
    }

    @Override
    public void initialize() {
        flywheel.setFlywheelHoodCoast();
        done = false;
        hoodEncoder = flywheel.fwHoodEncoder;
    }

    @Override
    public void execute() {
        if (hoodEncoder.getVelocity() <= 10) {
            done = true;
        } else {
            flywheel.setFlywheelHood(.05);
            done = false;
        }
    }

    @Override
    public boolean isFinished() {
        if(done) {
            hoodEncoder.setPosition(0);
            flywheel.setFlywheelHoodBrake();
        }
        return done;
    }
}