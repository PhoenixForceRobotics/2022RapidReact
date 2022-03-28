package frc.robot.commands.turret;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.subsystems.Turret;

public class TurnOffFlywheel extends InstantCommand {
    private Turret turret;

    public TurnOffFlywheel(Turret turret)
    {
        this.turret = turret;
    }
    
    @Override
    protected void initialize() {
        turret.setFlywheelPercent(0);
    }

}
