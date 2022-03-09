package frc.team2097.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2097.subsystems.Flywheel;

public class ToggleFlywheelPID extends CommandBase {
    private Flywheel flywheel;
    private boolean done;
    private boolean flyWheelStatus;

    public ToggleFlywheelPID(Flywheel flywheel) {
        this.flywheel = flywheel;
    }

    @Override
    public void initialize() {
        flyWheelStatus = flywheel.getToggleFlyWheel();
        // If true set to false. If false set it to true.
        if (flyWheelStatus == true) {
            flywheel.setToggleFlyWheel(false);
        } else {
            flywheel.setToggleFlyWheel(true);
        }
        done = true;
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {

        return done;
    }
}
