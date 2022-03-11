package frc.team2097.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.team2097.Drivebase;
import frc.team2097.subsystems.Turret;
import frc.team2097.utils.OI;
import frc.team2097.utils.PFRController;

public class Rotate extends CommandBase {
    private Turret turret;
    private PFRController driverController;

    public Rotate(Turret turret, OI oi)
    {
        this.turret = turret;
        driverController = oi.driverController;
        addRequirements(turret);
    }

    @Override
    public void execute() {
        turret.rotate(driverController.getLeftX());
    }
}
