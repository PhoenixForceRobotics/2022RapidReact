package frc.robot.commands;

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.utility.FlywheelMath;
import frc.robot.subsystems.Flywheel;

//range 50 - 85 degreess, 5 rotations, 1 is 9 degrees :D
public class FlyWheelHood extends CommandBase{
    private Flywheel flywheel;
    private double targetangle;
    private double gearRatio, degreeRange, startDegree;
    private RelativeEncoder hoodEncoder;
    private FlywheelMath flywheelMath;


    
    public FlyWheelHood(Flywheel flywheel) {
        this.flywheel = flywheel;
        targetangle = 50 / 2 / Math.PI;
        degreeRange = 40;
        startDegree = 50;
        gearRatio = 5;
    }

    @Override
    public void initialize() {
        hoodEncoder = flywheel.fwHoodEncoder;
    }

    @Override
    public void execute() {
        targetangle = flywheelMath.getTheta() / 2 / Math.PI;
        if(hoodEncoder.getPosition() / gearRatio * degreeRange + startDegree < targetangle + 2) {
            flywheel.setFlywheelHood(.1);
        } else if (hoodEncoder.getPosition() / gearRatio * degreeRange + startDegree > targetangle - 2) {
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
