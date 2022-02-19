package frc.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.subsystems.Drivebase;

public class TurnOnDrivebase extends InstantCommand {
    private Drivebase drivebase;

    public TurnOnDrivebase(Drivebase drivebase)
    {
        this.drivebase = drivebase;
        addRequirements(drivebase);
    }

    @Override
    public void initialize() {
        drivebase.set(1, 0);
    }
    
}
