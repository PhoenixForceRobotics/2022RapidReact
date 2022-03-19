package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Climber;

public class ClimbUp extends InstantCommand
{
    Climber climber;
    public ClimbUp(Climber climber)
    {
        this.climber = climber;
        addRequirements(climber);
    }

    @Override
    public void initialize() {
        climber.climberUp();
    }
}