package frc.team2097.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.team2097.Drivebase;

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
