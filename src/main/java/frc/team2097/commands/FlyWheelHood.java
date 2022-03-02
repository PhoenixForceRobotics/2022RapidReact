package frc.team2097.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2097.subsystems.Flywheel;
import frc.team2097.utility.Constants;
import frc.team2097.utility.FlywheelMath;
import frc.team2097.utility.NetworkTableManager;

public class FlyWheelHood extends CommandBase {
    NetworkTableManager networkTableManager;

    private double pitchAngle;
    private Flywheel flywheel;
    private double maxDegree, minDegree;
    private double degreeRange;
    private double buffer;
    private double hoodRotations, relativeRotation;
    
    //45*-75*

    public FlyWheelHood(Flywheel flywheel) {
        this.flywheel = flywheel;
        // shoot angle
        maxDegree = 75;
        minDegree = 45;
        degreeRange = maxDegree - minDegree;
        // motor rotations to big roation
        // 90* big robation/motor roations = how much it spins every small motor spin
        buffer = 2;
        hoodRotations = 0;
        relativeRotation = /* degrees */ degreeRange * /* bigroations / */hoodRotations;
    }

    @Override
    public void initialize() {
        pitchAngle = FlywheelMath.getTheta();
    }

    @Override
    public void execute() {
        pitchAngle = FlywheelMath.getTheta();
        hoodRotations = flywheel.getFWHoodPos();
        relativeRotation = /* degrees 90 * bigroations / */hoodRotations;
        if(relativeRotation + minDegree >= pitchAngle - buffer && relativeRotation + minDegree <= pitchAngle + buffer) {
            flywheel.setFlywheelHood(0);
        } else if (relativeRotation > pitchAngle + buffer){
            flywheel.setFlywheelHood(Constants.MotorSpeeds.Flywheel.HOOD_SPEED * -1);
        } else {
            flywheel.setFlywheelHood(Constants.MotorSpeeds.Flywheel.HOOD_SPEED);   
        }
        
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
