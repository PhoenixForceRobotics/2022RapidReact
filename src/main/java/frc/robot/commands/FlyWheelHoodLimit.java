package frc.robot.commands;

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.utility.FlywheelMath;
import frc.robot.subsystems.Flywheel;

public class FlyWheelHoodLimit extends CommandBase{
    private Flywheel flywheel;
    private boolean done;
    private RelativeEncoder hoodEncoder;


    
    public FlyWheelHoodLimit(Flywheel flywheel) {
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
        if (hoodEncoder.getVelocity() <= 2) {
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
