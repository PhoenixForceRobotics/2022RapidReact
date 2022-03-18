package frc.team2097.commands.Hood;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.team2097.subsystems.Flywheel;
import frc.team2097.utility.Constants;
import frc.team2097.utility.OI;

public class FlywheelHoodSequence extends SequentialCommandGroup {
    public FlywheelHoodSequence(Flywheel flywheel) {
        addCommands(new FlywheelHoodReset(flywheel), new FlywheelHood(flywheel));
    } 
   
}
