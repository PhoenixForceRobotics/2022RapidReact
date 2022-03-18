package frc.team2097.commands.Turn;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.team2097.subsystems.Flywheel;
import frc.team2097.utility.Constants;
import frc.team2097.utility.OI;

public class FlywheelTurnSequence extends SequentialCommandGroup {
    public FlywheelTurnSequence(Flywheel flywheel) {
        addCommands(new FlywheelTurnReset(flywheel), new FlywheelTurn(flywheel));
    } 
   
}
