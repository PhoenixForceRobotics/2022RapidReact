package frc.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.subsystems.Climb;

public class DisableSolenoid extends InstantCommand{
    private Climb climb;
    
    public DisableSolenoid(Climb climb)
    {
        this.climb = climb;
        addRequirements(this.climb);
    }

    @Override
    public void initialize() {
        climb.off();
    }
}
