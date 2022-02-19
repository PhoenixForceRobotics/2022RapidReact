package frc.commands;

import frc.robot.Subsystems.Climb;

import edu.wpi.first.wpilibj2.command.InstantCommand;

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
