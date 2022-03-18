package frc.robot.commands.Hood;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Flywheel;
import frc.robot.utility.Constants;
import frc.robot.utility.OI;

public class FlywheelHoodSequence extends SequentialCommandGroup {
    public FlywheelHoodSequence(Flywheel flywheel) {
        addCommands(new FlywheelHoodReset(flywheel), new FlywheelHood(flywheel));
    } 
   
}
