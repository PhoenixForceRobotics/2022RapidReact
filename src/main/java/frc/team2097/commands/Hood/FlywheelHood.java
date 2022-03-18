package frc.team2097.commands.Hood;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2097.subsystems.Flywheel;
import frc.team2097.utility.Constants;
import frc.team2097.utility.FlywheelMath;
import frc.team2097.utility.NetworkTableManager;

public class FlywheelHood extends CommandBase {
    NetworkTableManager networkTableManager;

    private double pitchAngle;
    private Flywheel flywheel;
    private double maxDegree, minDegree;
    private double degreeRange;
    private double buffer;
    private double hoodRotations, relativeRotation;
    private double error;

    // 45*-75*

    public FlywheelHood(Flywheel flywheel) {
        this.flywheel = flywheel;
        // shoot angle
        maxDegree = 85;
        minDegree = 45;
        degreeRange = maxDegree - minDegree;
        // motor rotations to big roation
        // 40* big robation/motor roations = how much it spins every small motor spin
        buffer = 2;
        hoodRotations = 0;
        relativeRotation = degreeRange * .02039 * hoodRotations;
        error = 0;
    }

    @Override
        public void initialize() {
        pitchAngle = FlywheelMath.getTheta();
    }

    @Override
    public void execute() {
        // pitchAngle = FlywheelMath.getTheta();
        pitchAngle = 50;
        hoodRotations = flywheel.getFWHoodPos();
        error = pitchAngle - relativeRotation;
        relativeRotation = degreeRange * .02039 * hoodRotations;
        if (relativeRotation + minDegree >= pitchAngle - buffer
        && relativeRotation + minDegree <= pitchAngle + buffer) {
            flywheel.setFlywheelHood(0);
        } else {
            flywheel.setFlywheelHood(Constants.MotorSpeeds.Flywheel.HOOD_SPEED * error / 50);
        }

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
