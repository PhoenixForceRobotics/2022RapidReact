package frc.robot.commands.climberautomated;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;

public class SeqPistonDuringRotate extends SequentialCommandGroup {
    public SeqPistonDuringRotate() {
        addCommands(
                new RunPistonExtend(Robot.climberSolenoids, 0.2),

                new RunPistonDetract(Robot.climberSolenoids, 0.2));
    }
}
