package frc.robot.commands.climberautomated;

import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class ClimberSequence extends SequentialCommandGroup
{
    private Climber climber;

    public ClimberSequence(Climber m_climber){
        climber = m_climber;
            addCommands(
                new RunPistonExtend(),
                new RunButtonNextSequence(),
                new RunPistonDetract(),
                new RunButtonNextSequence(),
                new RunFlimseyArm(0.6, 0.005),
                new RunSpools(3, 0.005),
                new RunPistonExtend()
                );
    }
}