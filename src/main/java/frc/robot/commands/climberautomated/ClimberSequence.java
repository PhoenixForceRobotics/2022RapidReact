package frc.robot.commands.climberautomated;

import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class ClimberSequence extends SequentialCommandGroup
{
    private Climber climber;

    public ClimberSequence(Climber m_climber){
        climber = m_climber;
            addCommands(
                new RunFlimseyArm(0.6)
                
                
                );
    }
}