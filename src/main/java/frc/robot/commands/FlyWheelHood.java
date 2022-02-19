package frc.robot.commands;

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.utility.FlywheelMath;
import frc.robot.subsystems.Flywheel;


//range 50 - 85 degreess, 5 rotations, 1 is 9 degrees :D
public class FlyWheelHood extends CommandBase{
    private Flywheel flywheel;
    private double targetangle;
    private double maxrange;
    private RelativeEncoder hoodEncoder;
    private FlywheelMath flywheelMath;


    
    public FlyWheelHood(Flywheel flywheel) {
        this.flywheel = flywheel;
        maxrange = .5;
        targetangle = 50 / 2 / Math.PI;
    }

    @Override
    public void initialize() {
        hoodEncoder = flywheel.fwHoodEncoder;
        flywheel.resetFWEncoder(hoodEncoder);
    }

    @Override
    public void execute() {
        targetangle = flywheelMath.getTheta() / 2 / Math.PI;
        if(hoodEncoder.getPosition() < targetangle && hoodEncoder.getPosition() < maxrange) {
            flywheel.setFlywheelHood(.1);
        } else if (hoodEncoder.getPosition() > targetangle && hoodEncoder.getPosition() > 0) {
            flywheel.setFlywheelHood(-.1);
        } else {
            flywheel.setFlywheelHood(0);
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
