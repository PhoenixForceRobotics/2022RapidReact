package frc.team2097.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2097.subsystems.Flywheel;
import frc.team2097.utility.PID;
import frc.team2097.utility.FlywheelMath;
import frc.team2097.utility.NetworkTableManager;

public class FlywheelHoodIntegratedPIDAttempt extends CommandBase {
    NetworkTableManager networkTableManager;

    private double pitchAngle;
    private Flywheel flywheel;
    private double maxDegree, minDegree;
    private double degreeRange;
    private double buffer;
    private double hoodRotations, relativeRotation;

    private PID pid;
    public double pidSpeed;
    public double motorSpeed;
    public double maxSpeed;

    // 45*-75*

    public FlywheelHoodIntegratedPIDAttempt(Flywheel flywheel, PID pid) {
        this.flywheel = flywheel;
        this.pid = pid;
        // shoot angle
        maxDegree = 85;
        minDegree = 45;
        degreeRange = maxDegree - minDegree;
        // motor rotations to big roation
        // 90* big robation/motor roations = how much it spins every small motor spin
        buffer = 2;
        hoodRotations = 0;
        relativeRotation = /* degrees */ degreeRange * /* bigroations / */hoodRotations;

        // Set to something new
        maxSpeed = 0.5;

    }

    @Override
    public void initialize() {
        pitchAngle = FlywheelMath.getTheta();

        pid.newPIDSetTolerance(buffer);
    }

    @Override
    public void execute() {
        pitchAngle = FlywheelMath.getTheta();
        hoodRotations = flywheel.getFWHoodPos();
        relativeRotation = /* degrees 90 * bigroations / */hoodRotations;

        pid.newPIDSetSetPoint(pitchAngle - minDegree);

        if (pid.newPIDAtSetPoint()) {
            flywheel.setFlywheelHood(0);
        } else {
            pidSpeed = pid.newPIDCalculate(relativeRotation);

            if (pidSpeed > 0) {
                motorSpeed = Math.min(pidSpeed, maxSpeed);
            } else {
                motorSpeed = Math.max(pidSpeed, maxSpeed * -1);
            }
            flywheel.setFlywheelHood(motorSpeed);
        }

        // if(relativeRotation + minDegree >= pitchAngle - buffer && relativeRotation +
        // minDegree <= pitchAngle + buffer) {
        // flywheel.setFlywheelHood(0);
        // } else if (relativeRotation > pitchAngle + buffer){
        // flywheel.setFlywheelHood(Constants.MotorSpeeds.Flywheel.HOOD_SPEED * -1);
        // } else {
        // flywheel.setFlywheelHood(Constants.MotorSpeeds.Flywheel.HOOD_SPEED);
        // }

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
